package com.example.examen_tw.repository;

import com.example.examen_tw.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {

    AppUserEntity findByUsername(String username);
}
