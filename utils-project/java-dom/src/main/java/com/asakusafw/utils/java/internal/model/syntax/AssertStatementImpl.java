/**
 * Copyright 2011-2016 Asakusa Framework Team.
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
package com.asakusafw.utils.java.internal.model.syntax;

import com.asakusafw.utils.java.model.syntax.AssertStatement;
import com.asakusafw.utils.java.model.syntax.Expression;
import com.asakusafw.utils.java.model.syntax.ModelKind;
import com.asakusafw.utils.java.model.syntax.Visitor;

/**
 * An implementation of {@link AssertStatement}.
 */
public final class AssertStatementImpl extends ModelRoot implements AssertStatement {

    private Expression expression;

    private Expression message;

    @Override
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Sets the assertion expression.
     * @param expression the assertion expression
     * @throws IllegalArgumentException if {@code expression} was {@code null}
     */
    public void setExpression(Expression expression) {
        Util.notNull(expression, "expression"); //$NON-NLS-1$
        this.expression = expression;
    }

    @Override
    public Expression getMessage() {
        return this.message;
    }

    /**
     * Sets the message expression.
     * @param message the message expression, or {@code null} if it is not specified
     */
    public void setMessage(Expression message) {
        this.message = message;
    }

    /**
     * Returns {@link ModelKind#ASSERT_STATEMENT} which represents this element kind.
     * @return {@link ModelKind#ASSERT_STATEMENT}
     */
    @Override
    public ModelKind getModelKind() {
        return ModelKind.ASSERT_STATEMENT;
    }

    @Override
    public <R, C, E extends Throwable> R accept(Visitor<R, C, E> visitor, C context) throws E {
        Util.notNull(visitor, "visitor"); //$NON-NLS-1$
        return visitor.visitAssertStatement(this, context);
    }
}
