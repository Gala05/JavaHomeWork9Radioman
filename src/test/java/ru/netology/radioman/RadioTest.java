package ru.netology.radioman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    @Test
    public void test() { //тест конструктора на желаемое количество радиостанций
        Radio rad = new Radio(20, 30, 50);

        Assertions.assertEquals(20, rad.getNumberCurrentStation());
        Assertions.assertEquals(30, rad.getCurrentVolumeRadio());
        Assertions.assertEquals(50, rad.getMaxNumberStation());
    }

    @ParameterizedTest // проверка на текущую станцию,
    @CsvSource({
            "0, 0",
            "1, 1",
            "8, 8",
            "9, 9",
            "9, 9"
    })
    public void TestCurrentStationAll(int expected, int i) {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(i);

        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // проверки на переключение радиостанции вперед
    @CsvSource({
            "1, 0",
            "2, 1",
            "8, 7",
            "9, 8",
            "0, 9"
    })
    public void shouldNextStationAll(int expected, int i) {
        Radio rad = new Radio(0, 0, 9);

        rad.setNumberCurrentStation(i);
        rad.nextStation();

        int actual = rad.getNumberCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // проверки на переключение радиостанции назад
    @CsvSource({
            "9, 0",
            "0, 1",
            "7, 8",
            "8, 9"
    })
    public void shouldPrevStationAll(int expected, int i) {
        Radio rad = new Radio(0, 0, 9);

        rad.setNumberCurrentStation(i);
        rad.prevStation();

        int actual = rad.getNumberCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest //проверки текущей громкости
    @CsvSource({
            "0, 0",
            "1, 1",
            "99, 99",
            "100, 100",
    })
    public void TestVolumeAll(int expected, int i) {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(i);

        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // проверки на увеличение громкости
    @CsvSource({
            "1, 0",
            "2, 1",
            "99, 98",
            "100, 99",
            "100, 100"
    })
    public void TestIncreaseVolumeAll(int expected, int i) {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(i);
        vol.increaseVolume();

        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // проверки на уменьшение громкости
    @CsvSource({
            "0, 0",
            "0, 1",
            "1, 2",
            "98, 99",
            "99, 100"
    })
    public void TestDecreaseVolumeAll(int expected, int i) {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(i);
        vol.decreaseVolume();

        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }
}