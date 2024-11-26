package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.Company;
import com.petquer.petquer.entity.Individual;
import com.petquer.petquer.entity.User;
import com.petquer.petquer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/userPlayground/addUser")
//    public String showAddUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "addUser";
//    }
//
//    @PostMapping("/userPlayground/addUser")
//    public String addUser(@ModelAttribute User user) {
//        Individual individual = null;
//        Company company = null;
//
//        if ("individual".equals(user.getUserType()) || "both".equals(user.getUserType())) {
//            individual = new Individual();
//            individual.setCpf(user.getIndividual().getCpf());
//            individual.setRg(user.getIndividual().getRg());
//            individual.setIndividualName(user.getIndividual().getIndividualName());
//        }
//
//        if ("company".equals(user.getUserType()) || "both".equals(user.getUserType())) {
//            company = new Company();
//            company.setCnpj(user.getCompany().getCnpj());
//            company.setCompanyName(user.getCompany().getCompanyName());
//        }
//
//        userService.createUserWithDetails(user, individual, company);
//        return "redirect:/userPlayground";
//    }
}