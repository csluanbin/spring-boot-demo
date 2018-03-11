package com.luanbin.demo.mapper;

import com.luanbin.demo.data.UserDo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public UserDo getUserById(@Param("id") Integer id);
}
