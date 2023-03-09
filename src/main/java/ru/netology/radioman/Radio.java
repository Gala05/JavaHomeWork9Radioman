package ru.netology.radioman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {
    private int numberCurrentStation;
    private int currentVolumeRadio;
    private int maxNumberStation;

    public void setNumberCurrentStation(int newCurrentStation) { //метод для проверки коррекности номера радиостанции
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > maxNumberStation) {
            return;
        }
        numberCurrentStation = newCurrentStation;
    }

    public void setCurrentVolumeRadio(int newCurrentVolumeRadio) { //метод для проверки корректности громкости
        if (newCurrentVolumeRadio < 0) {
            return;
        }
        if (newCurrentVolumeRadio > 100) {
            return;
        }
        currentVolumeRadio = newCurrentVolumeRadio;
    }

    public void nextStation() { // переключение радиостанции вперед
        int target = numberCurrentStation + 1;
        if (target > maxNumberStation) {
            target = 0;
        } else {
            target = numberCurrentStation + 1;
        }
        setNumberCurrentStation(target);
    }

    public void prevStation() { // переключение радиостанции назад
        int target = numberCurrentStation - 1;
        if (target < 0) {
            target = maxNumberStation;
        } else {
            target = numberCurrentStation - 1;
        }
        setNumberCurrentStation(target);
    }

    public void increaseVolume() { //увеличение громкости
        if (currentVolumeRadio < 100) {
            currentVolumeRadio = currentVolumeRadio + 1;
        }
    }

    public void decreaseVolume() { //уменьшение громкости
        if (currentVolumeRadio > 0) {
            currentVolumeRadio = currentVolumeRadio - 1;
        }
    }
}