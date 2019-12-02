package com.cartorio.TesteCartorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartorio.TesteCartorio.domain.Cartorio;
import com.cartorio.TesteCartorio.repository.CartorioRepository;

@Service
public class CartorioService {

	@Autowired
	private CartorioRepository cartorioRepository;
	
	public String register(Cartorio cartorio) {
		if(cartorio.getId() != null) {
			return "Cartório já existe!";
		}
		cartorioRepository.save(cartorio);
		return "Cartório cadastrado com sucesso";
	}
	
	public String update(Cartorio cartorio) {
		
		if(cartorio.getId() == null) {
			return  "Cartório não pode ser atualizado porque não existe";
		}
		
		cartorioRepository.save(cartorio);
		return "Cartório atualizado com sucesso!";
	}
	
	public String delete(Long id) {
		cartorioRepository.deleteById(id);
		return "Cartório excluido com sucesso!";
	}
	
	public List<Cartorio> searchAllCartorio() {
		List<Cartorio> result = cartorioRepository.findAll();
		return result;
	}
	
	public Cartorio searchCartorio(Long id) {
		Optional<Cartorio> result = cartorioRepository.findById(id);
		return result.get();
	}
}
