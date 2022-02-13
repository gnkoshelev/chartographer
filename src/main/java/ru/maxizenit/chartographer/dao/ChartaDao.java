package ru.maxizenit.chartographer.dao;

import ru.maxizenit.chartographer.dto.ChartaDto;
import ru.maxizenit.chartographer.exception.ChartaNotFoundException;

/**
 * DAO-интерфейс для класса Charta
 */
public interface ChartaDao {

    /**
     * Выполняет сохранение харты и обновление её id
     * @param chartaDto объект класса харты
     */
    void save(ChartaDto chartaDto);

    /**
     * Возвращает харту с заданным id
     * @param id идентификатор харты
     * @return объект класса харты
     * @throws ChartaNotFoundException если харты с данным id не найдено
     */
    ChartaDto getById(long id) throws ChartaNotFoundException;

    /**
     * Удаляет харту с заданным id
     * @param id идентификатор харты
     * @throws ChartaNotFoundException если харты с данным id не найдено
     */
    void deleteById(long id) throws ChartaNotFoundException;
}