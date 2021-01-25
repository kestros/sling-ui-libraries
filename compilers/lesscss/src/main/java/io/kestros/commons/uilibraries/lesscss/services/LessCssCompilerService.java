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

package io.kestros.commons.uilibraries.lesscss.services;

import com.inet.lib.less.Less;
import io.kestros.commons.uilibraries.api.models.ScriptTypeInterface;
import io.kestros.commons.uilibraries.api.services.CssScriptTypeCompilerService;
import io.kestros.commons.uilibraries.api.services.ScriptTypeCompiler;
import io.kestros.commons.uilibraries.basecompilers.filetypes.ScriptType;
import io.kestros.commons.uilibraries.lesscss.filetypes.LessCssScriptType;
import java.util.Arrays;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * LessCSS Compiler Service.
 */
@Component(immediate = true,
           service = {CssScriptTypeCompilerService.class, ScriptTypeCompiler.class})
public class LessCssCompilerService implements ScriptTypeCompiler, CssScriptTypeCompilerService {

  @Override
  public List<ScriptTypeInterface> getScriptTypes() {
    return Arrays.asList(ScriptType.CSS, LessCssScriptType.LESS);
  }

  @Override
  public String getOutput(String source) {
    return Less.compile(null, source, false);
  }

}