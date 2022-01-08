package com.pedroso.apilog.application.api;

import com.pedroso.apilog.domain.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listAll() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Fulano");
        cliente1.setEmail("fulano@gmail.com");
        cliente1.setTelefone("99 99999-9999");
        return Arrays.asList(cliente1);
    }
}
