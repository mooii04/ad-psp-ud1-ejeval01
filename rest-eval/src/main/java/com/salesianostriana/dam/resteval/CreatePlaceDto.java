package com.salesianostriana.dam.resteval;

public record CreatePlaceDto(
        String name,
        String address,
        String coords,
        String image,
        String desc
) {

    /*
    public static Place toPlace (CreatePlaceDto dto){
        return Place.builder()
                .name(dto.name())
                .address(dto.address())
                .coords(dto.coords())
                .image(dto.image())
                .desc(dto.desc())
                .build();
    }
    */

    public Place toPlace() {
        return Place.builder()
                .name(name())
                .address(address())
                .coords(coords())
                .image(image())
                .desc(desc())
                .build();
    }

}
