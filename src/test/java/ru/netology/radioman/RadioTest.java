package ru.netology.radioman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RadioTest {
    // позитивные проверки на текущую станцию, ее переключение
    @Test // проверяем текущую станцию
    public void TestCurrentStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(5);

        int expected = 5;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test // проверка минимального разрешенного значения номера радиостанции
    public void TestMinCurrentStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(0);

        int expected = 0;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test // проверка максимального разрешенного значения номера радиостанции
    public void TestMaxCurrentStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(9);

        int expected = 9;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test //проверка на переключение радиостанции вперед в рамках диапазона
    public void shouldNextStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(5);
        rad.nextStation();

        int expected = 6;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test //проверка на переключение радиостанции назад в рамках диапазона
    public void shouldPrevStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(9);
        rad.prevStation();

        int expected = 8;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test //проверка на переключение радиостанции вперед, если текущая радиостанция 9
    public void shouldMaxNextStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(9);
        rad.nextStation();

        int expected = 0;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test //проверка на переключение радиостанции назад, если текущая радиостанция 0
    public void shouldMinPrevStation() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(0);
        rad.prevStation();

        int expected = 9;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test //проверка текущей громкости
    public void TestVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(5);

        int expected = 5;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }
    //позитивные проверки на громкость, ее изменение
    @Test //проверка минимального разрешенного значения громкости
    public void TestMinVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(0);

        int expected = 0;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @Test //проверка максимального разрешенного значения громкости
    public void TestMaxVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(10);

        int expected = 10;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @Test // проверка на увеличение громкости в пределах диапазона
    public void TestIncreaseVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(2);
        vol.increaseVolume();

        int expected = 3;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @Test // проверка на уменьшение громкости в пределах диапазона
    public void TestDecreaseVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(2);
        vol.decreaseVolume();

        int expected = 1;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @Test // проверка на увеличение громкости при громкости на максимальном значении
    public void TestIncreaseVolumeInMax() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(10);
        vol.increaseVolume();

        int expected = 10;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }

    @Test // проверка на уменьшение громкости при громкости на минимальном значении
    public void TestDecreaseVolumeInMin() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(0);
        vol.decreaseVolume();

        int expected = 0;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }
    // негативные проверки на номера текущей радиостании, громкость
    @Test //(негатив) проверка на установление кнопки радиостанции выше диапазона
    public void shouldTestStationAboveMax() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(10);

        int expected = 0;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test //(негатив) проверка на установление кнопки радиостанции ниже диапазона
    public void shouldTestStationBeforeMin() {
        Radio rad = new Radio();
        rad.setNumberCurrentStation(-1);

        int expected = 0;
        int actual = rad.getNumberCurrentStation();

        Assertions.assertEquals(expected, actual);
    }
    @Test //(негатив) проверка на установление громкости выше диапазона
    public void TestAboveMaxVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(11);

        int expected = 0;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }
    @Test ////(негатив) проверка на установление громкости ниже диапазона
    public void TestBelowMinVolume() {
        Radio vol = new Radio();
        vol.setCurrentVolumeRadio(-1);

        int expected = 0;
        int actual = vol.getCurrentVolumeRadio();

        Assertions.assertEquals(expected, actual);
    }
}