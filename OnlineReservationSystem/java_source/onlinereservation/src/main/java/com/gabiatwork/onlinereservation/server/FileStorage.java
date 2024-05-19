package com.gabiatwork.onlinereservation.server;

import java.util.ArrayList;
import java.util.List;

public class FileStorage {

    private static final String EVENTS_FILE = "events.json";
    private static final String RESERVATIONS_FILE = "reservations.json";

    public List<String> readEvents() {
        // Logic to read events from EVENTS_FILE
        return new ArrayList<>();
    }

    public void writeReservation(String reservation) {
        // Logic to write reservation to RESERVATIONS_FILE
    }
}
