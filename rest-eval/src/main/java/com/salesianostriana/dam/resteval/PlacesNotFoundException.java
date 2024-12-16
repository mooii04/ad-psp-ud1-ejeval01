package com.salesianostriana.dam.resteval;

public class PlacesNotFoundException extends RuntimeException {

    public PlacesNotFoundException(Long id){
        super("No se ha encontrado el lugar con id: " + id);
    }

    public PlacesNotFoundException(String message) {
        super(message);
    }

    public PlacesNotFoundException(){
        super("No se han encontrado lugares");
    }
}
