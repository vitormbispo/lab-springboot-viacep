package com.vitorbispo.lab_padroes_projeto.controller;

import com.vitorbispo.lab_padroes_projeto.model.Endereco;
import com.vitorbispo.lab_padroes_projeto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("enderecos")
public class EnderecoRestController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable("id") Long id) {
        return enderecoService.buscarPorId(id);
    }

    @GetMapping
    public Iterable<Endereco> buscarTodos() {
        return enderecoService.buscarTodods();
    }
}
