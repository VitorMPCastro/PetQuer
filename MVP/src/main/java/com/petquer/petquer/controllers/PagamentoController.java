package com.petquer.petquer.controllers;

import com.petquer.petquer.entity.Pagamento;
import com.petquer.petquer.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/add")
    public String addPagamentoForm(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        return "addPagamento";
    }

    @PostMapping("/add")
    public String addPagamento(@ModelAttribute Pagamento pagamento) {
        pagamentoService.save(pagamento);
        return "redirect:/pagamento/list";
    }

    @GetMapping("/edit/{id}")
    public String editPagamentoForm(@PathVariable Integer id, Model model) {
        Pagamento pagamento = pagamentoService.findById(id);
        model.addAttribute("pagamento", pagamento);
        return "editPagamento";
    }

    @PostMapping("/edit/{id}")
    public String editPagamento(@PathVariable Integer id, @ModelAttribute Pagamento pagamento) {
        pagamento.setIdPagamento(id);
        pagamentoService.save(pagamento);
        return "redirect:/pagamento/list";
    }

    @GetMapping("/list")
    public String listPagamentos(Model model) {
        model.addAttribute("pagamentos", pagamentoService.findAll());
        return "listPagamentos";
    }
}