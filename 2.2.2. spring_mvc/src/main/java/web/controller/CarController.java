package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    @Qualifier("listCars")
    private List<Car> cars;

    @GetMapping
    public String printCars(ModelMap model) {
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping(params = "count")
    public String gerCars(@RequestParam("count") int count, ModelMap model) {
        if (count > 0) {
            model.addAttribute("cars", cars.stream().limit(count).collect(Collectors.toList()));
        }
        return "index";
    }
}
