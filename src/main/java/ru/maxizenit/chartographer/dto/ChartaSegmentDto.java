package ru.maxizenit.chartographer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс сегмента харты
 */
@Getter
@Setter
@AllArgsConstructor
public class ChartaSegmentDto {

    /** Максимальный размер стороны */
    public static final int MAX_SIDE_SIZE = 5_000;

    /** Идентификатор */
    private long id;

    /** Координата по оси X */
    private int x;

    /** Координата по оси Y */
    private int y;

    /** Ширина */
    private int width;

    /** Высота */
    private int height;

    /** Название файла с изображением */
    private String imageName;
}