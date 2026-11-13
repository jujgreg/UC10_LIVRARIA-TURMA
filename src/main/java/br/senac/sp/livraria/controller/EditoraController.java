package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.service.EditoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/editoras")
public class EditoraController {

    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService){
        this.editoraService = editoraService;
    }

    @PostMapping
    public ResponseEntity<Editora> salvar(@RequestBody Editora editora){
        return ResponseEntity
                .status(201)
                .body(editoraService
                        .salvar(editora));
    }


    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras(){

        return ResponseEntity.ok(editoraService.listarEditoras());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Editora> buscarEditoraPorId(@PathVariable("codigo") int id){
        Optional<Editora> EditoraEncontrada = editoraService.buscarEditoraPorId(id);

        if(EditoraEncontrada.isPresent()){
            return ResponseEntity.ok(EditoraEncontrada.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEditora(@PathVariable("id")int id){
        if(editoraService.excluirEditora(id)){
            return ResponseEntity.status(204).build();
        }
        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", "A editora com ID " + id + " Não foi encontrada!");
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(404).body(erro);
    }
    @PutMapping
    public ResponseEntity<Editora> atualizarEditora(@RequestBody Editora editoraAtualizada){

        Editora novaEditora = editoraService.atluaziarEditora(editoraAtualizada);

        if(novaEditora != null){
            return ResponseEntity.status(200).body(novaEditora);
        }
        return ResponseEntity.status(404).build();
    }




}
