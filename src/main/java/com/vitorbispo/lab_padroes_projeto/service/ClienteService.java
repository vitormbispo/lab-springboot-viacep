package com.vitorbispo.lab_padroes_projeto.service;

import com.vitorbispo.lab_padroes_projeto.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
