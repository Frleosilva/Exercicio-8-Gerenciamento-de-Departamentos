package com.atividade8.departamentos.Repositories;

import com.atividade8.departamentos.Models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
