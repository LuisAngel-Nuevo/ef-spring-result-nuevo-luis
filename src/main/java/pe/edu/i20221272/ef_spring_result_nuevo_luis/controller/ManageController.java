package pe.edu.i20221272.ef_spring_result_nuevo_luis.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.dto.CarDto;
import pe.edu.i20221272.ef_spring_result_nuevo_luis.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/car")
public class ManageController {

    @Autowired
    ManageService manageService;



    @RequestMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> car= manageService.getAllCars();
            model.addAttribute("car", car);
            model.addAttribute("error", null);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error");
        }
        return "car";
    }


}
