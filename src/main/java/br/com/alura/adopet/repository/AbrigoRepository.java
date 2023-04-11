package br.com.alura.adopet.repository;

import br.com.alura.adopet.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
}
