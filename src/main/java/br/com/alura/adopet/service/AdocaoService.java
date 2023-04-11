package br.com.alura.adopet.service;

import br.com.alura.adopet.dto.adocao.DadosNovaAdocao;
import br.com.alura.adopet.model.Adocao;
import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.model.Tutor;
import br.com.alura.adopet.repository.AdocaoRepository;
import br.com.alura.adopet.repository.PetRepository;
import br.com.alura.adopet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public DadosNovaAdocao adotar(DadosNovaAdocao dados) {
        Pet pet = petRepository.getReferenceById(dados.petId());
        Tutor tutor = tutorRepository.getReferenceById(dados.tutorId());

        Adocao adocao = new Adocao(dados);
        adocao.setPet(pet);
        adocao.setTutor(tutor);

        pet.petAdotado();

        petRepository.save(pet);
        adocaoRepository.save(adocao);
        return new DadosNovaAdocao(adocao);
    }

}
