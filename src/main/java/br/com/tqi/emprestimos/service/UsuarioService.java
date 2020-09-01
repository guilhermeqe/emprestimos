package br.com.tqi.emprestimos.service;

import br.com.tqi.emprestimos.model.Usuario;
import br.com.tqi.emprestimos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = this.repository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Usuario não encontrado.");
        }

    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return this.repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = this.repository.findById(id);
        if (usuarioOptional.isPresent()) {
            return this.repository.save(usuario);
        } else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Usuario> usuarioOptional = this.repository.findById(id);
        if (usuarioOptional.isPresent()) {
            this.repository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }
}
