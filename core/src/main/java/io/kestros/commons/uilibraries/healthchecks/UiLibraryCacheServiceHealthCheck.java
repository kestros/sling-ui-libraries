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

package io.kestros.commons.uilibraries.healthchecks;

import io.kestros.commons.uilibraries.services.cache.UiLibraryCacheService;
import org.apache.felix.hc.annotation.Async;
import org.apache.felix.hc.annotation.HealthCheckMBean;
import org.apache.felix.hc.annotation.HealthCheckService;
import org.apache.felix.hc.annotation.ResultTTL;
import org.apache.felix.hc.annotation.Sticky;
import org.apache.felix.hc.api.FormattingResultLog;
import org.apache.felix.hc.api.HealthCheck;
import org.apache.felix.hc.api.Result;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Health Check that looks to see if the UiLibraryCacheService is active and running properly.
 */
@Component
@HealthCheckService(name = "UiLibraryCacheService Check",
                    tags = {"kestros", "ui-libraries"})
@Async(intervalInSec = 60)
@ResultTTL(resultCacheTtlInMs = 10000)
@HealthCheckMBean(name = "UiLibraryCacheServiceHealthCheck")
@Sticky(keepNonOkResultsStickyForSec = 10)
public class UiLibraryCacheServiceHealthCheck implements HealthCheck {

  @Reference(cardinality = ReferenceCardinality.OPTIONAL,
             policyOption = ReferencePolicyOption.GREEDY)
  private UiLibraryCacheService uiLibraryCacheService;

  @Override
  public Result execute() {
    FormattingResultLog log = new FormattingResultLog();
    if (uiLibraryCacheService == null) {
      log.critical("No UiLibraryCacheService is registered.");
    } else if (!uiLibraryCacheService.isLive()) {
      log.warn("UiLibraryCacheService is registered, but is not live.");
    } else {
      log.info("UiLibraryCacheService is registered and running properly.");
    }
    return new Result(log);
  }
}