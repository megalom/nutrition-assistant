package ru.megalom.nutritionassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.megalom.nutritionassistant.model.EatType;

public interface EatTypeRepository extends JpaRepository<EatType,Integer> {
}
