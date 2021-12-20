package com.auto_inventory_1.services;



import com.auto_inventory_1.models.Employments;
import com.auto_inventory_1.repositories.EmploymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentsService {

    @Autowired
    private EmploymentsRepository employmentsRepository;

    public Employments create (Employments employments){
        return employmentsRepository.save(employments);
    }
    public List<Employments> getAllCommodity(){
        return employmentsRepository.findAll();
    }
    public void delete (Employments employments){
        employmentsRepository.delete(employments);
    }
    public Optional<Employments> findById(String employmentName){
        return employmentsRepository.findById(employmentName);
    }

}


