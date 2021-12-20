package com.auto_inventory_1.services;

import com.auto_inventory_1.models.UserNexos;
import com.auto_inventory_1.repositories.UserNexosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserNexosService {

    @Autowired
    private UserNexosRepository userNexosRepository;

    public UserNexos create (UserNexos userNexos){
        return userNexosRepository.save(userNexos);
    }
    public List<UserNexos> getAllUser(){
        return userNexosRepository.findAll();
    }
    public void delete (UserNexos userNexos){
        userNexosRepository.delete(userNexos);
    }
    public Optional<UserNexos> findById(String completeName){
        return userNexosRepository.findById(completeName);
    }

}