package com.example.infogame.service;

import com.example.infogame.dto.unit.UnitCreateDto;
import com.example.infogame.dto.unit.UnitDtoMapper;
import com.example.infogame.dto.unit.UnitResponseDto;
import com.example.infogame.dto.unit.UnitUpdateDto;
import com.example.infogame.models.Unit;
import com.example.infogame.repository.UnitRepository;
import com.example.infogame.validation.DtoValidator;
import com.example.infogame.validation.DtoValidatorImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UnitService {

    public static final String UNIT_NOT_FOUND = "Unit not found";

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<UnitResponseDto> getUnits() {
        return unitRepository.listUnits();
    }

    public UnitResponseDto createUnit(UnitCreateDto unitCreateDto) {
        DtoValidator<UnitCreateDto> validator = new DtoValidatorImpl<>();
        validator.validate(unitCreateDto);

        Unit unit = unitRepository.save(UnitDtoMapper.INSTANCE.fromEntity(unitCreateDto));
        return UnitDtoMapper.INSTANCE.unitResponseFromEntity(unit);
    }

    public Unit getUnitByIdOrNotFound(int unitId) throws ItemNotFoundException {
        Optional<Unit> unitOptional = unitRepository.getUnitById(unitId);
        if (unitOptional.isEmpty()) throw new ItemNotFoundException(UNIT_NOT_FOUND);
        return unitOptional.get();
    }

    public UnitResponseDto getUnitById(int unitId) {
        Unit unit = getUnitByIdOrNotFound(unitId);
        return UnitDtoMapper.INSTANCE.unitResponseFromEntity(unit);
    }

    public UnitResponseDto updateUnit(int unitId, UnitUpdateDto unitUpdateDto) {
        DtoValidator<UnitUpdateDto> validator = new DtoValidatorImpl<>();
        validator.validate(unitUpdateDto);

        Unit unit = getUnitByIdOrNotFound(unitId);
        try {
            updateUnit(unitId, unitUpdateDto, unit);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return UnitDtoMapper.INSTANCE.unitResponseFromEntity(getUnitByIdOrNotFound(unitId));
    }

    private void updateUnit(int unitId, UnitUpdateDto unitUpdateDto, Unit unit) {
        String name = Objects.isNull(unitUpdateDto.getName()) ? unit.getName() : unitUpdateDto.getName();
        String description = Objects.isNull(unitUpdateDto.getDescription()) ? unit.getDescription() : unitUpdateDto.getDescription();
        String image = Objects.isNull(unitUpdateDto.getImage()) ? unit.getImage() : unitUpdateDto.getImage();
        unitRepository.updateUnit(unitId, name, description, image);
    }

    public void deleteUnit(int unitId) {
        Unit unit = getUnitByIdOrNotFound(unitId);
        unitRepository.deleteById(unit.getId());
    }
}
