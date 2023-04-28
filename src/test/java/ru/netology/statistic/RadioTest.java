package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio fm = new Radio();

    //тестируем станции
    @Test
    public void shouldGetCurrentStation() {
        fm.setCurrentStation(0);
        fm.setCurrentStation(-1);
        fm.setCurrentStation(11);
        assertEquals(0, fm.getCurrentStation());
    }

    @Test
    public void shouldPressNextStation() {
        fm.setCurrentStation(0);
        fm.pressNextStation();
        assertEquals(1, fm.getCurrentStation());

        fm.setCurrentStation(10);
        fm.pressNextStation();
        assertEquals(0, fm.getCurrentStation());
    }

    @Test
    public void shouldPressPrevStation() {
        fm.setCurrentStation(0);
        fm.pressPrevStation();
        assertEquals(10, fm.getCurrentStation());

        fm.setCurrentStation(10);
        fm.pressPrevStation();
        assertEquals(9, fm.getCurrentStation());
    }

    @Test
    public void shouldGetToMaxStation() {
        assertEquals(10, fm.getMaxRadioStation());
    }

    @Test
    public void shouldSetMaxStation() {
        fm.setMaxRadioStation(-1);
        fm.setMaxRadioStation(0);
        fm.setMaxRadioStation(11);
        assertEquals(11, fm.getMaxRadioStation());
    }

    @Test
    public void shouldGetToMinStation() {
        assertEquals(0, fm.getMinRadioStation());
    }

    @Test
    public void shouldSetMinStation() {
        fm.setMinRadioStation(-1);
        fm.setMinRadioStation(0);
        fm.setMinRadioStation(11);
        assertEquals(11, fm.getMinRadioStation());
    }

    //тестируем громкость
    @Test
    public void shouldSetCurrentVolume() {
        fm.setCurrentVolume(101);
        assertEquals(0, fm.getCurrentVolume());

        fm.setCurrentVolume(-1);
        assertEquals(100, fm.getCurrentVolume());

        fm.setCurrentVolume(50);
        assertEquals(50, fm.getCurrentVolume());
    }

    @Test
    public void shouldGetMinVolume() {
        assertEquals(0, fm.getMinVolume());
    }

    @Test
    public void shouldGetMaxVolume() {
        assertEquals(100, fm.getMaxVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        fm.setMaxVolume(100);
        fm.setMinVolume(1);
        assertEquals(1, fm.getMinVolume());
    }

    @Test
    public void shouldSetMaxVolume() {
        fm.setMinVolume(1);
        fm.setMaxVolume(101);
        assertEquals(101, fm.getMaxVolume());
    }

    @Test
    public void shouldPressVolumeUp() {
        fm.setCurrentVolume(4);
        fm.pressVolumeUp();
        assertEquals(5, fm.getCurrentVolume());

        fm.setCurrentVolume(100);
        fm.pressVolumeUp();
        assertEquals(0, fm.getCurrentVolume());
    }

    @Test
    public void shouldPressVolumeDown() {
        fm.setCurrentVolume(4);
        fm.pressVolumeDown();
        assertEquals(3, fm.getCurrentVolume());

        fm.setCurrentVolume(0);
        fm.pressVolumeDown();
        assertEquals(100, fm.getCurrentVolume());
    }

    //задаем количество станций при создании объекта
    @Test
    public void shouldCreateStationsWithLimits() {
        Radio radio = new Radio(1);
        assertEquals(0, radio.getMaxRadioStation());

        Radio radio1 = new Radio(30);
        assertEquals(29, radio1.getMaxRadioStation());

        Radio radio2 = new Radio(10);
        assertEquals(0, radio2.getMinRadioStation());
    }
}