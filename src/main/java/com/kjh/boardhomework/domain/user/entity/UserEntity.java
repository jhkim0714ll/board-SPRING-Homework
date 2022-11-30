package com.kjh.boardhomework.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Entity(name = "user_entity")
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;

    private String name;

    private String password;

    @Nullable
    private Date lastLoginTime;

    @Builder
    public UserEntity(String id, String name, String password, Date lastLoginTime){
        this.id = id;
        this.name = name;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
    }
}
