package test.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.kata.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping(name = "/user")
public class Userpage {

    private final UserService userService;
    private final UserDetailsService userDetailsService;


    @Autowired
    public Userpage(UserService userService, UserDetailsService userDetailsService) {
    this.userService = userService;
    this.userDetailsService = userDetailsService;
    }

    @GetMapping("/user/userpage")
    public String userPAge(Principal principal, Model model) {
        model.addAttribute("currentUser", userDetailsService.loadUserByUsername(principal.getName()));
        return "/userpage";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/logout";
    }
}

