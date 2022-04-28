package com.furnapp.controller;

import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("furniture-api")
public class FurnitureController {

    private IFurnitureService furnitureService;

    @Autowired
    public void setFurnitureService(IFurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("furnitures")
    public ResponseEntity<Void> addFurniture(@RequestBody Furniture furniture){
        furnitureService.addFurniture(furniture);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return  responseEntity;
    }

    @PutMapping("furnitures")
    public ResponseEntity<Void> updateFurniture(@RequestBody Furniture furniture){
        furnitureService.updateFurniture(furniture);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return  responseEntity;
    }

    @DeleteMapping("furnitures/furnitureId/{furnitureId}")
    public  ResponseEntity<Void> deleteFurniture(@PathVariable("furnitureId") int furnitureId){
        furnitureService.deleteFurniture(furnitureId);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","deleteing one furniture by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    @GetMapping("furnitures/furnitureId/{furnitureId}")
    public ResponseEntity<Furniture> getById(@PathVariable("furnitureId") int furnitureId){
        Furniture furniture=furnitureService.getById(furnitureId);
        return (ResponseEntity<Furniture>) ResponseEntity.status(HttpStatus.OK).body(furniture);
    }

    @GetMapping("/furnitures")
    ResponseEntity<List<Furniture>> getAll(){
        List<Furniture> furnitures = furnitureService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/brand/{brand}")
    ResponseEntity<List<Furniture>> getByBrand(@PathVariable("nbrand") String nbrand){
        List<Furniture> furnitures = furnitureService.getByBrand(nbrand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures by brand");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/category/{category}")
    ResponseEntity<List<Furniture>> getByCategory(@PathVariable("category") String category){
        List<Furniture> furnitures = furnitureService.getByCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures by category");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/roomType/{roomType}")
    ResponseEntity<List<Furniture>> getByRoomType(@PathVariable("roomType") String roomType){
        List<Furniture> furnitures = furnitureService.getByRoomType(roomType);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures by roomType");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/style/{style}")
    ResponseEntity<List<Furniture>> getByStyle(@PathVariable("style") Style style){
        List<Furniture> furnitures = furnitureService.getByStyle(style);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures by roomType");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/material")
    ResponseEntity<List<Furniture>> getByMaterial(@RequestParam("material") String material){
        List<Furniture> furnitures = furnitureService.getByMaterial(material);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures by material");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }


    @GetMapping("/furnitures/storage/{storage}")
    ResponseEntity<List<Furniture>> getByStorageAvailable(@PathVariable("storage") boolean storage){
        List<Furniture> furnitures = furnitureService.getByStorageAvailable(storage);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all furnitures by getByStorageAvailable");
        headers.add("info","get all Method called");
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures,headers, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/minprice/{minprice}/maxprice/{maxprice}")
    ResponseEntity<List<Furniture>> getByPriceRange(@PathVariable("minprice") double minprice,@PathVariable("maxprice") double maxprice){
        List<Furniture> furnitures = furnitureService.getByPriceRange(minprice, maxprice);
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/material/{material}/brand/{brand}")
    ResponseEntity<List<Furniture>> getByMatAndBrand(@PathVariable("material") String material,@PathVariable("brand") String brand){
        List<Furniture> furnitures = furnitureService.getByMatAndBrand(material,brand);
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/roomtype/{roomtype}/category/{category}")
    ResponseEntity<List<Furniture>> getByRoomAndCategory(@PathVariable("roomtype") String roomtype,@PathVariable("category") String category){
        List<Furniture> furnitures = furnitureService.getByRoomAndCategory(roomtype, category);
        ResponseEntity<List<Furniture>> furnitureResponse = new ResponseEntity<>(furnitures, HttpStatus.OK);
        return furnitureResponse;
    }

    @GetMapping("/furnitures/total")
    ResponseEntity<Integer> getTotal(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by category");
        return ResponseEntity.ok().headers(headers).body(furnitureService.getTotal());

    }

    @GetMapping("/furnitures/categorycost/{category}")
    ResponseEntity<Integer> getCategoryCost(@PathVariable("category") String category){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","furniture by CategoryCost");
        return ResponseEntity.ok().headers(headers).body(furnitureService.getCategoryCost(category));

    }








}
