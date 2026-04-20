package com.practice.hackathon.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Animal {
    private Long id;
    @NotNull(message = "Bạn phải nhậpn tên từ 5 đến 150 kí tự" )

    private String name;
    @NotBlank(message = "Bạn phải nhập loài của động vật ")
    private String species;
    @Min(value = 0, message = "Tuổi phải là số nguyên lớn hơn hoặc bằng 0")
    private Integer age;
    private String animalImage;

    public Animal() {
    }

    public Animal(Long id, String name, String species, Integer age, String animalImage) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.animalImage = animalImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

}
