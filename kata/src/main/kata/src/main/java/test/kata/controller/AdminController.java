package test.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.kata.model.Role;
import test.kata.model.User;
import test.kata.service.UserService;

import java.util.List;

@Controller
@RequestMapping(name = "/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin/user-list")
    public String findAll(Model model) {
        List<User> users = userService.all();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/admin/create-user")
    public String createUserForm(@ModelAttribute("user") User user, Model model) {
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("listRoles", listRoles);
        return "create-user";
    }

    @PostMapping("/admin/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/user-list";
    }

    @GetMapping(value = "/admin/update-user/{id}")
    public String formUpdateUser(@PathVariable Long id, Model model) {
        User user = userService.getUserBiId(id);
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("user", userService.getUserBiId(id));
        model.addAttribute("listRoles", listRoles);
        return "update-user";
    }

    @PostMapping(value = "/admin/update-user/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/user-list";
    }

    @GetMapping(value = "/admin/user-delete/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/user-list";
    }

    @GetMapping("/admin/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserBiId(id));
        return "userpage";
    }
}
