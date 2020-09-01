package br.com.tqi.emprestimos.service;

import br.com.tqi.emprestimos.model.Emprestimo;
import br.com.tqi.emprestimos.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository repository;

    public Emprestimo buscarPorId(Long id) {
        Optional<Emprestimo> emprestimoOptional = this.repository.findById(id);
        if (emprestimoOptional.isPresent()) {
            return emprestimoOptional.get();
        } else {
            throw new RuntimeException("Emprestimo não encontrado.");
        }

    }

    public List<Emprestimo> listarTodos() {
        return repository.findAll();
    }

    public Emprestimo salvar(Emprestimo emprestimo) {
        return this.repository.save(emprestimo);
    }

    public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
        Optional<Emprestimo> emprestimoOptional = this.repository.findById(id);
        if (emprestimoOptional.isPresent()) {
            return this.repository.save(emprestimo);
        } else {
            throw new RuntimeException("Emprestimo não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Emprestimo> emprestimoOptional = this.repository.findById(id);
        if (emprestimoOptional.isPresent()) {
            this.repository.delete(emprestimoOptional.get());
        } else {
            throw new RuntimeException("Emprestimo não encontrado.");
        }
    }
}
