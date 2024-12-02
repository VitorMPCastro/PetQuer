package com.petquer.petquer.repository;

import com.petquer.petquer.entity.TipoDenuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDenunciaRepository extends JpaRepository<TipoDenuncia, Long> {
}