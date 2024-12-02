package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.TipoDenuncia;
import com.petquer.petquer.service.TipoDenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipoDenunciaPlayground")
public class TipoDenunciaPlaygroundController {

    @Autowired
    private TipoDenunciaService tipoDenunciaService;

    @GetMapping
    public String viewTipoDenunciaPlayground(Model model) {
        List<TipoDenuncia> tipoDenuncias = tipoDenunciaService.getAllTipoDenuncias();
        model.addAttribute("tipoDenuncias", tipoDenuncias);
        return "tipoDenunciaPlayground";
    }

    @GetMapping("/addTipoDenuncia")
    public String showAddTipoDenunciaForm(Model model) {
        model.addAttribute("tipoDenuncia", new TipoDenuncia());
        return "addTipoDenuncia";
    }

    @PostMapping("/addTipoDenuncia")
    public String addTipoDenuncia(@ModelAttribute TipoDenuncia tipoDenuncia) {
        tipoDenunciaService.saveTipoDenuncia(tipoDenuncia);
        return "redirect:/tipoDenunciaPlayground";
    }

    @GetMapping("/editTipoDenuncia/{id}")
    public String editTipoDenunciaForm(@PathVariable Long id, Model model) {
        TipoDenuncia tipoDenuncia = tipoDenunciaService.getTipoDenunciaById(id);
        model.addAttribute("tipoDenuncia", tipoDenuncia);
        return "editTipoDenuncia";
    }

    @PostMapping("/editTipoDenuncia/{id}")
    public String editTipoDenuncia(@PathVariable Long id, @ModelAttribute TipoDenuncia tipoDenuncia) {
        tipoDenunciaService.saveTipoDenuncia(tipoDenuncia);
        return "redirect:/tipoDenunciaPlayground";
    }

    @GetMapping("/deleteTipoDenuncia/{id}")
    public String deleteTipoDenuncia(@PathVariable Long id) {
        tipoDenunciaService.deleteTipoDenuncia(id);
        return "redirect:/tipoDenunciaPlayground";
    }
}