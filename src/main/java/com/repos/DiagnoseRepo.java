package com.repos;

import com.domain.Diagnose;
import com.domain.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnoseRepo extends CrudRepository<Diagnose, Long> {
    List<Diagnose> findByPet(List<Pet> pet);
}
