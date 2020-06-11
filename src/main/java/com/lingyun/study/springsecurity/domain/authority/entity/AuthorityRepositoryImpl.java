package com.lingyun.study.springsecurity.domain.authority.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AuthorityRepositoryImpl {
    @PersistenceContext
    protected EntityManager em;
}
