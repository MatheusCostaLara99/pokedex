package com.api.pokedex.services;

import com.api.pokedex.models.PokedexSlotModel;
import com.api.pokedex.repositories.PokedexSlotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class PokedexSlotService {

    final PokedexSlotRepository pokedexSlotRepository;

    public PokedexSlotService(PokedexSlotRepository pokedexSlotRepository) {
        this.pokedexSlotRepository = pokedexSlotRepository;
    }
    @Transactional
    public PokedexSlotModel save(PokedexSlotModel pokedexSlotModel) {
        return pokedexSlotRepository.save(pokedexSlotModel);
    }

    public boolean existsByPokemonNickname(String pokemonNickname) {
        return pokedexSlotRepository.existsByPokemonNickname(pokemonNickname);
    }

    public Page<PokedexSlotModel> findAll(Pageable pageable) {
        return pokedexSlotRepository.findAll(pageable);
    }

    public Optional<PokedexSlotModel> findById(UUID id) {
        return pokedexSlotRepository.findById(id);
    }

    @Transactional
    public void delete(PokedexSlotModel pokedexSlotModel) {
        pokedexSlotRepository.delete(pokedexSlotModel);
    }
}
