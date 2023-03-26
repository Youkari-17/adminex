package com.springboot.adminex;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Junit5测试类")
public class TestJunit5 {
    @Test
    @DisplayName("测试方法1")
    void testDisplayName() {
        System.out.println(1);
    }

    @Test
    @DisplayName("测试简单断言")
    void testAssertions() {
        assertEquals(0, 0.0, "数字不相等");
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组不相等");
        assertSame(new Object(), new Object(), "不是同一个对象");

    }

    @Test
    @DisplayName("测试组合断言")
    void testAssertAll() {
        assertAll(() -> assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0), "没有出现算数异常"),
                () -> assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(150)));
    }

    @Test
    @DisplayName("测试快速失败")
    void testFail() {
        fail("快速失败");
    }

    @Test
    @DisplayName("测试前置条件")
    void testAssumptions() {
        assumeTrue(true);
        assumingThat("ok".equals("ok"), () -> System.out.println("ok"));
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(200);
    }

    @RepeatedTest(value = 5)
    void testRepeatedTest() {
        System.out.println(2);
    }

    @Test
    @Disabled
    void testDisabled() {
        System.out.println("不执行");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了...");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试已经结束了...");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试已经结束了...");
    }
}
