package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){this.categoriaRepository = categoriaRepository;}

    public Categoria savarCategoria(Categoria)
}
