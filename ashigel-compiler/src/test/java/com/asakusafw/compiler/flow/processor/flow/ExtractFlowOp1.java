/**
 * Copyright 2011-2012 Asakusa Framework Team.
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
package com.asakusafw.compiler.flow.processor.flow;

import com.asakusafw.compiler.flow.processor.ExtractFlowProcessor;
import com.asakusafw.compiler.flow.processor.operator.ExtractFlowFactory;
import com.asakusafw.compiler.flow.processor.operator.ExtractFlowFactory.Op1;
import com.asakusafw.compiler.flow.testing.external.Ex1MockExporterDescription;
import com.asakusafw.compiler.flow.testing.external.Ex1MockImporterDescription;
import com.asakusafw.compiler.flow.testing.model.Ex1;
import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;


/**
 * {@link ExtractFlowProcessor}のテスト。
 */
@JobFlow(name = "testing")
public class ExtractFlowOp1 extends FlowDescription {

    private In<Ex1> in1;

    private Out<Ex1> out1;

    /**
     * インスタンスを生成する。
     * @param in1 入力
     * @param out1 出力
     */
    public ExtractFlowOp1(
            @Import(name = "in", description = Ex1MockImporterDescription.class)
            In<Ex1> in1,
            @Export(name = "out1", description = Ex1MockExporterDescription.class)
            Out<Ex1> out1) {
        this.in1 = in1;
        this.out1 = out1;
    }

    @Override
    protected void describe() {
        ExtractFlowFactory f = new ExtractFlowFactory();
        Op1 op = f.op1(in1);
        out1.add(op.r1);
    }
}
