package com.pedroso.apilog.application.api;

import com.pedroso.apilog.application.repository.ClienteRepository;
import com.pedroso.apilog.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Cliente create(@Valid @RequestBody Cliente cliente ) {
        log.info("[Start] ClienteController - create");
        Cliente savedClient = clienteRepository.save(cliente);
        log.info("[Finish] ClienteController - create");
        return savedClient;
    }

    @GetMapping
    public List<Cliente> listAll() {
        log.info("[Start] ClienteController - listAll");
        List<Cliente> listAll = clienteRepository.findAll();
        log.info("[Finish] ClienteController - listAll");
        return listAll;
    }

    @GetMapping("/{clienteId}")
    public Optional<Cliente> findById( @PathVariable Long clienteId) {
        log.info("[Start] ClienteController - findById");
        Optional<Cliente> findById = clienteRepository.findById(clienteId);
        log.info("[Finish] ClienteController - findById");
        return findById;
    }

    @PutMapping("/{clienteId}")
    @ResponseStatus()
    public ResponseEntity<Cliente> modify(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){
        log.info("[Start] ClienteController - modify");
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);
        log.info("[Finish] ClienteController - modify");
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long clienteId) {
        log.info("[Start] ClienteController - delete");
        clienteRepository.deleteById(clienteId);
        log.info("[Fisish] ClienteController - delete");
    }
}
