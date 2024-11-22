package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.Company;
import com.petquer.petquer.entity.Individual;
import com.petquer.petquer.entity.User;
import com.petquer.petquer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/userPlayground")
public class UserPlaygroundController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewUserPlayground(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userPlayground";
    }

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        Individual individual = null;
        Company company = null;

        if ("individual".equals(user.getUserType()) || "both".equals(user.getUserType())) {
            individual = new Individual();
            individual.setCpf(user.getIndividual().getCpf());
            individual.setRg(user.getIndividual().getRg());
            individual.setIndividualName(user.getIndividual().getIndividualName());
        }

        if ("company".equals(user.getUserType()) || "both".equals(user.getUserType())) {
            company = new Company();
            company.setCnpj(user.getCompany().getCnpj());
            company.setCompanyName(user.getCompany().getCompanyName());
        }

        userService.createUserWithDetails(user, individual, company);
        return "redirect:/userPlayground";
    }


    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/userPlayground";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/userPlayground";
    }

}
