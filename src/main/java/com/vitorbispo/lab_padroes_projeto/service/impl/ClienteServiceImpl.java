package com.vitorbispo.lab_padroes_projeto.service.impl;

import com.vitorbispo.lab_padroes_projeto.model.Cliente;
import com.vitorbispo.lab_padroes_projeto.model.ClienteRepository;
import com.vitorbispo.lab_padroes_projeto.model.Endereco;
import com.vitorbispo.lab_padroes_projeto.model.EnderecoRepository;
import com.vitorbispo.lab_padroes_projeto.service.ClienteService;
import com.vitorbispo.lab_padroes_projeto.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()) {
            clienteRepository.save(cliente);
            enderecoRepository.save(cliente.getEndereco());
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = viaCepService.consultarCep(cep);
        enderecoRepository.save(endereco);

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
