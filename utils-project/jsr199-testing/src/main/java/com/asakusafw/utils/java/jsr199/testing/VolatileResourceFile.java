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
package com.asakusafw.utils.java.jsr199.testing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.tools.FileObject;

/**
 * A {@link FileObject} implementation which is stored on the heap.
 */
public class VolatileResourceFile implements FileObject {

    /**
     * The schema name of this kind of resources.
     */
    public static final String URI_SCHEME = VolatileResourceFile.class.getName();

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private final URI uri;

    volatile byte[] contents;

    volatile long lastModified;

    /**
     * Creates a new instance.
     * @param path the relative path from the source path
     * @throws IllegalArgumentException if the parameter is {@code null}
     */
    public VolatileResourceFile(String path) {
        this.uri = toUriFromPath(path);
    }

    @Override
    public URI toUri() {
        return uri;
    }

    @Override
    public String getName() {
        String path = uri.getPath();
        return path.substring(path.lastIndexOf('/') + 1);
    }

    @Override
    public InputStream openInputStream() throws IOException {
        if (contents == null) {
            throw new IOException();
        }
        return new ByteArrayInputStream(contents);
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return new ByteArrayOutputStream() {
            @Override
            public void close() throws IOException {
                super.close();
                contents = toByteArray();
                lastModified = System.currentTimeMillis();
            }
        };
    }

    @Override
    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
        return new InputStreamReader(openInputStream(), CHARSET);
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return new String(contents, CHARSET);
    }

    @Override
    public Writer openWriter() throws IOException {
        return new OutputStreamWriter(openOutputStream(), CHARSET);
    }

    @Override
    public long getLastModified() {
        if (contents == null) {
            return 0L;
        }
        return lastModified;
    }

    @Override
    public boolean delete() {
        if (contents == null) {
            return false;
        }
        contents = null;
        return true;
    }

    private static URI toUriFromPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("path must not be null"); //$NON-NLS-1$
        }
        try {
            return new URI(
                URI_SCHEME,
                null,
                "/" + path.replace('\\', '/'), //$NON-NLS-1$
                null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
