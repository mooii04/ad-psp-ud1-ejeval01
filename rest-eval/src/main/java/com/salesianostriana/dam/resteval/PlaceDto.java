package com.salesianostriana.dam.resteval;

import java.util.Optional;

public record PlaceDto(
        Long id,
        String name,
        String coords,
        String image
) {

    public static PlaceDto toPlace(Place p) {
        return new PlaceDto(
                p.getId(),
                p.getName(),
                p.getCoords(),
                p.getImage()
        );
    }

    public static PlaceDto toPlace(Optional<Place> p) {
        return p.map(PlaceDto::toPlace).orElse(null);
    }

}
