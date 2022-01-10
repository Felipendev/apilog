package com.pedroso.apilog.application.service;

import com.pedroso.apilog.application.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

}
