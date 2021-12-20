package com.aquarius.admin.servlet.impl;

import com.aquarius.admin.bean.User;
import com.aquarius.admin.mapper.UserMapper;
import com.aquarius.admin.servlet.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/20
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
