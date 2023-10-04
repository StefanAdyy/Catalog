package com.example.examen_tw.service;

import com.example.examen_tw.entity.AppUserEntity;
import com.example.examen_tw.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService{

    @Autowired private AppUserRepository appUserRepository;

    public List<AppUserEntity> findAll(){
        return (List<AppUserEntity>) appUserRepository.findAll();
    }

    public AppUserEntity checkUsername(AppUserEntity appUserEntity){
        AppUserEntity user = appUserRepository.findByUsername(appUserEntity.getUsername());

        if (user == null){
            return null;
        }

        return user;
    }

    public Optional<AppUserEntity> getUserById(Integer id){
        Optional<AppUserEntity> user = appUserRepository.findById(Long.valueOf(id));

        if (user!=null){
            return user;
        }

        return null;
    }

    public void save(AppUserEntity user) {
        appUserRepository.save(user);
    }

    public void saveUser(AppUserEntity appUserEntity){
        appUserRepository.save(appUserEntity);
    }
}
