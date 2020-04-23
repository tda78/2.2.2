package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static CarServiceImpl carService;

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("toyota-corolla", "black","333-333"));
        cars.add(new Car("audi 5x", "grey metallic","123-456"));
        cars.add(new Car("Ferrary-testarossa", "red","IMCOOL"));
        return cars;
    }
}
