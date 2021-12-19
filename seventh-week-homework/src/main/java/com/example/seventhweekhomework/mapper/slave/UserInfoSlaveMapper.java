package com.example.seventhweekhomework.mapper.slave;

import com.example.seventhweekhomework.model.UserInfo;

public interface UserInfoSlaveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}