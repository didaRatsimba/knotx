/*
 * Copyright (C) 2016 Cognifide Limited
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
package io.knotx.knot.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import io.knotx.junit5.util.FileReader;
import io.vertx.core.json.JsonObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceCorrectConfigurationTest {
  private ServiceKnotOptions correctConfig;
  private ServiceMetadata expectedService;

  @BeforeEach
  public void setUp() throws Exception {
    JsonObject config = new JsonObject(FileReader.readText("service-correct.json"));
    correctConfig = new ServiceKnotOptions(config);
    expectedService = createMockedService("first-service", "knotx.core-adapter",
        "{\"path\":\"/service/mock/first.json\"}", "first");
  }

  @Test
  public void whenCorrectConfigIsProvided_expectConfigIsProperlyParsed() {
    assertThat(correctConfig.getServices(), is(notNullValue()));
    assertThat(correctConfig.getServices().size(), is(1));
    assertThat(correctConfig.getServices(), Matchers.hasItem(expectedService));
  }

  private ServiceMetadata createMockedService(String name, String address,
      String params, String cacheKey) {
    ServiceMetadata newService = new ServiceMetadata();
    newService.setName(name);
    newService.setAddress(address);
    newService.setParams(new JsonObject(params));
    newService.setCacheKey(cacheKey);
    return newService;
  }

}
