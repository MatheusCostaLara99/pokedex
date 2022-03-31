package com.api.pokedex.repositories;

import com.api.pokedex.models.PokedexSlotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PokedexSlotRepository extends JpaRepository<PokedexSlotModel, UUID> {


    boolean existsByPokemonNickname(String pokemonNickname);
}
