package ru.maxizenit.chartographer.exception;

/**
 * Класс исключения при ошибке нахождения харты
 */
public class ChartaNotFoundException extends Exception {

    public ChartaNotFoundException(String message) {
        super(message);
    }
}
