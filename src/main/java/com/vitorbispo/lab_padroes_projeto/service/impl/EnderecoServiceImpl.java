package com.vitorbispo.lab_padroes_projeto.service.impl;

import com.vitorbispo.lab_padroes_projeto.model.Endereco;
import com.vitorbispo.lab_padroes_projeto.model.EnderecoRepository;
import com.vitorbispo.lab_padroes_projeto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Endereco> buscarTodods() {
        return enderecoRepository.findAll();
    }
}
