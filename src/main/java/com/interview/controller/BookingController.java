package com.interview.controller;

import com.interview.model.Booking;
import com.interview.service.BookingService;
import com.interview.util.JsonUtil;
import io.muserver.Method;
import io.muserver.MuServerBuilder;

import java.time.LocalDate;
import java.util.List;

public class BookingController {
    private final BookingService bookingService = new BookingService();

    public void registerRoutes(MuServerBuilder builder) {
        builder.addHandler(Method.POST, "/bookings", (request, response, pathParams) -> {
            try {
                Booking booking = JsonUtil.fromJson(request.readBodyAsString(), Booking.class);
                String error = booking.getValidationError();
                if (error == null) {
                    bookingService.addBooking(booking);
                    response.status(201);
                    response.write("Booking confirmed.");
                } else {
                    response.status(400);
                    response.write(error);
                }

            } catch (Exception e) {
                response.status(400);
                response.write("Error parsing JSON: " + e.getMessage());
            }
        });

        builder.addHandler(Method.GET, "/bookings", (request, response, pathParams) -> {
            String dateParam = request.query().get("date");
            if (dateParam == null) {
                response.status(400);
                response.write("Missing 'date' query parameter (expected format: yyyy-MM-dd).");
                return;
            }

            try {
                LocalDate date = LocalDate.parse(dateParam);
                List<Booking> result = bookingService.getBookingsByDate(date);

                response.status(200);
                response.contentType("application/json");
                response.write(JsonUtil.toJson(result));
            } catch (Exception e) {
                response.status(400);
                response.write("Invalid date format: " + e.getMessage());
            }
        });
    }
}
