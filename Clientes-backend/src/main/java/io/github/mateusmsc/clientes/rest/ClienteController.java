package io.github.mateusmsc.clientes.rest;

import io.github.mateusmsc.clientes.model.entity.Cliente;
import io.github.mateusmsc.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
// Mapeamento da url base
@RequestMapping ("/api/clientes")
// liberação de acesso ao backend por outras aplicações
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // Indicar ao método que o cliente é um JSON da requisição
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable("id") Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }

    @GetMapping
    public List<Cliente> obterTodos(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Integer id){
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        repository
                .findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setDataCadastro(clienteAtualizado.getDataCadastro());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
