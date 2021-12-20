package com.aquarius.admin.mapper;

import com.aquarius.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAccount(Long id);
}
