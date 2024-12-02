package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.Reserva;
import com.petquer.petquer.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservaPlayground")
public class ReservaPlaygroundController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public String viewReservaPlayground(Model model) {
        List<Reserva> reservas = reservaService.getAllReservas();
        model.addAttribute("reservas", reservas);
        return "reservaPlayground";
    }

    @GetMapping("/addReserva")
    public String showAddReservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "addReserva";
    }

    @PostMapping("/addReserva")
    public String addReserva(@ModelAttribute Reserva reserva) {
        reservaService.saveReserva(reserva);
        return "redirect:/reservaPlayground";
    }

    @GetMapping("/editReserva/{id}")
    public String editReservaForm(@PathVariable Long id, Model model) {
        Reserva reserva = reservaService.getReservaById(id);
        model.addAttribute("reserva", reserva);
        return "editReserva";
    }

    @PostMapping("/editReserva/{id}")
    public String editReserva(@PathVariable Long id, @ModelAttribute Reserva reserva) {
        reservaService.saveReserva(reserva);
        return "redirect:/reservaPlayground";
    }

    @GetMapping("/deleteReserva/{id}")
    public String deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return "redirect:/reservaPlayground";
    }
}