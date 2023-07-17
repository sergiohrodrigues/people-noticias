package com.noticias.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noticias.crm.model.Noticia;
import com.noticias.crm.repository.NoticiaRepository;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@GetMapping
	public List<Noticia> listar() {
		return noticiaRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Noticia noticiaById(@PathVariable Long id) {
		return noticiaRepository.findById(id).get();
	}
	
	@PostMapping
	public Noticia adicionar(@RequestBody Noticia noticia) {
		return noticiaRepository.save(noticia);
	}
	
	@PutMapping(value = "/{id}")
	public Noticia atualizar(@PathVariable Long id, @RequestBody Noticia noticia) {
		Noticia entidade = noticiaRepository.getReferenceById(id);
		entidade.setTitulo(noticia.getTitulo());
		entidade.setAutor(noticia.getAutor());
		entidade.setConteudo(noticia.getConteudo());
		entidade.setData(noticia.getData());
		return noticiaRepository.save(entidade);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		noticiaRepository.deleteById(id);
	}
}
