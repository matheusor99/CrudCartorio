package com.cartorio.TesteCartorio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cartorio.TesteCartorio.domain.Cartorio;
import com.cartorio.TesteCartorio.service.CartorioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Api Cartorio")
public class CartorioResource {
	
	@Autowired
	private CartorioService cartorioService;
	
	@PostMapping("/register")
	@ApiOperation(value="Cria um novo Cartorio")
	public ResponseEntity<String> register(@RequestBody Cartorio cartorio) {
		String result; 
		try {
			result = cartorioService.register(cartorio);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			result = "" + e;
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/update")
	@ApiOperation(value="Atualiza um Cartorio")
	public ResponseEntity<String> update(@RequestBody Cartorio cartorio) { 
		String result;
		try {
			result = cartorioService.update(cartorio);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			result = "" + e;
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value="Deleta um Cartorio")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		String result;
		try {
			result = cartorioService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			result = "" + e;
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/search/{id}")
	@ApiOperation(value="retorna um Cartorio")
	public ResponseEntity<Cartorio> searchCartorio(@PathVariable("id") Long id) {
		Cartorio result;
		result = cartorioService.searchCartorio(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/searchAll")
	@ApiOperation(value="Cria uma Lista de Cartorios")
	public ResponseEntity<List<Cartorio>> searchAllCartorio() {
		List<Cartorio> result;
		result = cartorioService.searchAllCartorio();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
