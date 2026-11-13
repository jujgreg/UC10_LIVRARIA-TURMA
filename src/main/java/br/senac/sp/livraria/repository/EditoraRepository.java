package br.senac.sp.livraria.repository;

import br.senac.sp.livraria.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {
}
