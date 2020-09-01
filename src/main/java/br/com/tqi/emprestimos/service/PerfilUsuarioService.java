package br.com.tqi.emprestimos.service;

import br.com.tqi.emprestimos.model.PerfilUsuario;
import br.com.tqi.emprestimos.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository repository;

    public PerfilUsuario buscarPorId(Long id) {
        Optional<PerfilUsuario> perfilUsuario = this.repository.findById(id);
        if (perfilUsuario.isPresent()) {
            return perfilUsuario.get();
        } else {
            throw new RuntimeException("Perfil do usuario não encontrado.");
        }

    }

    public List<PerfilUsuario> listarTodos() {
        return repository.findAll();
    }

    public PerfilUsuario salvar(PerfilUsuario cliente) {
        return this.repository.save(cliente);
    }

    public PerfilUsuario atualizar(Long id, PerfilUsuario perfilUsuario) {
        Optional<PerfilUsuario> perfilUsuarioOptional = this.repository.findById(id);
        if (perfilUsuarioOptional.isPresent()) {
            return this.repository.save(perfilUsuario);
        } else {
            throw new RuntimeException("Perfil do usuario não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<PerfilUsuario> perfilUsuario = this.repository.findById(id);
        if (perfilUsuario.isPresent()) {
            this.repository.delete(perfilUsuario.get());
        } else {
            throw new RuntimeException("Perfil do usuario não encontrado.");
        }
    }

}
