package com.repos;

import com.domain.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepo  extends CrudRepository<Pet, Long> {

    List<Pet> findById(Integer intID);
}
