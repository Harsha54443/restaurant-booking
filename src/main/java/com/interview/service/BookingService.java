package com.interview.service;

import com.interview.model.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class BookingService {
    private final List<Booking> bookings = new CopyOnWriteArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingsByDate(LocalDate date) {
        return bookings.stream()
                .filter(b -> b.getDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }
}
