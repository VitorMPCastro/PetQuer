package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.Anuncio;
import com.petquer.petquer.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/anuncioPlayground")
public class AnuncioPlaygroundController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping
    public String viewAnuncioPlayground(Model model) {
        List<Anuncio> anuncios = anuncioService.getAllAnuncios();
        model.addAttribute("anuncios", anuncios);
        return "anuncioPlayground";
    }

    @GetMapping("/addAnuncio")
    public String showAddAnuncioForm(Model model) {
        model.addAttribute("anuncio", new Anuncio());
        return "addAnuncio";
    }

    @PostMapping("/addAnuncio")
    public String addAnuncio(@ModelAttribute Anuncio anuncio) {
        anuncioService.saveAnuncio(anuncio);
        return "redirect:/anuncioPlayground";
    }

    @GetMapping("/editAnuncio/{id}")
    public String editAnuncioForm(@PathVariable Long id, Model model) {
        Anuncio anuncio = anuncioService.getAnuncioById(id);
        model.addAttribute("anuncio", anuncio);
        return "editAnuncio";
    }

    @PostMapping("/editAnuncio/{id}")
    public String editAnuncio(@PathVariable Long id, @ModelAttribute Anuncio anuncio) {
        anuncio.setId(id);
        anuncioService.saveAnuncio(anuncio);
        return "redirect:/anuncioPlayground";
    }

    @GetMapping("/deleteAnuncio/{id}")
    public String deleteAnuncio(@PathVariable Long id) {
        anuncioService.deleteAnuncio(id);
        return "redirect:/anuncioPlayground";
    }
}