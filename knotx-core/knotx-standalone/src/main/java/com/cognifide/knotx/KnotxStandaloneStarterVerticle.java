/*
 * Knot.x - Reactive microservice assembler - Standalone Knot.x
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
package com.cognifide.knotx;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.rxjava.core.AbstractVerticle;

public class KnotxStandaloneStarterVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle("com.cognifide.knotx.repository.RepositoryVerticle", new DeploymentOptions(config().getJsonObject("repository")));
    vertx.deployVerticle("com.cognifide.knotx.engine.TemplateEngineVerticle", new DeploymentOptions(config().getJsonObject("engine")));
    vertx.deployVerticle("com.cognifide.knotx.server.KnotxServerVerticle", new DeploymentOptions(config().getJsonObject("server")));
  }
}
