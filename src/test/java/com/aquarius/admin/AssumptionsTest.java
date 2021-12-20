package com.aquarius.admin;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/20
 * @Description:
 */
@SpringBootTest
@DisplayName("前置测试")
public class AssumptionsTest {

    @Test
    @DisplayName("测试前置条件")
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("1111");
    }


}
