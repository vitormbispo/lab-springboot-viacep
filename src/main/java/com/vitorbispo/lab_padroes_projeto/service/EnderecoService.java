package com.vitorbispo.lab_padroes_projeto.service;

import com.vitorbispo.lab_padroes_projeto.model.Endereco;

public interface EnderecoService {
    public Endereco buscarPorId(Long id);
    public Iterable<Endereco> buscarTodods();
}
