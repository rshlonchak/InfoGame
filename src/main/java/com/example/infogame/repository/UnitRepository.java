package com.example.infogame.repository;

import com.example.infogame.dto.unit.UnitResponseDto;
import com.example.infogame.models.Unit;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Integer> {

    @Query("SELECT * FROM units")
    List<UnitResponseDto> listUnits();

    @Query("SELECT * FROM units WHERE id=:itemId")
    Optional<Unit> getUnitById(int itemId);

    @Modifying
    @Query("UPDATE units SET name=:name, description=:description, image=:image WHERE id=:itemId")
    void updateUnit(int itemId, String name, String description, String image);
}
