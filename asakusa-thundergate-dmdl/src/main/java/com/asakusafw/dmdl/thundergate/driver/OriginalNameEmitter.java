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
package com.asakusafw.dmdl.thundergate.driver;

import java.util.Collections;
import java.util.List;

import com.asakusafw.dmdl.java.emitter.EmitContext;
import com.asakusafw.dmdl.java.spi.JavaDataModelDriver;
import com.asakusafw.dmdl.semantics.Declaration;
import com.asakusafw.dmdl.semantics.ModelDeclaration;
import com.asakusafw.dmdl.semantics.PropertyDeclaration;
import com.asakusafw.vocabulary.bulkloader.OriginalName;
import com.ashigeru.lang.java.model.syntax.Annotation;
import com.ashigeru.lang.java.model.syntax.Expression;
import com.ashigeru.lang.java.model.syntax.MethodDeclaration;
import com.ashigeru.lang.java.model.syntax.ModelFactory;
import com.ashigeru.lang.java.model.syntax.Type;
import com.ashigeru.lang.java.model.util.AttributeBuilder;
import com.ashigeru.lang.java.model.util.Models;

/**
 * Emits {@link OriginalName} annotations.
 */
public class OriginalNameEmitter implements JavaDataModelDriver {

    @Override
    public List<Type> getInterfaces(EmitContext context, ModelDeclaration model) {
        return Collections.emptyList();
    }

    @Override
    public List<MethodDeclaration> getMethods(EmitContext context, ModelDeclaration model) {
        return Collections.emptyList();
    }

    @Override
    public List<Annotation> getTypeAnnotations(EmitContext context, ModelDeclaration model) {
        ModelFactory f = context.getModelFactory();
        Expression value;
        OriginalNameTrait trait = model.getTrait(OriginalNameTrait.class);
        if (trait == null) {
            value = Models.toLiteral(f, getDefaultName(model));
        } else {
            value = Models.toLiteral(f, trait.getName());
        }
        return new AttributeBuilder(f)
            .annotation(context.resolve(OriginalName.class), "value", value)
            .toAnnotations();
    }

    @Override
    public List<Annotation> getMemberAnnotations(EmitContext context, PropertyDeclaration property) {
        OriginalNameTrait trait = property.getTrait(OriginalNameTrait.class);
        if (trait == null) {
            return Collections.emptyList();
        }

        ModelFactory f = context.getModelFactory();
        Expression value = Models.toLiteral(f, trait.getName());
        return new AttributeBuilder(f)
            .annotation(context.resolve(OriginalName.class), "value", value)
            .toAnnotations();
    }

    /**
     * Inferres the original name.
     * <p>
     * This just returns uppercase name of the specified declaration.
     * </p>
     * @param declaration the declaration
     * @return the inferred name
     * @throws IllegalArgumentException if some parameters were {@code null}
     */
    public static String getDefaultName(Declaration declaration) {
        if (declaration == null) {
            throw new IllegalArgumentException("declaration must not be null"); //$NON-NLS-1$
        }
        return declaration.getName().getSimpleName().identifier.toUpperCase();
    }
}