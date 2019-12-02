package com.cartorio.TesteCartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartorio.TesteCartorio.domain.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{

}
