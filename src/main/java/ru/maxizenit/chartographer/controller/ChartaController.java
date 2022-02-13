package ru.maxizenit.chartographer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.maxizenit.chartographer.dto.ChartaDto;
import ru.maxizenit.chartographer.exception.ChartaNotFoundException;
import ru.maxizenit.chartographer.service.ChartaService;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Validated
@RestController
@RequestMapping("/chartas")
public class ChartaController {

    private final ChartaService chartaService;

    @Autowired
    public ChartaController(ChartaService chartaService) {
        this.chartaService = chartaService;
    }

    @PostMapping
    public ResponseEntity<String> createNewCharta(
            @RequestParam("width") @Min(ChartaDto.MIN_SIDE_SIZE) @Max(ChartaDto.MAX_WIDTH) int width,
            @RequestParam("height") @Min(ChartaDto.MIN_SIDE_SIZE) @Max(ChartaDto.MAX_HEIGHT) int height) {
        try {
            Long id = chartaService.create(width, height);

            return new ResponseEntity<>(id.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> saveChartaPart(
            @PathVariable("id") long id,
            @RequestParam("x") @Min(0) int x,
            @RequestParam("y") @Min(0) int y,
            @RequestParam("width") int width,
            @RequestParam("height") int height,
            @NotNull @RequestBody Image image) {
        try {
            chartaService.saveChartaPart(id, x, y, width, height, image);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ChartaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getChartaPart(
            @PathVariable("id") long id,
            @RequestParam("x") @Min(0) int x,
            @RequestParam("y") @Min(0) int y,
            @RequestParam("width") int width,
            @RequestParam("height") int height) {
        try {
            Image image = chartaService.getChartaPart(id, x, y, width, height);
            return new ResponseEntity<>(image, HttpStatus.OK);
        } catch (ChartaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharta(@PathVariable long id) {
        try {
            chartaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ChartaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}