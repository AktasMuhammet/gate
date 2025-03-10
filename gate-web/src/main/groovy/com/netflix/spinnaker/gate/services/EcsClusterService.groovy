/*
 * Copyright 2018 Lookout, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.gate.services

import com.netflix.spinnaker.gate.services.internal.ClouddriverService
import com.netflix.spinnaker.kork.retrofit.Retrofit2SyncCall
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EcsClusterService {

  ClouddriverService clouddriver

  @Autowired
  EcsClusterService(ClouddriverService clouddriver) {
    this.clouddriver = clouddriver
  }

  List getAllEcsClusters() {
    Retrofit2SyncCall.execute(clouddriver.getAllEcsClusters())
  }

  List getEcsClusterDescriptions(String account, String region) {
    Retrofit2SyncCall.execute(clouddriver.getEcsClusterDescriptions(account, region))
  }
}
