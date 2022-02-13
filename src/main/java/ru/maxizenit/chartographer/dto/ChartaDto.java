package ru.maxizenit.chartographer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Класс харты
 */
@Getter
@Setter
@AllArgsConstructor
public class ChartaDto {

    /** Минимальный размер стороны */
    public static final int MIN_SIDE_SIZE = 1;

    /** Максимальная ширина */
    public static final int MAX_WIDTH = 20_000;

    /** Максимальная высота */
    public static final int MAX_HEIGHT = 50_000;

    /** Идентификатор */
    private Long id;

    /** Ширина */
    private Integer width;

    /** Высота */
    private Integer height;

    /** Сегменты */
    private List<ChartaSegmentDto> segments;
}