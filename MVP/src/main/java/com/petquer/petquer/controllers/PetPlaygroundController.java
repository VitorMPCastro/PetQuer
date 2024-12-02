package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.Pet;
import com.petquer.petquer.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/petPlayground")
public class PetPlaygroundController {

    @Autowired
    private PetService petService;

    @GetMapping
    public String viewPetPlayground(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "petPlayground";
    }

    @GetMapping("/addPet")
    public String showAddPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "addPet";
    }

    @PostMapping("/addPet")
    public String addPet(@ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/petPlayground";
    }

    @GetMapping("/editPet/{id}")
    public String editPetForm(@PathVariable Long id, Model model) {
        Pet pet = petService.getPetById(id);
        model.addAttribute("pet", pet);
        return "editPet";
    }

    @PostMapping("/editPet/{id}")
    public String editPet(@PathVariable Long id, @ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/petPlayground";
    }

    @GetMapping("/deletePet/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/petPlayground";
    }
}