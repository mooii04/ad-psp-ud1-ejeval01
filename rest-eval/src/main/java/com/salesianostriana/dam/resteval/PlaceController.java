package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseExtractor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place/")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ListGetPlaceDto getAll(){
        return ListGetPlaceDto.of(placeService.getAll());
    }

    @GetMapping("{id}")
    public Place getById(@PathVariable Long id){
        return placeService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody CreatePlaceDto dto){
        return ResponseEntity.status(201).body(placeService.create(dto.toPlace()));
    }

    @PutMapping("{id}")
    public Place edit(
            @PathVariable Long id,
            @RequestBody CreatePlaceDto dto
    ){
        return placeService.edit(id, dto.toPlace());
    }

    @PutMapping("{id}/tag/add/{tag}")
    public Place addTag(
            @PathVariable Long id,
            @PathVariable String tag
    ){
        return placeService.addTagToPlace(id, tag);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        placeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
