package com.lingyun.study.springsecurity.domain.user.service;

import com.lingyun.study.springsecurity.domain.user.entity.User;
import com.lingyun.study.springsecurity.domain.user.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 这个service要实现 UserDetailsService
 */
@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByName(username);
    }
}
