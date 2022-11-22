package com.example.infogame.controllers;

import com.example.infogame.dto.category.CategoryCreateDto;
import com.example.infogame.dto.category.CategoryUpdateDto;
import com.example.infogame.dto.unit.UnitCreateDto;
import com.example.infogame.dto.unit.UnitUpdateDto;
import com.example.infogame.service.UnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Units")
@Controller
@RequestMapping("/category/unit")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping()
    public String listUnits(Model model) {
        model.addAttribute("units", unitService.getUnits());
        return "unit/list";
    }

    @GetMapping("/new")
    public String newUnit(Model model) {
        model.addAttribute("unit", new UnitCreateDto());
        return "unit/new";
    }

    @PostMapping()
    public String createUnit(@ModelAttribute UnitCreateDto unitCreateDto) {
        unitService.createUnit(unitCreateDto);
        return "redirect:/category/unit";
    }

    @GetMapping("/{unitId}")
    public String getUnit(@PathVariable("unitId") int unitId, Model model) {
        model.addAttribute("unit", unitService.getUnitById(unitId));
        return "unit/profile";
    }

    @GetMapping("/{unitId}/edit")
    public String editUnit(@PathVariable("unitId") int unitId, Model model) {
        model.addAttribute("unit", unitService.getUnitById(unitId));
        return "unit/edit";
    }

    @PutMapping("/{unitId}")
    public String updateUnit(@PathVariable("unitId") int unitId, @ModelAttribute("unit") UnitUpdateDto unitUpdateDto) {
        unitService.updateUnit(unitId, unitUpdateDto);
        return "redirect:/category/unit/{unitId}";
    }

    @DeleteMapping("/{unitId}")
    public String deleteUnit(@PathVariable("unitId") int unitId) {
        unitService.deleteUnit(unitId);
        return "redirect:/category/unit";
    }
}
