package com.auto_inventory_1.controllers;

import com.auto_inventory_1.exceptions.DateInvalidException;
import com.auto_inventory_1.exceptions.ProductInvalidException;
import com.auto_inventory_1.exceptions.UserNexosInvalidException;
import com.auto_inventory_1.models.Commodity;
import com.auto_inventory_1.models.UserNexos;
import com.auto_inventory_1.services.CommodityService;
import com.auto_inventory_1.services.UserNexosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@RestController

public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    private UserNexosService userNexosService;

    public CommodityController(UserNexosService userNexosService, CommodityService commodityService) {
        this.userNexosService = userNexosService;
        this.commodityService = commodityService;
    }

    @PostMapping("/mercancia")
    Commodity newCommodity(@RequestBody Commodity commodity) {

        Commodity productName = commodityService.findByProductName(commodity.getProductName()).orElse(null);

        UserNexos completeName = userNexosService.findById(commodity.getUserNexos()).orElse(null);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
        String formattedString = localDate.format(formatter);


        if (commodity.getEntryDate().compareTo(formattedString) > 0) {
            throw new DateInvalidException("La Fecha " + commodity.getEntryDate() + " es mayor a la actual");
        }

        if (productName != null) {
            throw new ProductInvalidException("El producto " + commodity.getProductName() + " ya se encuentra registrado");
        }

        if (completeName == null) {
            throw new UserNexosInvalidException("El Usuario " + commodity.getUserNexos() + " no se encuentra Registrado");
        }

        return commodityService.create(commodity);
    }


    @GetMapping("/mercancia")

    private ResponseEntity<List<Commodity>> CommodityList() {
        return ResponseEntity.ok(commodityService.getAllCommodity());
    }

    @DeleteMapping("/mercancia/{productName}")
    public ResponseEntity<?> deleteCommodity(@RequestBody Commodity commodity, @PathVariable String productName) {

        if (!commodityService.findByProductName(productName).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        commodityService.delete(commodity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mercancia/{productName}")
    Optional<Commodity> getCommodity1(@PathVariable String productName) {
        Optional<Commodity> commodity1 = commodityService.findByProductName(productName);

        return commodity1;
    }

    @PutMapping("/mercancia/{productName}/modificar")
    public ResponseEntity<?> update(@RequestBody Commodity commodity3, @PathVariable String productName) {
        Optional<Commodity> commodity = commodityService.findByProductName(productName);

        UserNexos completeName2 = userNexosService.findById(commodity3.getUserChange()).orElse(null);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
        String formattedString = localDate.format(formatter);

        if (!commodity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        commodity.get().setAmount(commodity3.getAmount());
        commodity.get().setUserChange(commodity3.getUserChange());
        commodity.get().setDateUserChange(commodity3.getDateUserChange());

        if (completeName2 == null) {
            throw new UserNexosInvalidException("El Usuario " + commodity3.getUserChange() + " no puede realizar esta operación");
        }

        if (commodity3.getDateUserChange().compareTo(formattedString)!= 0)
            throw new DateInvalidException("La fecha: " + commodity3.getDateUserChange()+ " no puede ser diferente a la actual");

        return ResponseEntity.status(HttpStatus.CREATED).body(commodityService.create(commodity.get()));
    }

}






