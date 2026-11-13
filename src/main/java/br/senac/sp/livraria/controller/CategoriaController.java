package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){this.categoriaService = categoriaService;}

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(201).body(categoriaService)
    }
}
