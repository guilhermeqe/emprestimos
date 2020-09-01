package br.com.tqi.emprestimos.resources;

import br.com.tqi.emprestimos.model.Cliente;
import br.com.tqi.emprestimos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class Clientes {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarPorId(@PathVariable("id") Long id) {
        return this.service.buscarPorId(id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarTodos() {
        return this.service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {
        return this.service.salvar(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return this.service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }


}
