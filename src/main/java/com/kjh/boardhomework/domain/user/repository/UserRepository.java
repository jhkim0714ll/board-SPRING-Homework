package com.kjh.boardhomework.domain.user.repository;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByIdAndPassword(String id, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET last_login_time = :time WHERE id = :id", nativeQuery = true)
    public void updateLastLoginTime(
            @Param("id") String id,
            @Param("time") Date loginTime);

    Optional<UserEntity> findByName(String name);
}
