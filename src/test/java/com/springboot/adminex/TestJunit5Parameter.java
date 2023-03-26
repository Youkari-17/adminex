package com.springboot.adminex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@DisplayName("参数化测试")
public class TestJunit5Parameter {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    void testValueSource(int num) {
        System.out.println(num);
    }

    static Stream<String> method() {
        return Stream.of("apple", "banana", "adminex");
    }

    @ParameterizedTest
    @MethodSource("method")
    void testMethodSource(String s) {
        System.out.println(s);
    }
}
