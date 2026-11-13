package br.senac.sp.livraria.repository;

import br.senac.sp.livraria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
