package com.hyf.graalvm.config;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

/**
 * @author baB_hyf
 * @date 2023/03/25
 */
@Configuration
public class AotConfiguration {

    @Bean
    // bean注册才注册对应的提示注册器
    @ImportRuntimeHints(CustomRuntimeHintsRegistrar.class)
    // 返回类型指定为实现类型，不能为接口、抽象类等
    public A a() {
        return new A();
    }

    public interface I {}
    public static class A implements I {}
    public static class DTO {}
    public static class XxxServiceImpl {
        @RegisterReflectionForBinding(DTO.class)
        public void serializeDTO(DTO dto) {
            // dto.serialize();
        }
    }
}
