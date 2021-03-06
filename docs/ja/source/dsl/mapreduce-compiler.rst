===============================================
Asakusa DSL Compiler for MapReduce リファレンス
===============================================

この文書では、MapReduce向けのDSLコンパイラの利用方法について紹介します。

.. _mapreduce-compile-options:

コンパイルオプション
~~~~~~~~~~~~~~~~~~~~

ここではMapReduce DSLコンパイラのコンパイルオプションについて説明します。

Asakusa Gradle Pluginを利用したアプリケーションプロジェクトでは、コンパイルオプションは ``asakusafw`` ブロック内の参照名 ``mapreduce`` から設定します。

**build.gradle**

..  code-block:: groovy
    
    asakusafw {
        mapreduce {
            include 'com.example.batch.*'
            compilerProperties += ['hashJoinForTiny':'false']
        }

..  seealso::
    ``mapreduce`` ブロックに対する設定について詳しくは :doc:`../application/gradle-plugin-reference` などを参照してください。

MapReduce DSLコンパイラで利用可能なコンパイルオプションを以下に示します。

..  list-table:: Asakusa DSL Compiler for MapReduce - コンパイルオプション
    :widths: 2 1 7
    :header-rows: 1

    * - 項目名
      - 既定値
      - 概要
    * - ``enableCombiner``
      - 無効
      - 部分集約 [#]_ の既定値。

        部分集約を許す演算子に対して ``PartialAggregation.DEFAULT`` が [#]_ 指定された場合に、このオプションが有効であれば部分集約を行い、そうでなければ行わない。
    * - ``compressFlowPart``
      - 有効
      - ステージ数が少なくなる方法でフロー演算子を展開する。

        このオプションが無効であればフロー演算子の展開時に全ての入出力にチェックポイント演算子を挿入する。
        このオプションが有効であれば、展開時に何も挿入しない。
    * - ``compressConcurrentStage``
      - 有効
      - 互いに影響のないステージを1つのステージに合成する。

        このオプションが有効であれば、互いに依存関係のない2つ以上のステージを単一のステージに合成し、無効であれば合成しない。
    * - ``hashJoinForTiny``
      - 有効
      - データサイズに ``DataSize.TINY`` と指定したジョブフローの入力をマスタとして結合する際に、可能であればハッシュ表での結合を行う。

        このオプションが有効であれば上記の動作を行い、無効であればコンパイラが自動的に結合戦略を決定する。
    * - ``hashJoinForSmall``
      - 無効
      - 将来の拡張のためにリザーブされた項目。現在は動作に影響しない。
    * - ``enableDebugLogging``
      - 無効
      - ``Logging.Level.DEBUG`` が指定されたロギング演算子を利用可能にする。

        このオプションが有効であれば、そのようなロギング演算子をコンパイル後も保持する。
        無効であれば、コンパイル時にそれらの演算子を除去する。

上記の他に、 ``X`` から始まるいくつかの `コンパイラスイッチ`_ も存在します。
コンパイラスイッチもコンパイルオプションと同じシステムプロパティを利用します。

..  note::
    ``compressFlowPart`` の既定値は0.2から「有効」に変更しました。
    チェックポイント演算子はMapReduceの単位 (ステージ) に区切りをいれる演算子で、元は「フロー部品のテスト時とできるだけ同じ構造にしたほうが良い」という前提でこのオプションを無効化していました。
    しかし、あまりにMapReduceの回数が増えてしまい、処理効率が著しく低下するため、0.2よりこの規定値が見直されることになりました。

..  note::
    ``compressConcurrentStage`` は利点と欠点のある最適化です。
    この最適化により、ステージ数は最小で「クリティカルパスのステージ数」まで低下します。
    しかし、ここで合成されるステージは本来互いに影響がありませんので、Hadoopはこれらのステージを同時に処理することが可能です。

    この最適化の欠点は、時間のかかるステージとかからないステージを合成してしまうと、後者のステージが本来先に終わる場合でも、前者のステージの処理が完了するまで余計な待ち合わせが発生してしまう点です。
    Hadoopクラスタが十分に大きく、ワークフローエンジンが並列のジョブ投入をサポートしている場合は、このオプションは見直すべきでしょう。

..  note::
    ``hashJoinForTiny`` は、Hadoopの *DistributedCache* の仕組みを利用しています。
    ハッシュ表での結合を行う場合、入力データをHadoopクラスタの全てのノードに配布します。
    そこでハッシュ表を構築し、タスクのメモリ上に保持します。

    現在の標準的な結合戦略はShuffle+Sortを利用したマージ結合であるため、これは結合操作を行うたびにReduceフェーズが必要になってしまいます。
    結果としてMapReduceのステージ数が増大してしまいますが、ハッシュ表を利用する場合には全てのノードのメモリ上に表を構築しているため、Reduce処理が不要になり、ステージ数を削減できるという利点があります。

    ただし、およそハッシュ表の元になったデータサイズの倍程度のメモリを必要とするため、適用範囲が限られてしまうという問題はあります。

..  [#] 部分集約の設定については、 :doc:`operators` の単純集計演算子や畳み込み演算子を参照してください。
..  [#] :javadoc:`com.asakusafw.vocabulary.flow.processor.PartialAggregation`

コンパイラスイッチ
~~~~~~~~~~~~~~~~~~

コンパイラスイッチはコンパイラの内部的な挙動を操作するためのオプションで、 `コンパイルオプション`_ と同様の方法で設定します。

..  hint::
    通常の場合、コンパイラスイッチを指定する必要はありません。
    コンパイル時にコンパイラから推奨される場合がありますので、その際に利用を検討してください。

すべてのコンパイラスイッチは ``X<項目名>=<値>`` の形式で設定します。
以下は変更可能なコンパイラスイッチの一覧です。

..  list-table:: コンパイラスイッチの項目
    :widths: 2 1 7
    :header-rows: 1

    * - 項目名
      - 既定値
      - 概要
    * - ``MAPREDUCE-370``
      - ``DISABLED``
      - 利用中のHadoopにパッチ ``MAPREDUCE-370`` が適用済みかどうか。
        ``ENABLED`` の場合は適用済みと仮定し、 ``DISABLED`` の場合は未適用と仮定する。
    * - ``compressFlowBlockGroup``
      - ``ENABLED``
      - `コンパイルオプション`_ の ``compressConcurrentStage`` を適用した際、ステージ内のMapperとReducerを併合するかどうか。
        ``ENABLED`` の場合は併合し、 ``DISABLED`` の場合は併合しない。
    * - ``packaging``
      - ``ENABLED``
      - アプリケーションのパッケージングを行うかどうか。
    * - ``javaVersion``
      - ``1.7`` [#]_
      - DSLコンパイラがコンパイル時に指定するJavaのバージョン

..  tip::
    コンパイルオプションは項目名を間違えた場合にエラーとなりますが、コンパイラスイッチは項目名を間違えると単に設定が無視されます。

..  [#] :doc:`../application/gradle-plugin` に従ってアプリケーションプロジェクトを作成した場合は、Gradle Pluginの設定値が適用されます。詳しくは :doc:`../application/gradle-plugin-reference` を参照してください。
