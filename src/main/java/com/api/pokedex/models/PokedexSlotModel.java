package com.api.pokedex.models;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_POKEDEX_SLOT")
public class PokedexSlotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 4)
    private String pokemonNumber;
    @Column(nullable = false, unique = true, length = 70)
    private String pokemonNickname;
    @Column(nullable = false, length = 70)
    private String pokemonName;
    @Column(nullable = false, length = 10)
    private String pokemonHeight;
    @Column(nullable = false, length = 10)
    private String pokemonWeight;
    @Column(nullable = false, length = 50)
    private String pokemonType;
    @Column(nullable = false, length = 2000)
    private String pokemonAttack;
    @Column(nullable = false, length = 1000)
    private String pokemonDescription;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
