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
package com.asakusafw.directio.hive.serde;

import org.apache.hadoop.hive.serde2.objectinspector.primitive.ShortObjectInspector;

import com.asakusafw.runtime.value.ShortOption;
import com.asakusafw.runtime.value.ValueOption;

/**
 * An implementation of {@link ValueDriver} for {@link ShortOption}.
 * @since 0.7.0
 */
public class ShortOptionDriver extends AbstractValueDriver {

    private final ShortObjectInspector inspector;

    /**
     * Creates a new instance.
     * @param inspector the object inspector
     */
    public ShortOptionDriver(ShortObjectInspector inspector) {
        this.inspector = inspector;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void set(ValueOption<?> target, Object value) {
        if (value == null) {
            target.setNull();
        } else {
            ((ShortOption) target).modify(inspector.get(value));
        }
    }
}
