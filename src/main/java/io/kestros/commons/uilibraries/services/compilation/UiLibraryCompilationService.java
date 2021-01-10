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

package io.kestros.commons.uilibraries.services.compilation;

import io.kestros.commons.osgiserviceutils.services.ManagedService;
import io.kestros.commons.structuredslingmodels.exceptions.InvalidResourceTypeException;
import io.kestros.commons.uilibraries.UiLibrary;
import io.kestros.commons.uilibraries.filetypes.ScriptType;

/**
 * Compiles CSS and JS for {@link UiLibrary}.
 */
public interface UiLibraryCompilationService extends ManagedService {

  /**
   * Returns the uncached ScriptType output.
   *
   * @param uiLibrary UI Library to retrieve output for.
   * @param scriptType ScriptType to retrieve.
   * @param minify Whether to minify the output.
   * @return The uncached ScriptType output.
   * @throws InvalidResourceTypeException Thrown when a referenced dependency could not be
   *     adapted to UiLibrary.
   */
  String getUiLibraryOutput(UiLibrary uiLibrary, ScriptType scriptType, Boolean minify)
      throws InvalidResourceTypeException;

}
