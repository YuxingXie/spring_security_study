package com.lingyun.study.springsecurity.domain.authority.service;

import com.lingyun.study.springsecurity.domain.authority.entity.Authority;
import com.lingyun.study.springsecurity.domain.authority.repo.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AuthorityService {
    private AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }
    public List<Authority> save(List<Authority> authorities){
        return authorityRepository.save(authorities);
    }
}
