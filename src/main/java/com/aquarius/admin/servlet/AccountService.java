package com.aquarius.admin.servlet;

import com.aquarius.admin.bean.Account;
import com.aquarius.admin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: dllAquarius
 * @Date: 2021/12/19
 * @Description:
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAccount(Long id){
        return accountMapper.getAccount(id);
    }
}
