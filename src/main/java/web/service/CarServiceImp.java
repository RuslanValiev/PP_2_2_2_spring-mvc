package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService{
    @Override
    public List<Car> getCars(List<Car> cars, int number) {
        return cars.stream().limit(number).collect(Collectors.toList());
    }
}
