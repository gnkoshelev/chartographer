package ru.maxizenit.chartographer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxizenit.chartographer.dao.ChartaDao;
import ru.maxizenit.chartographer.dto.ChartaDto;
import ru.maxizenit.chartographer.exception.ChartaNotFoundException;
import ru.maxizenit.chartographer.service.ChartaService;
import ru.maxizenit.chartographer.util.ChartaSegmentListCreator;

import java.awt.*;

@Service
public class ChartaServiceImpl implements ChartaService {

    private final ChartaDao chartaDao;

    @Autowired
    public ChartaServiceImpl(ChartaDao chartaDao) {
        this.chartaDao = chartaDao;
    }

    @Override
    public ChartaDto getById(long id) throws ChartaNotFoundException {
        return chartaDao.getById(id);
    }

    @Override
    public void deleteById(long id) throws ChartaNotFoundException {
        chartaDao.deleteById(id);
    }

    @Override
    public Long create(int width, int height) {
        ChartaDto chartaDto =
                new ChartaDto(null, width, height, ChartaSegmentListCreator.create(width, height));

        return chartaDto.getId();
    }

    @Override
    public void saveChartaPart(long id, int x, int y, int width, int heigth, Image image) throws ChartaNotFoundException {
        ChartaDto chartaDto = getById(id);
    }

    @Override
    public Image getChartaPart(long id, int x, int y, int width, int height) throws ChartaNotFoundException {
        ChartaDto chartaDto;

        try {
            chartaDto = getById(id);
        } catch (ChartaNotFoundException e) {
            return null;
        }

        if (x >= chartaDto.getWidth() || y >= chartaDto.getHeight()) {
            return null;
        }

        if ((x + width) > chartaDto.getWidth() || (y + height) > chartaDto.getHeight()) {
            return null;
        }

        //здесь добавить получение изображения

        return null;
    }
}
