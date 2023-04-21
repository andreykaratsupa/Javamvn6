package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldChangeStation() {
        assertEquals(0, radio.getCurrentRadioStation());
        radio.setCurrentRadioStation(5);
        assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetStationUnderMinStation() {
        radio.setCurrentRadioStation(-1);
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetStationOverMaxStation() {
        radio.setCurrentRadioStation(10);
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldNextStation() {
        radio.setCurrentRadioStation(6);
        radio.nextStation();
        assertEquals(7, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldOverMaxStation1() {
        radio.setCurrentRadioStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldOverMaxStation2() {
        radio.setCurrentRadioStation(10);
        radio.nextStation();
        assertEquals(1, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldPrevStation() {
        radio.setCurrentRadioStation(4);
        radio.prevStation();
        assertEquals(3, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldBelowMinStation1() {
        radio.setCurrentRadioStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldBelowMinStation2() {
        radio.setCurrentRadioStation(-1);
        radio.prevStation();
        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldChangeVolume() {
        assertEquals(0, radio.getCurrentVolume());
        radio.setCurrentVolume(5);
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldOverMaxVolume1() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldOverMaxVolume2() {
        radio.setCurrentVolume(101);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setCurrentVolume(6);
        radio.decreaseVolume();
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldBelowMinVolume1() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldBelowMinVolume2() {
        radio.setCurrentVolume(-1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

}