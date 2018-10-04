package tasks.employer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tasks.employer.entity.Clock;
import tasks.employer.entity.Log;
import tasks.employer.service.ClockService;
import tasks.employer.service.DBService;
import tasks.employer.service.PropertiesServiceImpl;

import javax.validation.Valid;
import java.util.Date;
import java.util.logging.Level;

@Controller
@RequestMapping("/clock")
public class ClockController {

    @Autowired
    private ClockService clockService;

    @Autowired
    private PropertiesServiceImpl properties;

    @Autowired
    private DBService<Log> logDBService;

    @GetMapping("/{h}:{m}")
    public String getTime(Model model, @PathVariable("h") int hour, @PathVariable("m") int minute) {
        Clock clock = new Clock(hour, minute);
        collectModel(clock, model);
        return "clock";
    }

    @PostMapping("/{h}:{m}")
    public String getTime(@Valid @ModelAttribute("clock") Clock clock, BindingResult result) {
        if (result.hasErrors()) {
            String errorMsg = properties.get(result.getFieldError().getField() + result.getFieldError().getCode());
            logDBService.save(new Log(Level.WARNING.toString(), errorMsg, new Date()));
            return "redirect:/clock/notValidateInput/" + errorMsg;
        }
        return "redirect:/clock/" + clockService.getTime(clock);
    }

    @GetMapping("/notValidateInput/{error}")
    public String getError(Model model, @PathVariable("error") String errorMsg) {
        Clock clock = new Clock(0, 0);
        model.addAttribute("clock", clock);
        model.addAttribute("time", clockService.getTime(clock));
        model.addAttribute("angle", errorMsg);
        model.addAttribute("angleHour", clockService.getHourAngle(clock));
        model.addAttribute("angleMinute", clockService.getMinuteAngle(clock));

        return "clock";
    }

    @GetMapping("/currentTime")
    public String getCurrentTime(Model model) {
        collectModel(clockService.getCurrentTime(), model);
        return "clock";
    }

    @PostMapping("/clock/currentTime")
    public String getCurrentTime() {
        return "redirect:/clock/currentTime";
    }

    @GetMapping("/random")
    public String getRandomTime(Model model) {
        collectModel(clockService.getRandomTime(), model);
        return "clock";
    }

    @PostMapping("/clock/random")
    public String getRandomTime() {
        return "redirect:/clock/random";
    }

    @GetMapping("/{h}:{m}/next")
    public String getTimeNext(Model model, @PathVariable("h") int hour, @PathVariable("m") int minute) {

        collectModel(clockService.getNextTime(hour, minute), model);

        return "clock";
    }

    @PostMapping("/clock/{h}:{m}/next")
    public String getTimeNext(@ModelAttribute("clock") Clock clock) {
        return "redirect:/clock/" + clockService.getTime(clock) + "next";
    }

    private void collectModel(Clock clock, Model model) {
        model.addAttribute("clock", clock);
        model.addAttribute("time", clockService.getTime(clock));
        model.addAttribute("angle", clockService.getAngle(clock));
        model.addAttribute("angleHour", clockService.getHourAngle(clock));
        model.addAttribute("angleMinute", clockService.getMinuteAngle(clock));
    }

}
