package com.payingguest.repository;

import com.payingguest.model.PayingGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPayingGuestRepository  extends JpaRepository<PayingGuest,Integer> {

    PayingGuest findById(int id);
    List<PayingGuest>findByCity(String city);
    List<PayingGuest>findByCityAndAddress(String city ,String address);
    List<PayingGuest>findByCityAndName(String city, String Name);
    List<PayingGuest>findByRating(int rating);
    List<PayingGuest>findByCityAndRating(String city,int rate  );
    List<PayingGuest>findByRoomShare(String roomShare);
    //@Query("from PayingGuest pg where pg.price<=?1 and pg.share=?2")
    List<PayingGuest>findByPriceAndRoomShare(double price , String sharing);
    List<PayingGuest>findByCategory(String category);
    List<PayingGuest>findByPriceLessThan(double price);
    List<PayingGuest>findByCityAndTotalRooms(String city,int roomsRequired);

}
