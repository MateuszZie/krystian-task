package org.mateuszziebura.krystiantask.contoller;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final OrderService orderService;

    @GetMapping({"","/","home","index"})
    public String home(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "home";
    }


}
