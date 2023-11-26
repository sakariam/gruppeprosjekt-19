package org.example.Model;
public class BookingResult {
    private String bookingDetails;
    private boolean isConfirmed;

    public BookingResult(String bookingDetails, boolean isConfirmed) {
        this.bookingDetails = bookingDetails;
        this.isConfirmed = isConfirmed;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
}
