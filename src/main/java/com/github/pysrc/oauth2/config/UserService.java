package com.github.pysrc.oauth2.config;

import com.github.pysrc.oauth2.db.entity.Permission;
import com.github.pysrc.oauth2.db.entity.User;
import com.github.pysrc.oauth2.db.mapper.PermissionMapper;
import com.github.pysrc.oauth2.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库获取用户信息

        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return null;
        }
        // 获取用户权限
        List<Permission> permissions = permissionMapper.selectByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        permissions.forEach(permission -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getEnname()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
