package com.aquarius.admin;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/20
 * @Description:
 */
@SpringBootTest
@DisplayName("断言测试")
public class AssertionsTest {

    /**
     * 断言：前面的断言失败，后面的代码就不会执行
     */
    @Test
    void simpleAssertionsTest(){
        int cal = cal(2, 3);
        assertEquals(6,cal,"业务逻辑计算失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"两个对象不一样");
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{2, 2}, new int[] {1, 2},"数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    void all(){
        /**
         * 所有断言都要成功
         */
        assertAll("test",
                ()->assertTrue(true && true,"结果true"),
                ()->assertEquals(1,2,"结果不是1"));
    }

    @Test
    @DisplayName("异常断言")
    void exceptionTest(){
        assertThrows(ArithmeticException.class,()->{
            int i=1/2;
        },"业务逻辑居然正常？");
    }

    @Test
    @DisplayName("快速失败")
    void failTest(){
        if (1 == 2){
            fail("测试失败");
        }
    }

    int cal(int a,int b){
        return a+b;
    }
}
