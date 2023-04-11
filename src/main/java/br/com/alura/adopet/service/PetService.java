package br.com.alura.adopet.service;

import br.com.alura.adopet.dto.pet.DadosAtualizaPet;
import br.com.alura.adopet.dto.pet.DadosCadastroPet;
import br.com.alura.adopet.dto.pet.DadosDetalhesPet;
import br.com.alura.adopet.dto.pet.DadosListagemPet;
import br.com.alura.adopet.model.Abrigo;
import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.repository.AbrigoRepository;
import br.com.alura.adopet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    public DadosCadastroPet cadastrar(DadosCadastroPet dados) {
        Abrigo abrigo = abrigoRepository.getReferenceById(dados.abrigoId());

        Pet pet = new Pet(dados);
        pet.setAbrigo(abrigo);

        petRepository.save(pet);
        return new DadosCadastroPet(pet);
    }

    public DadosDetalhesPet atualizar(DadosAtualizaPet dados) {
        Pet pet = petRepository.getReferenceById(dados.id());
        pet.atualizaPet(dados);
        return new DadosDetalhesPet(pet);
    }

    public DadosDetalhesPet detalhar(Long id)  {
        if (!petRepository.existsById(id)) {
            return null;
        }

        Pet pet = petRepository.getReferenceById(id);
        return new DadosDetalhesPet(pet);
    }

    public Page<DadosListagemPet> listarTodos(Pageable paginacao) {
        return petRepository.findAll(paginacao).map(DadosListagemPet::new);
    }

    public Boolean deletar(Long id) {
        if (!petRepository.existsById(id)) {
            return false;
        }

        petRepository.deleteById(id);
        return true;
    }
}
