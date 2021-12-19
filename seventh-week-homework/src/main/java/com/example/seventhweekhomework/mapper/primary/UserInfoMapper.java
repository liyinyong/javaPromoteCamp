package com.example.seventhweekhomework.mapper.primary;

import com.example.seventhweekhomework.dynamic.DynamicChooseSource;
import com.example.seventhweekhomework.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);


    int insertbatch(@Param("userInfos") List<UserInfo> userInfo);
}