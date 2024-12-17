package com.salesianostriana.dam.resteval;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private HashMap<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Place.builder()
                .name("Bar Manolo")
                .address("Calle de la Esperanza, 18, 41002 Sevilla")
                .coords("37.382830,-5.973170")
                .desc("Bar Manolo es un bar de tapas en el centro de Sevilla. Es un lugar muy popular entre los turistas y los locales.")
                .image("https://lh5.googleusercontent.com/p/AF1QipO1")
                .tags(new ArrayList<>(List.of("tapas", "cerveza")))
                .build());
        add(Place.builder()
                .name("Bar Pepe")
                .address("Calle de la Esperanza, 20, 41002 Sevilla")
                .coords("37.382830,-5.973170")
                .desc("Bar Pepe es un bar de tapas en el centro de Sevilla. Es un lugar muy popular entre los turistas y los locales.")
                .image("https://lh5.googleusercontent.com/p/AF1QipO1")
                .tags(new ArrayList<>(List.of("tapas", "cerveza")))
                .build());
        add(Place.builder()
                .name("Bar Juan")
                .address("Calle de la Esperanza, 22, 41002 Sevilla")
                .coords("37.382830,-5.973170")
                .desc("Bar Juan es un bar de tapas en el centro de Sevilla. Es un lugar muy popular entre los turistas y los locales.")
                .image("https://lh5.googleusercontent.com/p/AF1QipO1")
                .tags(new ArrayList<>(List.of("tapas", "cerveza")))
                .build());
    }

    public Place add(Place place) {
        var id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return List.copyOf(places.values());
    }

    public Optional<Place> findById(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public Optional<Place> edit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k,v) -> {
            v.setName(place.getName());
            v.setDesc(place.getDesc());
            v.setImage(place.getImage());
            v.setCoords(place.getCoords());
            v.setAddress(place.getAddress());
            return v;
        }));
    }

    public Optional<Place> completeEdit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k,v) -> {
            
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }


}
