package com.payingguest.service;

import com.payingguest.exceptions.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;
import com.payingguest.repository.IPayingGuestRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayingGuestServiceImpl implements IPayingGuestService {


    IPayingGuestRepository pgRepository;

    public PayingGuestServiceImpl(IPayingGuestRepository pgRepository) {
        this.pgRepository = pgRepository;
    }

    @Override
    public PayingGuest addPayingGuest(PayingGuest pg) {
        return pgRepository.save(pg);
    }

    @Override
    public PayingGuest updatePayingGuest(PayingGuest pg) {
        return pgRepository.save(pg);

    }

    @Override
    public void deletePayingGuest(int id) {
        pgRepository.deleteById(id);
    }


    @Override
    public PayingGuest getById(int id) throws PayingGuestNotFoundException {
        PayingGuest pg= pgRepository.findById(id);
        if (pg==null)
            throw new PayingGuestNotFoundException("pg not found");
        return  pg;
    }

    @Override
    public List<PayingGuest> getAll() {
        List<PayingGuest> payingGuestList= pgRepository.findAll();
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCity(String city) {
        List<PayingGuest> payingGuestList= pgRepository.findByCityStartingWith(city);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCityAndAddress(String city, String address) {
        List<PayingGuest> payingGuestList=pgRepository.findByCityAndAddress(city,address);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCityAndName(String city, String name) {

        List<PayingGuest> payingGuestList=pgRepository.findByCityAndName(city,name);

        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;

    }

    @Override
    public List<PayingGuest> getByRating(int rating) {

        List<PayingGuest>payingGuestList=pgRepository.findByRating(rating);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;

    }

    @Override
    public List<PayingGuest> getByCityAndRating(String city, int rating) {
        List<PayingGuest>  payingGuestList=pgRepository.findByCityAndRating(city,rating);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;
    }

    @Override
    public List<PayingGuest> getByRoomShare(String roomShare) {
        List<PayingGuest>  payingGuestList= pgRepository.findByRoomShare(roomShare);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return  payingGuestList;
    }

    @Override
    public List<PayingGuest> getByPriceAndRoomShare(double price, String sharing) {
        List<PayingGuest>payingGuestList=pgRepository.findByPriceAndRoomShare(price,sharing);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByCategory(String category) {
        List<PayingGuest>payingGuestList=pgRepository.findByCategory(category);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return payingGuestList;
    }

    @Override
    public List<PayingGuest> getByPriceLessThan(double price) {
        List<PayingGuest>payingGuestList= pgRepository.findByPriceLessThan(price);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return payingGuestList.stream().sorted(Comparator.comparing(PayingGuest::getPrice)).collect(Collectors.toList());
    }

    @Override
    public List<PayingGuest> getByCityAndTotalRooms(String city, int roomsRequired) {
        List<PayingGuest>payingGuestList= pgRepository.findByCityAndTotalRooms(city,roomsRequired);
        if (payingGuestList.isEmpty())
            throw new PayingGuestNotFoundException("pg not found");
        return payingGuestList;
    }
}
