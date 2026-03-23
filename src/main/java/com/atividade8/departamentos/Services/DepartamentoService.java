package com.atividade8.departamentos.Services;

import com.atividade8.departamentos.Models.DepartamentoModel;
import com.atividade8.departamentos.Repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel save(DepartamentoModel departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<DepartamentoModel> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }
}