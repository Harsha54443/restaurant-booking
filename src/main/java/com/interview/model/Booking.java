package com.interview.model;

import java.time.LocalDateTime;

public class Booking {
    private String customerName;
    private int tableSize;
    private LocalDateTime dateTime;

    public Booking() {}

    public Booking(String customerName, int tableSize, LocalDateTime dateTime) {
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.dateTime = dateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTableSize() {
        return tableSize;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isValid() {
        return getValidationError() == null;
    }

    public String getValidationError() {
        if (customerName == null || customerName.isBlank()) {
            return "Customer name is required.";
        }
        if (tableSize <= 0) {
            return "Table size must be greater than 0.";
        }
        if (dateTime == null) {
            return "Invalid or missing booking date/time.";
        }
        return null;
    }
}
