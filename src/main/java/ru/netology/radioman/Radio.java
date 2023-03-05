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