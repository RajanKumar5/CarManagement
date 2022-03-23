package com.example.carmanagement.admin;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarModel, String> {
    
}
