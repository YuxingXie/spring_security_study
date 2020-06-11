package com.lingyun.study.springsecurity.domain.authority.repo;

import com.lingyun.study.springsecurity.domain.authority.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,String> {
}
