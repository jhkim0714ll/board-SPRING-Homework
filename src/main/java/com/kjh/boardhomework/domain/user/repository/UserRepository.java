package com.kjh.boardhomework.domain.user.repository;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByIdAndPassword(String id, String password);
}
