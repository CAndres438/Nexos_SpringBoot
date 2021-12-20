package com.auto_inventory_1.controllers;


import com.auto_inventory_1.exceptions.DateInvalidException;
import com.auto_inventory_1.exceptions.UserNexosInvalidException;
import com.auto_inventory_1.models.UserNexos;
import com.auto_inventory_1.services.UserNexosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController

public class UserNexosController {
    @Autowired
    private UserNexosService userNexosService;

    @PostMapping("/usuario/registro")
    UserNexos newUserNexos(@RequestBody UserNexos userNexos) {

        UserNexos completeName = userNexosService.findById(userNexos.getCompleteName()).orElse(null);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
        String formattedString = localDate.format(formatter);

        if (userNexos.getEntryUser().compareTo(formattedString) > 0) {
            throw new DateInvalidException("La Fecha " + userNexos.getEntryUser() + " es mayor a la actual");
        }

        if (completeName != null) {
            throw new UserNexosInvalidException("El Usuario " + userNexos.getCompleteName() + " ya se encuentra registrado");
        }


        return userNexosService.create(userNexos);}

}