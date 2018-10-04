package tasks.employer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tasks.employer.service.PropertiesServiceImpl;

import static tasks.employer.entity.Log.START;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PropertiesServiceImpl properties;

    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("about", properties.get(START));
        return "index";
    }

}
