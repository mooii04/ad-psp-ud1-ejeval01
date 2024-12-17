package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> getAll() {

        List<Place> result = placeRepository.getAll();

        if (result.isEmpty())
            throw new PlacesNotFoundException("No hay lugares con este criterio");

        return result;

    }

    public Place getById(Long id) {

        /*
        Optional<Place> result = placeRepository.findById(id);

        if(result.isPresent())
            return result.get();
        else
            throw new PlacesNotFoundException("No se ha encontrado el lugar con id: %d" .formatted(id));
         */

        return placeRepository.get(id).
                orElseThrow(() ->
                        new PlacesNotFoundException("No se ha encontrado el lugar con id: %d".formatted(id)));
    }

    public Place create(Place p) {
        return placeRepository.add(p);
    }

    public void deleteById(Long id) {
        placeRepository.delete(id);
    }

    public Place edit(Long id, Place p) {
        return placeRepository.edit(id, p)
                .orElseThrow(() -> new PlacesNotFoundException("No se ha encontrado el lugar con id: %d".formatted(id)));
    }

    public Place addTagToPlace(Long id, String tag) {
        // Buscar el tag
        // Añadir el tag
        // Modificar el tag

        Optional<Place> placeOpt = placeRepository.get(id);
        Place place;

        if (placeOpt.isPresent()) {
            place = placeOpt.get();
            place.addTag(tag);
            placeRepository.edit(id, place);

            return place;
        } else {
            throw new PlacesNotFoundException("No se ha encontrado el lugar con id: %d".formatted(id));
        }
        return place;

    }

}s
