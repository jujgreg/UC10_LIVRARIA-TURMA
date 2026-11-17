package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){this.categoriaService = categoriaService;}

    @PostMapping
    public ResponseEntity<CategoriaService> salvarCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(201).body(categoriaService);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategoria(){
        return ResponseEntity.ok(categoriaService.listaCategoria());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("codigo") int id){
        Optional<Categoria> categoriaEncontrada = categoriaService.buscarCategoriaPorId(id);

        if (categoriaEncontrada.isPresent()){
            return ResponseEntity.ok(categoriaEncontrada.get());

        }else {
            return ResponseEntity.notFound().build();

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCategoria(@PathVariable("id") int id){
        if (categoriaService.excluirCategoria(id)){
            return ResponseEntity.status(204).build();
        }

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", "A categoria com ID " + id + " não foi encontrado!");
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(404).body(erro);
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoriaAtualizado){

        Categoria novaCategoria = categoriaService.atualizarCategoria(categoriaAtualizado);

        if(novaCategoria != null){
            return ResponseEntity.status(200).body(novaCategoria);
        }

        return ResponseEntity.status(404).build();
    }
}
