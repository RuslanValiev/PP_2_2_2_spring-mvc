package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarServiceImp carServiceImp;


    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping(value = "/cars")
    public String getNumberOfCars(@RequestParam(value = "count", required = false, defaultValue = "5") Integer number,
                                  ModelMap model) {

        model.addAttribute("cars", carServiceImp.getCars(getListCar(), number));

        return "car";
    }

    public String printMyListCar(ModelMap model) {

        model.addAttribute("cars", getListCar());
        return "car";
    }

    static List getListCar() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(1, "Mersedes", 100);
        Car car2 = new Car(2, "Ford", 200);
        Car car3 = new Car(3, "Toyota", 300);
        Car car4 = new Car(4, "Nissan", 400);
        Car car5 = new Car(5, "VAZ", 500);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        return cars;
    }
}
