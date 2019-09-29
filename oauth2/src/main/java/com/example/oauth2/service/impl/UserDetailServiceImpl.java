package com.example.oauth2.service.impl;

import com.example.oauth2.dao.SysUserRepository;
import com.example.oauth2.entity.Permission;
import com.example.oauth2.entity.SysUser;
import com.example.oauth2.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hua-cloud
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;
    @Autowired
    PermissionService permissionService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.getUserByName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (sysUser != null) {
            System.err.println("sysUser===============" + sysUser);
            //获取用户的授权
            List<Permission> permissions = permissionService.findByAdminUserId(sysUser.getId());
            //声明授权文件
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
        }
        System.err.println("grantedAuthorities===============" + grantedAuthorities);
        return new User(sysUser.getName(), sysUser.getPassword(), grantedAuthorities);
    }
}