package com.aquarius.admin.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/19
 * @Description:
 */
@Data
@ToString
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;
}
