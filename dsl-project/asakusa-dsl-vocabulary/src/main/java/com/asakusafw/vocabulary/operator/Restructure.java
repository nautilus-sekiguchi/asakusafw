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
package com.asakusafw.vocabulary.operator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;

/**
 * Represents <em>restructure</em> operator annotation.
 * Application developers should use {@link CoreOperatorFactory#restructure(Source)} instead of operator methods.
 * @see CoreOperatorFactory#restructure(Source)
 * @see CoreOperatorFactory#restructure(Source, Class)
 * @since 0.2.1
 */
@Target({ })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Restructure {

    /**
     * The input port number.
     */
    int ID_INPUT = 0;

    /**
     * The output port number.
     */
    int ID_OUTPUT = 0;
}
