package com.practice.hackathon.repository;

import com.practice.hackathon.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AnimalRepository {
    List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimal() {
        return animals;
    }

    public Animal getAnimalById(Long id) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), id)) {
                return animal;
            }
        }
        return null;
    }

    public boolean add(Animal animal) {
        return animals.add(animal);
    }

    public boolean remove(Animal animal) {
        return animals.remove(animal);
    }

    public boolean update(Animal newAnimal) {
        for (Animal animal : animals) {
            if(Objects.equals(animal.getId(),newAnimal .getId())) {



                return true;
            }
        }
        return false;
    }

}
