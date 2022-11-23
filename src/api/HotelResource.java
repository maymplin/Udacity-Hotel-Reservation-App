package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    // TODO create HotelResource constructor


    public HotelResource() {
    }

    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room,
                                 Date CheckInDate, Date CheckOutDate) {
        return ReservationService.reserveARoom(getCustomer(customerEmail), room, CheckInDate, CheckInDate);
    }

    public Collection<Reservation> getCustomersReservations (String customerEmail) {
        return ReservationService.getCustomerReservation(getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return ReservationService.findRooms(checkIn, checkOut);
    }
}
