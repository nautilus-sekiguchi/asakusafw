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
package com.asakusafw.testdriver.compiler;

/**
 * Represents a task.
 * @since 0.8.0
 */
public interface TaskMirror extends GraphElement<TaskMirror> {

    /**
     * Returns the task module name.
     * @return the task module name
     */
    String getModuleName();

    /**
     * Represents a task phase.
     */
    public enum Phase {

        /**
         * Initialization.
         */
        INITIALIZE,

        /**
         * Importing input data.
         */
        IMPORT,

        /**
         * Pre-processing input data.
         */
        PROLOGUE,

        /**
         * Processing data.
         */
        MAIN,

        /**
         * Post-processing output data.
         */
        EPILOGUE,

        /**
         * Exporting output data.
         */
        EXPORT,

        /**
         * Finalization.
         */
        FINALIZE,
        ;
    }
}
