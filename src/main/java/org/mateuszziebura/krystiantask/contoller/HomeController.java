package org.mateuszziebura.krystiantask.contoller;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.Service.OrderService;
import org.mateuszziebura.krystiantask.domain.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final OrderService orderService;

    @GetMapping({"","/","home","index"})
    public String home(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "home";
    }
    @GetMapping("/new")
    public String newOrder(Model model){
        model.addAttribute("order", new Task());
        return "newOrder";
    }
    @PostMapping("/new")
    public String save(@Valid @ModelAttribute("order") Task task){
        orderService.save(task);
        return "redirect:/home";
    }


}
