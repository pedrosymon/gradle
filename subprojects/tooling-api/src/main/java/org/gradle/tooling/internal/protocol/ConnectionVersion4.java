/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.tooling.internal.protocol;

/**
 * Represents a connection to a particular Gradle implementation.
 *
 * DO NOT CHANGE THIS INTERFACE. It is part of the cross-version protocol.
 */
public interface ConnectionVersion4 {
    /**
     * Stops this connection, blocking until complete.
     */
    void stop();

    /**
     * Returns the Gradle version this connection implements. The implementation of this method should be fast, and should continue to work after the connection has been stopped.
     *
     * @return The version.
     */
    String getVersion();

    /**
     * Returns a display name for this connection, which can be used in logging and error reporting. The implementation of this method should be fast and should continue to work after the connection
     * has been stopped.
     *
     * @return The display name.
     */
    String getDisplayName();

    /**
     * Starts fetching a snapshot of the model for the project. This method returns immediately, and the given result handler is notified when the model is available.
     *
     * @param handler The handler to pass the model to.
     * @throws UnsupportedOperationException When the given model type is not supported.
     * @throws IllegalStateException When this connection has been stopped.
     */
    void getModel(ModelFetchParametersVersion1 fetchParameters, BuildOperationParametersVersion1 operationParameters, ResultHandlerVersion1<? super ProjectVersion3> handler) throws UnsupportedOperationException, IllegalStateException;

    /**
     * Starts the execution of a build. This method returns immediately, and the given result handler is notified when the build is complete.
     *
     * @param buildParameters The parameters for the build.
     * @param handler The handler to notify of the build result.
     * @throws IllegalStateException When this connection has been stopped.
     */
    void executeBuild(BuildParametersVersion1 buildParameters, BuildOperationParametersVersion1 operationParameters, ResultHandlerVersion1<? super Void> handler) throws IllegalStateException;
}
