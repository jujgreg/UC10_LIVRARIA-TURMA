package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    private EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository){
        this.editoraRepository = editoraRepository;
    }

    public Editora salvar(Editora editora){
        return editoraRepository.save(editora);
    }

    public List<Editora> listarEditoras(){return editoraRepository.findAll();}

    public Optional buscarEditoraPorId(int id){return editoraRepository.findById(id);}

    public boolean excluirEditora(int id){
        Optional<Editora> EditoraExcluir = editoraRepository.findById(id);

        if(EditoraExcluir.isPresent()){
            editoraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Editora atluaziarEditora(Editora novaEditora){
        Optional<Editora> EditoraAtual = editoraRepository.findById(novaEditora.getId());

        if(EditoraAtual.isPresent()){
            return editoraRepository.save(novaEditora);
        }
        return null;
    }

}
