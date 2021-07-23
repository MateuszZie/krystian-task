package org.mateuszziebura.krystiantask.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mateuszziebura.krystiantask.Service.OrderService;
import org.mateuszziebura.krystiantask.domain.Data;
import org.mateuszziebura.krystiantask.domain.History;
import org.mateuszziebura.krystiantask.domain.Task;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
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
    public String save(@Valid @ModelAttribute("order") Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });
            return "newOrder";
        }
        orderService.save(task);
        return "redirect:/home";
    }
    @GetMapping("/history/{id}")
    public String history(Model model,@PathVariable String id) {
        model.addAttribute("histories", orderService.history(Integer.valueOf(id)));
        model.addAttribute("id", id);
        return "history";
    }
    @GetMapping("addQuantity")
    public String addQuantity(Model model){
        model.addAttribute("orders", orderService.findAllActiveTask());
        model.addAttribute("task", new Data());
        return "made";
    }
    @PostMapping("addQuantity")
    public String postQuantity(@Valid @ModelAttribute("task") Data data,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()) {

            model.addAttribute("orders", orderService.findAllActiveTask());
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });
            return "made";
        }
        orderService.addQuantity(data.getId(),data.getQuantity(), getUsername());
        return "redirect:/home";
    }

    private String getUsername() {
        return ((User) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();
    }
}
