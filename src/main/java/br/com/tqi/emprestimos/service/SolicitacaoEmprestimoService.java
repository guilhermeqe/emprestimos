package br.com.tqi.emprestimos.service;

import br.com.tqi.emprestimos.model.SolicitacaoEmprestimo;
import br.com.tqi.emprestimos.repository.SolicitacaoEmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoEmprestimoService {

    @Autowired
    private SolicitacaoEmprestimoRepository repository;

    public SolicitacaoEmprestimo buscarPorId(Long id) {
        Optional<SolicitacaoEmprestimo> solicitacaoEmprestimo = this.repository.findById(id);
        if (solicitacaoEmprestimo.isPresent()) {
            return solicitacaoEmprestimo.get();
        } else {
            throw new RuntimeException("Solicitacao de emprestimo não encontrado.");
        }

    }

    public List<SolicitacaoEmprestimo> listarTodos() {
        return repository.findAll();
    }

    public SolicitacaoEmprestimo salvar(SolicitacaoEmprestimo solicitacaoEmprestimoOptional) {
        return this.repository.save(solicitacaoEmprestimoOptional);
    }

    public SolicitacaoEmprestimo atualizar(Long id, SolicitacaoEmprestimo solicitacaoEmprestimo) {
        Optional<SolicitacaoEmprestimo> solicitacaoEmprestimoOptional = this.repository.findById(id);
        if (solicitacaoEmprestimoOptional.isPresent()) {
            return this.repository.save(solicitacaoEmprestimo);
        } else {
            throw new RuntimeException("Solicitacao de emprestimo não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<SolicitacaoEmprestimo> solicitacaoEmprestimoOptional = this.repository.findById(id);
        if (solicitacaoEmprestimoOptional.isPresent()) {
            this.repository.delete(solicitacaoEmprestimoOptional.get());
        } else {
            throw new RuntimeException("Solicitacao de emprestimo não encontrado.");
        }
    }

}
