/*
 * Copyright (c) 2020 Dzikoysk
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

package org.panda_lang.reposilite.utils

import groovy.transform.CompileStatic
import org.junit.jupiter.api.Test
import org.panda_lang.reposilite.error.FailureService

import java.util.stream.Collectors

import static org.junit.jupiter.api.Assertions.assertTrue

@CompileStatic
class RunUtilsTest {

    @Test
    void 'should log exception ' () {
        def failureService = new FailureService()

        def exception = new RuntimeException('RunUtilsTest')
        RunUtils.ofChecked(failureService, { throw exception }).run()

        assertTrue failureService.getExceptions().stream()
                .map({ pair -> pair.getValue() })
                .collect(Collectors.toList())
                .contains(exception)
    }

}