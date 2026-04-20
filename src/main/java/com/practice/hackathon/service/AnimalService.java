package com.practice.hackathon.service;

import com.practice.hackathon.model.Animal;
import com.practice.hackathon.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private static Long count = 1L;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimal(String search) {
        if(search == null || search.isEmpty()) {
            return animalRepository.getAnimal();
        }
        return List.of();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.getAnimalById(id);
    }

    public boolean addAnimal(Animal animal, String thumbnail) {
        animal.setId(count++);
        return animalRepository.add(animal);
    }

    public boolean removeAnimal(Long id) {
        Animal animal = animalRepository.getAnimalById(id);
        return animalRepository.remove(animal);
    }

    public boolean updateAnimal(Animal animal, String thumbnail) {
        return animalRepository.update(animal);
    }


}
