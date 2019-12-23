package com.dkv.repository;

import com.dkv.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
