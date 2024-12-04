package com.petquer.petquer.service;

import com.petquer.petquer.entity.Pagamento;
import com.petquer.petquer.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento findById(Integer id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        pagamentoRepository.deleteById(id);
    }
}