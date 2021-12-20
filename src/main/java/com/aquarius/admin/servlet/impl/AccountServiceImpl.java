package com.aquarius.admin.servlet.impl;

import com.aquarius.admin.bean.Account;
import com.aquarius.admin.mapper.AccountMapper;
import com.aquarius.admin.servlet.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/19
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAccount(Long id){
        return accountMapper.getAccount(id);
    }
}
