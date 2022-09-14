package br.edu.maurigvs.hrworker.repositories;

import br.edu.maurigvs.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}