package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place/")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceRepository placeRepository;

    @GetMapping
    public List<PlaceDto> getAll(){
        return placeRepository.getAll().stream().map(PlaceDto::toPlace).toList();
    }

    @GetMapping("{id}")
    public PlaceDto getOne(@PathVariable Long id){
        return PlaceDto.toPlace(placeRepository.findById(id).orElseThrow(() -> new PlacesNotFoundException(id)));
    }

    @PostMapping
    public PlaceDto create(@RequestBody Place place){
        return PlaceDto.toPlace(placeRepository.add(place));
    }

    @PutMapping("{id}")
    public PlaceDto edit(@PathVariable Long id, @RequestBody Place place) {

        if (!placeRepository.findById(id).isPresent()) {
            throw new PlacesNotFoundException(id);
        }

        return PlaceDto.toPlace(placeRepository.edit(id, place));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        placeRepository.delete(id);
    }

}
