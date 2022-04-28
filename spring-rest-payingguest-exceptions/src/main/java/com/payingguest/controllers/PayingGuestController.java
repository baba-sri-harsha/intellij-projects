package com.payingguest.controllers;

import com.payingguest.model.PayingGuest;
import com.payingguest.service.IPayingGuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payingguest-api")
public class PayingGuestController {


    private IPayingGuestService iPayingGuestService;

    public PayingGuestController(IPayingGuestService iPayingGuestService) {
        this.iPayingGuestService = iPayingGuestService;
    }

    @PostMapping("/payingguests")
    public PayingGuest addPayingGuest(@RequestBody PayingGuest pg){
        return iPayingGuestService.addPayingGuest(pg);
    }

    @PutMapping("/payingguests")
    public PayingGuest updatePayingGuest(@RequestBody PayingGuest pg){
        return  iPayingGuestService.updatePayingGuest(pg);
    }

    @DeleteMapping("/payingguests/id/{id}")
    public void deletePayingGuest(@PathVariable("id") int id){
        iPayingGuestService.deletePayingGuest(id);
    }

    @GetMapping("/payingguests")
    public List<PayingGuest> showPayingGuests(){
        return iPayingGuestService.getAll();
    }

    @GetMapping("/payingguests/city/{city}")
    public  List<PayingGuest>showPayingGuestsByLocation(@PathVariable("city") String city){
        return iPayingGuestService.getByCity(city);
    }
//2
    @GetMapping("/payingguests/city/{city}/address/{address}")
    public  List<PayingGuest>showPayingGuestsByCityAndLocation(@PathVariable("city") String city,@PathVariable("address") String address){
        return iPayingGuestService.getByCityAndAddress(city,address);
    }

    @GetMapping("/payingguests/city/{city}/name/{name}")
    public  List<PayingGuest>showPayingGuestsByCityAndName(@PathVariable("city") String city,@PathVariable("name") String name){
        return iPayingGuestService.getByCityAndName(city,name);
    }

    @GetMapping("/payingguests/rating/{rating}")
    public  List<PayingGuest>showPayingGuestsByRating(@PathVariable("rating") int rating){
        return iPayingGuestService.getByRating(rating);
    }

    @GetMapping("/payingguests/city/{city}/rating/{rating}")
    public  List<PayingGuest>showPayingGuestsByCityAndRating(@PathVariable("city") String city,@PathVariable("rating") int rating){
        return iPayingGuestService.getByCityAndRating(city, rating);
    }

    @GetMapping("/payingguests/roomShare/{roomShare}")
    public  List<PayingGuest>showByRoomShare(@PathVariable("roomShare")String roomShare){
        return iPayingGuestService.getByRoomShare(roomShare);
    }

    @GetMapping("/payingguests/price/{price}/roomShare/{roomShare}")
    public  List<PayingGuest>showByPriceAndRoomShare(@PathVariable("price") double price,@PathVariable("roomShare")String roomShare){
        return iPayingGuestService.getByPriceAndRoomShare(price,roomShare);
    }


    @GetMapping("/payingguests/category/{category}")
    public  List<PayingGuest>showByCategory(@PathVariable("category")String category){
        return iPayingGuestService.getByCategory(category);
    }

    @GetMapping("/payingguests/price/{price}")
    public  List<PayingGuest>showByPriceLessThan(@PathVariable("price")double price){
        return iPayingGuestService.getByPriceLessThan(price);
    }


    @GetMapping("/payingguests/city/{city}/totalRooms/{totalRooms}")
    public  List<PayingGuest>showByCityAndTotalRooms(@PathVariable("city")String city,@PathVariable("totalRooms") int totalRooms){
        return iPayingGuestService.getByCityAndTotalRooms(city,totalRooms);
    }






}
