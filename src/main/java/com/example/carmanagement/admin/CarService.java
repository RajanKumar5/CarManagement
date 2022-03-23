package com.example.carmanagement.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarModel> getCars(){
        List<CarModel> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    public CarModel saveCar(CarModel car){
        carRepository.save(car);
        return car;
    }

    public CarModel editCar(CarModel car, String carId){
        car.setCarId(carId);
        carRepository.save(car);
        return car;
    }

    public CarModel getCar(String carId){
        return carRepository.findById(carId).get();
    }

    public Boolean deleteCar(String carId){
        try{
            carRepository.deleteById(carId);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
