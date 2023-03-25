package com.hyf.graalvm.config;

import org.springframework.beans.factory.aot.BeanRegistrationAotContribution;
import org.springframework.beans.factory.aot.BeanRegistrationAotProcessor;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.stereotype.Component;

/**
 * @author baB_hyf
 * @date 2023/03/25
 */
@Component
public class CustomBeanRegistrationAotProcessor implements BeanRegistrationAotProcessor {

    @Override
    public BeanRegistrationAotContribution processAheadOfTime(RegisteredBean registeredBean) {
        return null;
    }
}
