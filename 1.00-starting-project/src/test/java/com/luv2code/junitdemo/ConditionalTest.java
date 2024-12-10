package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

    @Test
    @Disabled("Don't run this text until we fix JIRA 123")
    void basicTest() {

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void basicTest1() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void basicTest2() {

    }
}
