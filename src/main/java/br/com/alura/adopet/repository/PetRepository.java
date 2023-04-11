package br.com.alura.adopet.repository;

import br.com.alura.adopet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
