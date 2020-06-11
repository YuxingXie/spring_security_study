package com.lingyun.study.springsecurity.domain.authority.entity;

import com.lingyun.study.springsecurity.domain.user.entity.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
//权限
@Entity
public class Authority implements GrantedAuthority {
    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;
    @Column
    private String name;

    public Authority() {
    }

    public Authority(String name) {
        this.name = name;
    }


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
