package ru.netology.statistic;

public class Radio {
    private int currentRadioStation;
    private int minStation = 0;
    private int maxStation = 9;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < minStation || currentRadioStation > maxStation) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }
    public void nextStation() {
        if (maxStation <= currentRadioStation) {
            setCurrentRadioStation(minStation);
        } else {
            setCurrentRadioStation(currentRadioStation + 1);
        }
    }
    public void prevStation() {
        if (currentRadioStation <= minStation) {
            setCurrentRadioStation(maxStation);
        } else {
            setCurrentRadioStation(currentRadioStation - 1);
        }
    }
    public int getCurrentVolume() {
        return currentVolume;
    }
    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume || currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }
    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public void prevRadioStation() {
    }
}
