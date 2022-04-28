package com.furnapp.service;


import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFurnitureService {

    void addFurniture(Furniture furniture);
    void updateFurniture(Furniture furniture);
    void deleteFurniture(int furnitureId);
    Furniture getById(int furnitureId) throws FurnitureNotFoundException;
    List<Furniture> getAll() throws FurnitureNotFoundException;;
 

    //derived queries

    List<Furniture> getByBrand(String brand) throws FurnitureNotFoundException ;
    List<Furniture>getByCategory(String category) throws FurnitureNotFoundException;
    List<Furniture>getByRoomType(String roomType) throws FurnitureNotFoundException;
    List<Furniture>getByMaterial(String material) throws FurnitureNotFoundException;

    List<Furniture> getByStyle(Style style) throws FurnitureNotFoundException;

    List<Furniture>getByStorageAvailable(boolean Storage);

    //custom query
      List<Furniture> getByPriceRange(double minPrice, double maxPrice);
      List<Furniture> getByMatAndBrand(String material, String brand);
      List<Furniture> getByRoomAndCategory(String RoomType, String category);

//    native Query
      Integer getTotal();

//  named Query
    Integer getCategoryCost(String category);


}
