package com.api.pokedex.controllers;

import com.api.pokedex.dtos.PokedexSlotDto;
import com.api.pokedex.models.PokedexSlotModel;
import com.api.pokedex.services.PokedexSlotService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pokedex-slot")
public class PokedexSlotController {

    final PokedexSlotService pokedexSlotService;

    public PokedexSlotController(PokedexSlotService pokedexSlotService) {
        this.pokedexSlotService = pokedexSlotService;
    }

    @PostMapping
    public ResponseEntity<Object> savePokedexSlot(@RequestBody @Valid PokedexSlotDto pokedexSlotDto) {

        if (pokedexSlotService.existsByPokemonNickname(pokedexSlotDto.getPokemonNickname())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This pokemon already exists!!");
        }
        var pokedexSlotModel = new PokedexSlotModel();
        BeanUtils.copyProperties(pokedexSlotDto, pokedexSlotModel);
        pokedexSlotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pokedexSlotService.save(pokedexSlotModel));

    }

    @GetMapping()
    public ResponseEntity<Page<PokedexSlotModel>> getAllPokedexSlots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pokedexSlotService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePokedexSlot(@PathVariable(value = "id") UUID id){
        Optional<PokedexSlotModel> pokedexSlotModelOptional = pokedexSlotService.findById(id);
        if(!pokedexSlotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pokémon not found.");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(pokedexSlotModelOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePokedexSlot(@PathVariable(value = "id") UUID id){
        Optional<PokedexSlotModel> pokedexSlotModelOptional = pokedexSlotService.findById(id);
        if(!pokedexSlotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pokémon not found.");
        }else{
            pokedexSlotService.delete(pokedexSlotModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Pokémon released successfully!!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePokedexSlot(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid PokedexSlotDto pokedexSlotDto){
        Optional<PokedexSlotModel> pokedexSlotModelOptional = pokedexSlotService.findById(id);
        if(!pokedexSlotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("pokémon not found.");
        }else{
            var pokedexSlotModel = new PokedexSlotModel();
            BeanUtils.copyProperties(pokedexSlotDto, pokedexSlotModel);
            pokedexSlotModel.setId(pokedexSlotModelOptional.get().getId());
            pokedexSlotModel.setRegistrationDate(pokedexSlotModelOptional.get().getRegistrationDate());
            return ResponseEntity.status(HttpStatus.OK).body(pokedexSlotService.save(pokedexSlotModel));
        }
    }
}
