package com.aquarius.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/7
 * @Description:
 */
@Data
@ToString
public class User {

    // 所有属性都应该在数据库中存在
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    // 一下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
