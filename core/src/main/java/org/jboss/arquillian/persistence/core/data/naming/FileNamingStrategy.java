/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.persistence.core.data.naming;

import java.lang.reflect.Method;

/**
 * Creates file name for test class or test method
 * <p>
 * <ul>
 * <li>
 * If used for method, file name has following format:
 * <i>[fully qualified class name]#[test method name].[provided file extension]</i>.
 * </li>
 * <li>
 * If used for class, file name has following format:
 * <i>[fully qualified class name].[provided file extension]</i></li>.
 * </ul>
 *
 * @param <T>
 * @author <a href="mailto:bartosz.majsak@gmail.com">Bartosz Majsak</a>
 */
public abstract class FileNamingStrategy<T> {

    protected final T extension;

    public FileNamingStrategy(T extension) {
        this.extension = extension;
    }

    public abstract String getFileExtension();

    public String createFileName(Class<?> testClass, Method testMethod) {
        return testClass.getName() + "#" + testMethod.getName() + "." + getFileExtension();
    }

    public String createFileName(Class<?> testClass) {
        return testClass.getName() + "." + getFileExtension();
    }

}
