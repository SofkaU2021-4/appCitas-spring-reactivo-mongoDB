package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.Padecimiento;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PacienteRepository extends ReactiveMongoRepository<Padecimiento,String> {
    Flux<Padecimiento> findByIdPaciente(String idPaciente);
}
