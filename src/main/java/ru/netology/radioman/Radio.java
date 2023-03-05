package ru.netology.radioman;

public class Radio {
    private int minNumberStation = 0;
    private int maxNumberStation = 9;
    private int numberCurrentStation = minNumberStation;
    private int minVolumeRadio = 0;
    private int maxVolumeRadio = 100;
    private int currentVolumeRadio = minVolumeRadio;

    public Radio(int count) { //желаемое количество радиостанций
        maxNumberStation = minNumberStation + count - 1;
    }

    public Radio() {
    }

    public int getMinNumberStation() {
        return minNumberStation;
    }

    public int getMaxNumberStation() {
        return maxNumberStation;
    }

    public int getNumberCurrentStation() {
        return numberCurrentStation;
    }

    public int getCurrentVolumeRadio() {
        return currentVolumeRadio;
    }

    public void setNumberCurrentStation(int newCurrentStation) { //метод для проверки коррекности номера радиостанции
        if (newCurrentStation < minNumberStation) {
            return;
        }
        if (newCurrentStation > maxNumberStation) {
            return;
        }
        numberCurrentStation = newCurrentStation;
    }

    public void setCurrentVolumeRadio(int newCurrentVolumeRadio) { //метод для проверки корректности громкости
        if (newCurrentVolumeRadio < minVolumeRadio) {
            return;
        }
        if (newCurrentVolumeRadio > maxVolumeRadio) {
            return;
        }
        currentVolumeRadio = newCurrentVolumeRadio;
    }

    public void nextStation() { // переключение радиостанции вперед
        if (numberCurrentStation != maxNumberStation) {
            numberCurrentStation++;
        } else {
            numberCurrentStation = minNumberStation;
        }
    }

    public void prevStation() { // переключение радиостанции назад
        if (numberCurrentStation != minNumberStation) {
            numberCurrentStation--;
        } else {
            numberCurrentStation = maxNumberStation;
        }
    }

    public void increaseVolume() { //увеличение громкости
        if (currentVolumeRadio < maxVolumeRadio) {
            currentVolumeRadio = currentVolumeRadio + 1;
        }
    }

    public void decreaseVolume() { //уменьшение громкости
        if (currentVolumeRadio > minVolumeRadio) {
            currentVolumeRadio = currentVolumeRadio - 1;
        }
    }
}