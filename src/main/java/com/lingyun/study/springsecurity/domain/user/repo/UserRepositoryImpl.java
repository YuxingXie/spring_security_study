package com.lingyun.study.springsecurity.domain.user.repo;

import com.lingyun.study.springsecurity.domain.user.entity.User;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl {
    @PersistenceContext
    protected EntityManager em;
   public User findOneByName(java.lang.String name){
       String jpql = "select u from User u where u.name=:name";
       TypedQuery<User> query = em.createQuery(jpql, User.class);
       List<User> list = query.getResultList();
       return list==null||list.size()==0?null:list.get(0);
   }
}
