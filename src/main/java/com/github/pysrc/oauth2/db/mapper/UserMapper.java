package com.github.pysrc.oauth2.db.mapper;

import com.github.pysrc.oauth2.db.entity.Permission;
import com.github.pysrc.oauth2.db.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(@Param("username") String username);
}
