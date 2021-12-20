package com.aquarius.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/20
 * @Description:
 */

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
@SpringBootTest
@DisplayName("junit5功能测试")
public class Junit5Test {

    @DisplayName("测试DisplayName注解")
    @Test
    void dispalyNameTest(){
        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试2")
    @Test
    void test2(){
        System.out.println(2);
    }

    @Test
    @RepeatedTest(5)
    void test5(){
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试抛出异常
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MICROSECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(500);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了");
    }
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试已经结束了");
    }
}
