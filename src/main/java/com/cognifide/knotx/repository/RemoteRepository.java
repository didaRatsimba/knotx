/*
 * Knot.x - reactive microservice assembler
 *
 * Copyright (C) 2016 Cognifide Limited
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
package com.cognifide.knotx.repository;

import java.io.IOException;
import java.net.URI;

import io.vertx.core.AsyncResultHandler;

class RemoteRepository implements Repository<String, URI> {

    private String path;

    private String serviceUrl;

    private RemoteRepository() {
        // hidden constructor
    }

    static RemoteRepository of(String path, String serviceUrl) {
        RemoteRepository remoteRepository = new RemoteRepository();
        remoteRepository.path = path;
        remoteRepository.serviceUrl = serviceUrl;
        return remoteRepository;
    }

    @Override
    public void get(URI uri, AsyncResultHandler<Template<String, URI>> handler) throws IOException {
        throw new UnsupportedOperationException("Not supported yet!");
    }

    @Override
    public boolean support(URI uri) {
        return false;
    }

}