package ru.maxizenit.chartographer.dao.impl;

import org.springframework.stereotype.Service;
import ru.maxizenit.chartographer.dao.ChartaDao;
import ru.maxizenit.chartographer.dto.ChartaDto;
import ru.maxizenit.chartographer.exception.ChartaNotFoundException;

@Service
public class ChartaDaoImpl implements ChartaDao {

    @Override
    public void save(ChartaDto chartaDto) {
        //тут будем сохранять файл и присваивать айдишник
    }

    @Override
    public ChartaDto getById(long id) throws ChartaNotFoundException {
        ChartaDto result = null;

        //тут будем искать файл
        //если не нашли, то
        throw new ChartaNotFoundException("Charta with id " + id + " not found");
    }

    @Override
    public void deleteById(long id) throws ChartaNotFoundException {
        ChartaDto chartaDto = getById(id);
        //тут будем удалять харту
    }
}