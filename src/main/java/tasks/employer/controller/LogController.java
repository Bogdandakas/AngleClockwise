package tasks.employer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tasks.employer.entity.Log;
import tasks.employer.service.DBService;

@Controller
@RequestMapping("/")
public class LogController {

    @Autowired
    private DBService<Log> logService;

    @GetMapping("/logs")
    public String getLogs(Model model) {
        model.addAttribute("logs", logService.getAll());
        return "logs";
    }

    @PostMapping("/logs")
    public String getLogs() {
        return "redirect:/logs";
    }
}
