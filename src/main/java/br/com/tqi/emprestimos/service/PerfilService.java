package br.com.tqi.emprestimos.service;

import br.com.tqi.emprestimos.model.Perfil;
import br.com.tqi.emprestimos.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    public Perfil buscarPorId(Long id) {
        Optional<Perfil> perfilOptional = this.repository.findById(id);
        if (perfilOptional.isPresent()) {
            return perfilOptional.get();
        } else {
            throw new RuntimeException("Perfil não encontrado.");
        }

    }

    public List<Perfil> listarTodos() {
        return repository.findAll();
    }

    public Perfil salvar(Perfil perfil) {
        return this.repository.save(perfil);
    }

    public Perfil atualizar(Long id, Perfil perfil) {
        Optional<Perfil> perfilOptional = this.repository.findById(id);
        if (perfilOptional.isPresent()) {
            return this.repository.save(perfil);
        } else {
            throw new RuntimeException("Perfil não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Perfil> perfilOptional = this.repository.findById(id);
        if (perfilOptional.isPresent()) {
            this.repository.delete(perfilOptional.get());
        } else {
            throw new RuntimeException("Perfil não encontrado.");
        }
    }
}
