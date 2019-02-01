/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.api.resource;

import java.io.File;

/**
 * This interface provides a standard method for getting a Java File representation of resource representing a file or binary data. 
 * For example it may be a resource representing JCR node of type "nt:file" or a node with jcr:data property.  
 * Implementations should make resources that can be represented as files adaptable to this interface.
 * 
 * Callers must call release() method after processing the file to allow implementations to release 
 * any system resources associated with the file.
 * 
 * <string>Caution:<strong> Implementations of this interface may require additional system resources such as creation of 
 * temporary files. In most cases the standard Sling pattern of adapting a resource to java.io.InputStream should be preferred. 
 * 
 *  <P>
 *  Usage example:
 *  <code>
 *  InternalFileProvider fileProvider = resource.adaptTo(InternalFileProvider.class);
 *  File f = fileProvider.getFile();
 *  
 *  // Do somethind useful with the file.
 *  
 *  fileProvider.release();
 *  <code>
 *  <P>
 * 
 * @author hsaginor
 *
 */
public interface InternalFileProvider {

    /**
     * Get file representation of binary data represented by a resource this instance was adapted from.
     *  
     * @return File
     */
    File getFile();

    /**
     * Release any internal system resources after process the file.
     */
    void release();
}
