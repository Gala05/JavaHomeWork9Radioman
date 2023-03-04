package ru.netology.radioman;

public class Radio {
    private int numberCurrentStation; // номер текущей радиостанции
    private int currentVolumeRadio; // текущая громкость радиостанции

    public int getNumberCurrentStation() { //метод для получения номера текущей радиостанции
        return numberCurrentStation;
    }

    public void setNumberCurrentStation(int newCurrentStation) { //метод для проверки коррекности номера радиостанции
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > 9) {
            return;
        }
        numberCurrentStation = newCurrentStation;
    }

    public void nextStation() { // переключение радиостанции вперед
        int target = numberCurrentStation + 1;
        if (target > 9) {
            numberCurrentStation = 0;
        } else {
            target = numberCurrentStation + 1;
        }
        setNumberCurrentStation(target);
    }

    public void prevStation() { // переключение радиостанции назад
        int target = numberCurrentStation - 1;
        if (target < 0) {
            numberCurrentStation = 9;
        } else {
            target = numberCurrentStation - 1;
        }
        setNumberCurrentStation(target);
    }

    public int getCurrentVolumeRadio() { //метод для получения текущей громкости радиостанции
        return currentVolumeRadio;
    }

    public void setCurrentVolumeRadio(int newCurrentVolumeRadio) { //метод для проверки корректности громкости
        if (newCurrentVolumeRadio < 0) {
            return;
        }
        if (newCurrentVolumeRadio > 10) {
            return;
        }
        currentVolumeRadio = newCurrentVolumeRadio;
    }

    public void increaseVolume() { //увеличение громкости
        if (currentVolumeRadio < 10) {
            currentVolumeRadio = currentVolumeRadio + 1;
        }
    }

    public void decreaseVolume() { //уменьшение громкости
        if (currentVolumeRadio > 0) {
            currentVolumeRadio = currentVolumeRadio - 1;
        }
    }
}