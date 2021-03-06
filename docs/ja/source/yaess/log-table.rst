=====================
YAESSに関するログ一覧
=====================

この文書では、YAESSが利用するログの一覧を紹介します。

YAESS本体のログ
---------------

YAESSのプラグイン部分を除く本体が出力するログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 10 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-BOOTSTRAP-I00000``
      - 情報
      - YAESS全体を開始
    * - ``YS-BOOTSTRAP-I00999``
      - 情報
      - YAESS全体を終了
    * - ``YS-BOOTSTRAP-I00001``
      - 情報
      - ジョブネットを起動
    * - ``YS-BOOTSTRAP-E00001``
      - エラー
      - YAESSの起動引数が不正
    * - ``YS-BOOTSTRAP-E00002``
      - エラー
      - YAESSのプラグイン初期化に失敗した
    * - ``YS-BOOTSTRAP-E00003``
      - エラー
      - ジョブネットの実行に失敗した
    * - ``YS-BOOTSTRAP-E01001``
      - エラー
      - YAESSのプロファイル設定を読み出せない
    * - ``YS-BOOTSTRAP-E01002``
      - エラー
      - YAESSのジョブネットスクリプトファイルを読み出せない
    * - ``YS-BOOTSTRAP-W99001``
      - 警告
      - プラグインライブラリの読み出しに失敗
    * - ``YS-CORE-I01000``
      - 情報
      - バッチの実行を開始
    * - ``YS-CORE-I01999``
      - 情報
      - バッチの実行を終了
    * - ``YS-CORE-I01001``
      - 情報
      - バッチの実行が正常終了した
    * - ``YS-CORE-I01003``
      - 情報
      - ジョブフローの実行をスケジュールした
    * - ``YS-CORE-I01004``
      - 情報
      - 実行中またはスケジュールされたジョブフローの実行をキャンセル
    * - ``YS-CORE-I01005``
      - 情報
      - ジョブフローの実行がキャンセルされた
    * - ``YS-CORE-W01001``
      - 警告
      - バッチの実行中に割り込みが要求された
    * - ``YS-CORE-W01002``
      - 警告
      - スケジュールされたジョブフローのシャットダウンに失敗した
    * - ``YS-CORE-E01001``
      - エラー
      - バッチの実行が異常終了した
    * - ``YS-CORE-I02000``
      - 情報
      - ジョブフローの実行を開始
    * - ``YS-CORE-I02999``
      - 情報
      - ジョブフローの実行を終了
    * - ``YS-CORE-I02001``
      - 情報
      - ジョブフローの実行が正常終了した
    * - ``YS-CORE-I02002``
      - 情報
      - ジョブフローの実行をスキップした
    * - ``YS-CORE-I02003``
      - 情報
      - ジョブフローの実行が中断されたため、finalizeフェーズを実行開始
    * - ``YS-CORE-W02001``
      - 警告
      - ジョブフローの実行中に割り込みが要求された
    * - ``YS-CORE-W02002``
      - 警告
      - ジョブフローの実行が中断されたため、finalizeフェーズを実行したが失敗した
    * - ``YS-CORE-W02003``
      - 警告
      - cleanupフェーズの実行に失敗 (ジョブフロー全体としては成功)
    * - ``YS-CORE-E02001``
      - エラー
      - ジョブフローの実行が異常終了した
    * - ``YS-CORE-I03000``
      - 情報
      - フェーズの実行を開始
    * - ``YS-CORE-I03999``
      - 情報
      - フェーズの実行を終了
    * - ``YS-CORE-I03001``
      - 情報
      - フェーズの実行が正常終了した
    * - ``YS-CORE-I03002``
      - 情報
      - フェーズの実行をスキップした
    * - ``YS-CORE-W03001``
      - 警告
      - フェーズの実行中に割り込みが要求された
    * - ``YS-CORE-E03001``
      - エラー
      - フェーズの実行が異常終了した
    * - ``YS-CORE-I04000``
      - 情報
      - ジョブの実行を開始
    * - ``YS-CORE-I04999``
      - 情報
      - ジョブの実行を終了
    * - ``YS-CORE-I04001``
      - 情報
      - ジョブフローの実行が正常終了した
    * - ``YS-CORE-W04001``
      - 警告
      - ジョブの実行中に割り込みが要求された
    * - ``YS-CORE-E04001``
      - エラー
      - ジョブの実行が異常終了した
    * - ``YS-CORE-E10001``
      - エラー
      - プロファイルに指定された環境変数の展開に失敗した
    * - ``YS-CORE-I51001``
      - 情報
      - setupジョブで行うべきことがなにもなかった
    * - ``YS-CORE-I51002``
      - 情報
      - cleanupジョブで行うべきことがなにもなかった
    * - ``YS-CORE-W99001``
      - 警告
      - 出力のリダイレクト中に出力先にデータを書き出せなかった
    * - ``YS-CORE-W99002``
      - 警告
      - 出力のリダイレクト中に入力元からデータを読み出せなかった
    * - ``YS-CORE-W99003``
      - 警告
      - 出力のリダイレクト後に出力先を正常に閉じられなかった
    * - ``YS-CORE-W99004``
      - 警告
      - 出力のリダイレクト後に入力元を正常に閉じられなかった

YAESS組み込みプラグインに関するログ
-----------------------------------

クラス名が ``com.asakusafw.yaess.basic.Basic`` から始まる組み込みのプラグインを利用する部分のログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 15 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-BASIC-W10001``
      - 警告
      - 廃止されたプロパティを利用している
    * - ``YS-BASIC-E21001``
      - エラー
      - (廃止) ジョブスケジューラがジョブの実行中にエラーが発生した
    * - ``YS-BASIC-W41001``
      - 警告
      - 実行ロックの開放に失敗した
    * - ``YS-BASIC-W41002``
      - 警告
      - 実行ロック完了後にファイルを正常に閉じられなかった
    * - ``YS-BASIC-W41003``
      - 警告
      - 実行ロック完了後にファイルを削除できなかった
    * - ``YS-BASIC-E41001``
      - エラー
      - バッチ実行時に実行ロックを取得できなかった
    * - ``YS-BASIC-E41002``
      - エラー
      - ジョブフロー実行時にロックを取得できなかった
    * - ``YS-BASIC-I51001``
      - 情報
      - Hadoopのクリーンアップ処理を開始しようとしている
    * - ``YS-BASIC-I51002``
      - 情報
      - Hadoopのクリーンアップ処理を設定によりスキップした

ジョブの並列実行プラグインに関するログ
--------------------------------------

ジョブの並列実行 ( ``asakusa-yaess-paralleljob`` ) を利用する部分のログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 10 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-PARALLELJOB-I01001``
      - 情報
      - 指定のリソースプールを利用してジョブを実行する
    * - ``YS-PARALLELJOB-W01001``
      - 警告
      - 指定されたリソースに対するリソースプールが定義されていない (defaultを利用して実行する)


SSH接続プラグインに関するログ
-----------------------------

SSHによるジョブの実行 ( ``asakusa-yaess-jsch`` ) を利用する部分のログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 10 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-JSCH-I00001``
      - 情報
      - SSHのセッションを開始しようといている
    * - ``YS-JSCH-I00002``
      - 情報
      - SSHのセッションを開始した
    * - ``YS-JSCH-I00003``
      - 情報
      - SSHを利用してコマンドの実行を開始しようとしている
    * - ``YS-JSCH-I00004``
      - 情報
      - SSHを利用してコマンドの実行を開始した
    * - ``YS-JSCH-I00005``
      - 情報
      - SSHのセッションを終了した
    * - ``YS-JSCH-W00001``
      - 警告
      - SSHを利用したコマンドの実行時に、正しくない形式の環境変数の転送を省略した
    * - ``YS-JSCH-E00001``
      - エラー
      - SSHのセッション内で処理が失敗した

ジョブフローごとの進捗状況出力プラグインに関するログ
----------------------------------------------------

ジョブフローごとの進捗状況出力 ( ``asakusa-yaess-flowlog`` ) を利用する部分のログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 15 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-FLOWLOG-I01001``
      - 情報
      - 前回退避したジョブフローの進捗状況ファイルを削除開始
    * - ``YS-FLOWLOG-I01002``
      - 情報
      - 成功したジョブフローの進捗状況ファイルを削除開始
    * - ``YS-FLOWLOG-I01003``
      - 情報
      - 成功したジョブフローの進捗状況ファイルを退避開始
    * - ``YS-FLOWLOG-W01001``
      - 警告
      - 進捗状況ファイルの出力先ディレクトリの作成に失敗した
    * - ``YS-FLOWLOG-W01002``
      - 警告
      - 前回退避したジョブフローの進捗状況ファイルの削除に失敗した
    * - ``YS-FLOWLOG-W01003``
      - 警告
      - 成功したジョブフローの進捗状況ファイルの削除に失敗した
    * - ``YS-FLOWLOG-W01004``
      - 警告
      - 成功したジョブフローの進捗状況ファイルの退避に失敗した

実行クラスタ振り分けプラグインに関するログ
------------------------------------------

実行クラスタ振り分け ( ``asakusa-yaess-multidispatch`` ) を利用する部分のログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 15 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-MULTIDISPATCH-I00001``
      - 情報
      - プロファイルに指定された振り分け設定ディレクトリが存在しない
    * - ``YS-MULTIDISPATCH-I01001``
      - 情報
      - setupフェーズのジョブを指定のサブハンドラで実行開始
    * - ``YS-MULTIDISPATCH-I01002``
      - 情報
      - ジョブを指定のサブハンドラで実行開始
    * - ``YS-MULTIDISPATCH-I01003``
      - 情報
      - cleanupフェーズのジョブを指定のサブハンドラで実行開始
    * - ``YS-MULTIDISPATCH-E01001``
      - エラー
      - 振り分け設定ファイルの読み込みに失敗した

ジョブキュープラグインに関するログ
----------------------------------

ジョブキュー ( ``asakusa-yaess-jobqueue`` ) を利用する部分のログは以下の通りです。

..  list-table:: YAESS本体のログ
    :widths: 15 5 30
    :header-rows: 1

    * - ログコード
      - レベル
      - 概要
    * - ``YS-JOBQUEUE-I01001``
      - 情報
      - ジョブキューサーバへのジョブ登録処理を開始
    * - ``YS-JOBQUEUE-I01002``
      - 情報
      - ジョブキューサーバへのジョブ登録処理を終了
    * - ``YS-JOBQUEUE-I01003``
      - 情報
      - 登録されたジョブの実行予約処理を開始
    * - ``YS-JOBQUEUE-I01004``
      - 情報
      - 登録されたジョブの実行予約処理を終了
    * - ``YS-JOBQUEUE-I01005``
      - 情報
      - 実行予約したジョブの監視を開始
    * - ``YS-JOBQUEUE-I01006``
      - 情報
      - 実行予約したジョブの監視を終了
    * - ``YS-JOBQUEUE-W01001``
      - 警告
      - 一つのクライアントでジョブキューサーバへのジョブ登録に失敗した
    * - ``YS-JOBQUEUE-E01001``
      - エラー
      - すべてのクライアントでジョブキューサーバへのジョブ登録に失敗した
    * - ``YS-JOBQUEUE-E01002``
      - エラー
      - 登録されたジョブの実行予約に失敗した
    * - ``YS-JOBQUEUE-E01003``
      - エラー
      - 実行予約したジョブの監視に失敗した
