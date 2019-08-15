package com.github.pysrc.oauth2.db.mapper;

import com.github.pysrc.oauth2.db.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PermissionMapper {
    @Select({
            "select tp.* from tb_user tu",
            "left join tb_user_role tur on (tu.id = tur.user_id)",
            "left join tb_role tr on (tr.id = tur.role_id)",
            "left join tb_role_permission trp on (trp.role_id = tur.role_id)",
            "left join tb_permission tp on (tp.id = trp.permission_id)",
            "where tu.username = #{username}"
    })
    List<Permission> selectByUsername(@Param("username") String username);
}
