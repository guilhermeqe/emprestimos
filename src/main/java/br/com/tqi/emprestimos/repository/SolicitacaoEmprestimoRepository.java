package br.com.tqi.emprestimos.repository;

import br.com.tqi.emprestimos.model.SolicitacaoEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoEmprestimoRepository extends JpaRepository<SolicitacaoEmprestimo, Long> {
}
