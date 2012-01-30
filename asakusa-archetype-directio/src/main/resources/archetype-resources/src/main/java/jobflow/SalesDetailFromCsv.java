#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * Copyright 2011 Asakusa Framework Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package}.jobflow;

import ${package}.modelgen.dmdl.csv.AbstractSalesDetailCsvInputDescription;

/**
 * 売上明細をWindGate/CSVからインポートする。
 * インポート対象ファイルは {@code sales/<date:日付>.csv}。
 */
public class SalesDetailFromCsv extends AbstractSalesDetailCsvInputDescription {

    @Override
    public String getBasePath() {
        return "sales";
    }

    @Override
    public String getResourcePattern() {
        return "**/*.csv";
    }

    @Override
    public DataSize getDataSize() {
        return DataSize.LARGE;
    }
}
