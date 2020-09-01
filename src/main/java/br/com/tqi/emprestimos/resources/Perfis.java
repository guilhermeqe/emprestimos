package br.com.tqi.emprestimos.resources;

import br.com.tqi.emprestimos.model.Perfil;
import br.com.tqi.emprestimos.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class Perfis {

    @Autowired
    private PerfilService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Perfil buscarPorId(@PathVariable("id") Long id) {
        return this.service.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Perfil> listarTodos() {
        return this.service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Perfil salvar(@RequestBody Perfil perfil) {
        return this.service.salvar(perfil);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Perfil atualizar(@PathVariable("id") Long id, @RequestBody Perfil perfil) {
        return this.service.atualizar(id, perfil);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }

}
