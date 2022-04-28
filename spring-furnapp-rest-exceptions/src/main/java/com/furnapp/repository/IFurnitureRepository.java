package com.furnapp.repository;


import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IFurnitureRepository  extends JpaRepository<Furniture, Integer> {


    Furniture findByFurnitureId(int furnitureId) ;

    //derived queries

    List<Furniture> findByBrand(String brand) ;
    List<Furniture>findByCategory(String category) ;
    List<Furniture>findByRoomType(String roomType) ;
    List<Furniture>findByMaterial(String material) ;
    List<Furniture>findByStyle(Style style) ;
    List<Furniture>findByStorageAvailable(boolean Storage);

    //custom query
    @Query("from Furniture f where f.price between ?1 and ?2")
    List<Furniture> findByPriceRange(double minPrice, double maxPrice);

    @Query("from Furniture f  where f.material=?1 and f.brand=?2")
    List<Furniture> findByMatAndBrand(String material, String brand);

    @Query("from Furniture f  where f.roomType=?1 and f.category=?2")
    List<Furniture> findByRoomAndCategory(String RoomType, String category);

    //native Query

    @Query(value ="select count(*) from furniture",nativeQuery=true)
    Integer findTotal();

    //named Query

    @Query(name="CostFromCategory")
    Integer findCategoryCost(String category);



}
