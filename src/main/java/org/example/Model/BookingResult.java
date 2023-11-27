package org.example.Model;

import java.util.ArrayList;

public class BookingResult {
    private String bookingDetails;
    private boolean isConfirmed;
    private ArrayList<String> bookinginfo;

    public BookingResult(String bookingDetails, boolean isConfirmed) {
        this.bookingDetails = bookingDetails;
        this.isConfirmed = isConfirmed;
        this.bookinginfo = bookinginfo;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setBookingDetails(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public ArrayList<String> getBookinginfo() {
        return bookinginfo;
    }

    public void setBookinginfo(ArrayList<String> bookinginfo) {
        this.bookinginfo = bookinginfo;
    }
}
