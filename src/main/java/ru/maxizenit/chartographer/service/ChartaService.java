package ru.maxizenit.chartographer.service;

import ru.maxizenit.chartographer.dto.ChartaDto;
import ru.maxizenit.chartographer.exception.ChartaNotFoundException;

import java.awt.*;

/**
 * Сервис для класса харты
 */
public interface ChartaService {

    /**
     * Возвращает харту с заданным id
     * @param id идентификатор харты
     * @return объект класса харты
     * @throws ChartaNotFoundException если харты с заданным id не найдено
     */
    ChartaDto getById(long id) throws ChartaNotFoundException;

    /**
     * Удаляет харту с заданным id
     * @param id идентификатор харты
     * @throws ChartaNotFoundException если харты с заданным id не найдено
     */
    void deleteById(long id) throws ChartaNotFoundException;

    /**
     * Создаёт и сохраняет харту с заданными сторонами, возвращая id новой харты
     * @param width ширина харты
     * @param height высота харты
     * @return id сохранённой харты
     */
    Long create(int width, int height);

    /**
     * Сохраняет в харте с заданным id изображение по заданным координатам
     * @param id индентификатор харты
     * @param x координата X изображения
     * @param y координата Y изображения
     * @param width ширина изображения
     * @param heigth высота изображения
     * @param image изображение
     * @throws ChartaNotFoundException если харты с заданным id не найдено
     */
    void saveChartaPart(long id, int x, int y, int width, int heigth, Image image) throws ChartaNotFoundException;

    /**
     * Возвращает часть харты в виде изображения
     * @param id идентификатор харты
     * @param x координата X изображения
     * @param y координата Y изображения
     * @param width ширина изображения
     * @param height высота изображения
     * @return фрагмент харты в виде изображения
     * @throws ChartaNotFoundException если харты с заданным id не найдено
     */
    Image getChartaPart(long id, int x, int y, int width, int height) throws ChartaNotFoundException;
}
