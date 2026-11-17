package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){this.categoriaRepository = categoriaRepository;}

    public Categoria savarCategoria(Categoria categoria){return categoriaRepository.save(categoria);}

    public List<Categoria> listaCategoria(){
        return categoriaRepository.findAll();

    }

    public Optional buscarCategoriaPorId(int id){
        return categoriaRepository.findById(id);


    }

    public boolean excluirCategoria(int id){
        Optional<Categoria> ExcluirCategoria = categoriaRepository.findById(id);

        if(ExcluirCategoria.isPresent()){
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Categoria atualizarCategoria(Categoria novaCategoria){
        Optional<Categoria> categoriaAtual = categoriaRepository.findById(novaCategoria.getId());

        if(categoriaAtual.isPresent()){
            return categoriaRepository.save(novaCategoria);

        }

        return null;
    }

}
