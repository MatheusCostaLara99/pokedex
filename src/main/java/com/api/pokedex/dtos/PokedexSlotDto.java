package com.api.pokedex.dtos;

import javax.validation.constraints.NotBlank;

public class PokedexSlotDto {

    @NotBlank
    private String pokemonNumber;
    @NotBlank
    private String pokemonNickname;
    @NotBlank
    private String pokemonName;
    @NotBlank
    private String pokemonHeight;
    @NotBlank
    private String pokemonWeight;
    @NotBlank
    private String pokemonType;
    @NotBlank
    private String pokemonAttack;
    @NotBlank
    private String pokemonDescription;

    public String getPokemonNumber() {
        return pokemonNumber;
    }

    public void setPokemonNumber(String pokemonNumber) {
        this.pokemonNumber = pokemonNumber;
    }

    public String getPokemonNickname() {
        return pokemonNickname;
    }

    public void setPokemonNickname(String pokemonNickname) {
        this.pokemonNickname = pokemonNickname;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonHeight() {
        return pokemonHeight;
    }

    public void setPokemonHeight(String pokemonHeight) {
        this.pokemonHeight = pokemonHeight;
    }

    public String getPokemonWeight() {
        return pokemonWeight;
    }

    public void setPokemonWeight(String pokemonWeight) {
        this.pokemonWeight = pokemonWeight;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getPokemonAttack() {
        return pokemonAttack;
    }

    public void setPokemonAttack(String pokemonAttack) {
        this.pokemonAttack = pokemonAttack;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public void setPokemonDescription(String pokemonDescription) {
        this.pokemonDescription = pokemonDescription;
    }
}
