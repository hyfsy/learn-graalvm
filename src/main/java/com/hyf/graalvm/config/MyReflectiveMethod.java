package com.hyf.graalvm.config;

import org.springframework.aot.hint.annotation.Reflective;

import java.lang.annotation.*;

/**
 * @author baB_hyf
 * @date 2023/03/25
 */
@Reflective
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyReflectiveMethod {
}
