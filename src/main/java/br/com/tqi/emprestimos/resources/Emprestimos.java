package br.com.tqi.emprestimos.resources;

import br.com.tqi.emprestimos.model.Emprestimo;
import br.com.tqi.emprestimos.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class Emprestimos {

    @Autowired
    private EmprestimoService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo buscarPorId(@PathVariable("id") Long id) {
        return this.service.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Emprestimo> listarTodos() {
        return this.service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo) {
        return this.service.salvar(emprestimo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo atualizar(@PathVariable("id") Long id, @RequestBody Emprestimo emprestimo) {
        return this.service.atualizar(id, emprestimo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }

}

