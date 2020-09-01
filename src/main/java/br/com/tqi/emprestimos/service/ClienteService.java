package br.com.tqi.emprestimos.service;

import br.com.tqi.emprestimos.model.Cliente;
import br.com.tqi.emprestimos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> clienteOptional = this.repository.findById(id);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }

    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return this.repository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = this.repository.findById(id);
        if (clienteOptional.isPresent()) {
            return this.repository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Cliente> clienteOptional = this.repository.findById(id);
        if (clienteOptional.isPresent()) {
            this.repository.delete(clienteOptional.get());
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }
    }

}
