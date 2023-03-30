package br.com.alura.adopet.repository;

import br.com.alura.adopet.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}