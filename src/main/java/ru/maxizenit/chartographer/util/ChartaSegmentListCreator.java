package ru.maxizenit.chartographer.util;

import ru.maxizenit.chartographer.dto.ChartaSegmentDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс формирования списка сегментов харты
 */
public class ChartaSegmentListCreator {

    /**
     * Возвращает список сегментов харты, в сумме элементов дающий целую харту
     * @param width ширина харты
     * @param height высота харты
     * @return список сегментов
     */
    public static List<ChartaSegmentDto> create(int width, int height) {
        ArrayList<ChartaSegmentDto> result = new ArrayList<ChartaSegmentDto>();

        int countByWidth = getSegmentCountBySide(width);
        int countByHeight = getSegmentCountBySide(height);

        int widthLeft = width;
        int heightLeft = height;

        int currentWidth;
        int currentHeight;

        int currentX = 0;
        int currentY = 0;

        long currentId = 0;

        for (int i = 0; i < countByHeight; ++i) {
            currentHeight = Math.min(heightLeft, ChartaSegmentDto.MAX_SIDE_SIZE);
            heightLeft -= currentHeight;

            for (int j = 0; j < countByWidth; ++j) {
                currentWidth = Math.min(widthLeft, ChartaSegmentDto.MAX_SIDE_SIZE);
                widthLeft -= currentWidth;

                ChartaSegmentDto chartaSegmentDto = new ChartaSegmentDto(
                        currentId++, currentX, currentY, currentWidth, currentHeight, null);

                result.add(chartaSegmentDto);

                currentX += currentWidth;
            }

            currentY += currentHeight;
        }

        return result;
    }

    /**
     * Возвращает количество сегментов на одной из сторон харты
     * @param side размер стороны
     * @return количество сегментов по стороне
     */
    private static int getSegmentCountBySide(int side) {
        int count = side / ChartaSegmentDto.MAX_SIDE_SIZE;

        if (side % ChartaSegmentDto.MAX_SIDE_SIZE != 0) {
            ++count;
        }

        return count;
    }
}
