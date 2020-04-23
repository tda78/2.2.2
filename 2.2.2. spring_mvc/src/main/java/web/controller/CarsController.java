package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import web.model.Car;
import web.service.CarService;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/cars*")
public class CarsController {


    private CarService carService;

    public CarService getCarService() {
        return carService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printCars(WebRequest request, ModelMap model) {

        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);

        String caption = "Cars";
        try {
            if (request.getParameter("locale").equals("ru")) {
                caption = "Машины";
            }
        }catch (NullPointerException nullEx) {}


        model.addAttribute("caption", caption);

        return "cars";
    }
}
