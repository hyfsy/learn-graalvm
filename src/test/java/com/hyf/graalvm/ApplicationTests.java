package com.hyf.graalvm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.test.agent.EnabledIfRuntimeHintsAgent;
import org.springframework.aot.test.agent.RuntimeHintsInvocations;
import org.springframework.aot.test.agent.RuntimeHintsRecorder;
import org.springframework.core.SpringVersion;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author baB_hyf
 * @date 2023/03/25
 */
public class ApplicationTests {

    // @EnabledIfRuntimeHintsAgent signals that the annotated test class or test
    // method is only enabled if the RuntimeHintsAgent is loaded on the current JVM.
    // It also tags tests with the "RuntimeHints" JUnit tag.
    @EnabledIfRuntimeHintsAgent
    class SampleReflectionRuntimeHintsTests {

        @Test
        void shouldRegisterReflectionHints() {
            RuntimeHints runtimeHints = new RuntimeHints();
            // Call a RuntimeHintsRegistrar that contributes hints like:
            runtimeHints.reflection().registerType(SpringVersion.class, typeHint ->
                    typeHint.withMethod("getVersion", new ArrayList<>(), ExecutableMode.INVOKE));

            // Invoke the relevant piece of code we want to test within a recording lambda
            RuntimeHintsInvocations invocations = RuntimeHintsRecorder.record(() -> {
                SampleReflection sample = new SampleReflection();
                sample.performReflection();
            });
            // assert that the recorded invocations are covered by the contributed hints
            // assertThat(invocations).match(runtimeHints);
        }

    }

    public class SampleReflection {

        private final Log logger = LogFactory.getLog(SampleReflection.class);

        public void performReflection() {
            try {
                Class<?> springVersion = ClassUtils.forName("org.springframework.core.SpringVersion", null);
                Method getVersion = ClassUtils.getMethod(springVersion, "getVersion");
                String version = (String) getVersion.invoke(null);
                logger.info("Spring version:" + version);
            }
            catch (Exception exc) {
                logger.error("reflection failed", exc);
            }
        }

    }
}
