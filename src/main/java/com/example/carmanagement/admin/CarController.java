package com.example.carmanagement.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    
    @Autowired
    CarService carService;

    @GetMapping("/")
    public String say(){
        return "Hello World";
    }

    @GetMapping("/getCars")
    public List<CarModel> getCars(){
        return carService.getCars();
    }

    @PostMapping("/save")
    public CarModel saveCar(@RequestBody CarModel car){
        return carService.saveCar(car);
    }

    @PutMapping("/editCar/{carId}")
    public CarModel editCar(@RequestBody CarModel car, @PathVariable String carId){
        return carService.editCar(car, carId);
    }

    @GetMapping("/getCar/{carId}")
    public CarModel getCar(@PathVariable String carId){
        return carService.getCar(carId);
    }

    @DeleteMapping("/deleteCar/{carId}")
    public Boolean deleteCar(@PathVariable String carId){
        return carService.deleteCar(carId);
    }
}
