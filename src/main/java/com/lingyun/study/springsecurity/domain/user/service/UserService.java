package com.lingyun.study.springsecurity.domain.user.service;

import com.lingyun.study.springsecurity.domain.user.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 这个service要实现 UserDetailsService
 */
@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setId("1");
        user.setName("zhangsan");
        user.setPassword("123");
        return user;
    }
}
