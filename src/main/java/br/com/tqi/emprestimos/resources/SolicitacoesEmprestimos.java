package br.com.tqi.emprestimos.resources;


import br.com.tqi.emprestimos.model.SolicitacaoEmprestimo;
import br.com.tqi.emprestimos.service.SolicitacaoEmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacoesEmprestimos {

    @Autowired
    private SolicitacaoEmprestimoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SolicitacaoEmprestimo buscarPorId(@PathVariable("id") Long id) {
        return this.service.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SolicitacaoEmprestimo> listarTodos() {
        return this.service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitacaoEmprestimo salvar(@RequestBody SolicitacaoEmprestimo solicitacaoEmprestimo) {
        return this.service.salvar(solicitacaoEmprestimo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SolicitacaoEmprestimo atualizar(@PathVariable("id") Long id, @RequestBody SolicitacaoEmprestimo solicitacaoEmprestimo) {
        return this.atualizar(id, solicitacaoEmprestimo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }
}
