package com.auto_inventory_1.controllers;

import com.auto_inventory_1.exceptions.EmploymentInvalidException;
import com.auto_inventory_1.models.Employments;
import com.auto_inventory_1.services.EmploymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmploymentsController {
    @Autowired
    private EmploymentsService employmentsService;


    @PostMapping("/cargo")
    Employments newEmployment(@RequestBody Employments employments) {

        Employments employmentName = employmentsService.findById(employments.getEmploymentName()).orElse(null);


        if (employmentName != null) {
            throw new EmploymentInvalidException("El cargo " + employments.getEmploymentName() + " ya se encuentra en la base de datos");
        }

        return employmentsService.create(employments);
    }

    @GetMapping("/cargo")
    private ResponseEntity<List<Employments>> EmploymentsList() {
        return ResponseEntity.ok(employmentsService.getAllCommodity());
    }


}
