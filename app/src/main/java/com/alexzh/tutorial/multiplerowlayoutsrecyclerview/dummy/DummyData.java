package com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy;

import com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent;

import java.util.ArrayList;
import java.util.List;

public final class DummyData {

    public static List<CityEvent> getData() {
        List<CityEvent> list = new ArrayList<>();

        list.add(new CityEvent("Redoy Ahmed", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Hafizur Rahman", "Hi this is test", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Kowser Ahmed", "Hello test", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Mr Manik", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Abul Kalam", "This is also test", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Arif Ahmed", "Hello also test", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Ws Ayan", "Hello also test 2", CityEvent.EVENT_TYPE));
        return list;
    }

}
