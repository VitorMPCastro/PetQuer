package com.petquer.petquer.service;

import com.petquer.petquer.entity.TipoDenuncia;
import com.petquer.petquer.repository.TipoDenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDenunciaService {

    @Autowired
    private TipoDenunciaRepository tipoDenunciaRepository;

    public List<TipoDenuncia> getAllTipoDenuncias() {
        return tipoDenunciaRepository.findAll();
    }

    public TipoDenuncia getTipoDenunciaById(Long id) {
        return tipoDenunciaRepository.findById(id).orElse(null);
    }

    public TipoDenuncia saveTipoDenuncia(TipoDenuncia tipoDenuncia) {
        return tipoDenunciaRepository.save(tipoDenuncia);
    }

    public void deleteTipoDenuncia(Long id) {
        tipoDenunciaRepository.deleteById(id);
    }
}