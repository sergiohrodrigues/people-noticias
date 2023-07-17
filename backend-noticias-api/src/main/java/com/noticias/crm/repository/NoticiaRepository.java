package com.noticias.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noticias.crm.model.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

}
