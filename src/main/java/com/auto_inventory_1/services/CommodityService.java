package com.auto_inventory_1.services;


import com.auto_inventory_1.models.Commodity;
import com.auto_inventory_1.repositories.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    public Commodity create (Commodity commodity){
        return commodityRepository.save(commodity);
    }
    public List <Commodity> getAllCommodity(){
        return commodityRepository.findAll();
    }
    public void delete (Commodity commodity){
       commodityRepository.delete(commodity);
    }
    public Optional<Commodity> findById(Long id){
        return commodityRepository.findById(id);
    }
    public Optional<Commodity> findByProductName(String productName){
        return commodityRepository.findByProductName(productName);
    }
    public List<Commodity> findByUserNexos(String userNexos){
        return commodityRepository.findByUserNexos(userNexos);
    }


}
