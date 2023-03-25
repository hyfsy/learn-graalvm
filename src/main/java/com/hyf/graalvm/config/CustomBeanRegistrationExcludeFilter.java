package com.hyf.graalvm.config;

import org.springframework.beans.factory.aot.BeanRegistrationExcludeFilter;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * @author baB_hyf
 * @date 2023/03/25
 */
public class CustomBeanRegistrationExcludeFilter implements BeanRegistrationExcludeFilter {

    @Override
    public boolean isExcludedFromAotProcessing(RegisteredBean registeredBean) {
        return false;
    }
}
