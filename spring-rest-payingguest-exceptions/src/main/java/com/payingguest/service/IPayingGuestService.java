package com.payingguest.service;

import com.payingguest.exceptions.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPayingGuestService {

    PayingGuest addPayingGuest(PayingGuest pg) ;
    PayingGuest updatePayingGuest(PayingGuest pg) ;
    void deletePayingGuest(int id);
    PayingGuest getById(int id) throws PayingGuestNotFoundException;
    List<PayingGuest> getAll();

    List<PayingGuest>getByCity(String city) throws PayingGuestNotFoundException;
    List<PayingGuest>getByCityAndAddress(String city ,String address) throws PayingGuestNotFoundException;
    List<PayingGuest>getByCityAndName(String city, String Name) throws PayingGuestNotFoundException;
    List<PayingGuest>getByRating(int rating) throws PayingGuestNotFoundException;
    List<PayingGuest>getByCityAndRating(String city,int rating) throws PayingGuestNotFoundException;
    List<PayingGuest>getByRoomShare(String roomShare) throws PayingGuestNotFoundException;
    List<PayingGuest>getByPriceAndRoomShare(double price , String sharing) throws PayingGuestNotFoundException;
    List<PayingGuest>getByCategory(String category) throws PayingGuestNotFoundException;


    List<PayingGuest>getByPriceLessThan(double price) throws PayingGuestNotFoundException ;

    List<PayingGuest>getByCityAndTotalRooms(String city,int roomsRequired) throws PayingGuestNotFoundException;


}
