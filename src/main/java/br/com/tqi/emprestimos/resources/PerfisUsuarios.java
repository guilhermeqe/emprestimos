package br.com.tqi.emprestimos.resources;

import br.com.tqi.emprestimos.model.PerfilUsuario;
import br.com.tqi.emprestimos.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfisUsuarios")
public class PerfisUsuarios {

    @Autowired
    private PerfilUsuarioService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PerfilUsuario buscarPorId(@PathVariable("id") Long id) {
        return this.service.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PerfilUsuario> listarTodos() {
        return this.service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PerfilUsuario salvar(@RequestBody PerfilUsuario perfilUsuario) {
        return this.service.salvar(perfilUsuario);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PerfilUsuario atualizar(@PathVariable("id") Long id, @RequestBody PerfilUsuario perfilUsuario) {
        return this.service.atualizar(id, perfilUsuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }
}
