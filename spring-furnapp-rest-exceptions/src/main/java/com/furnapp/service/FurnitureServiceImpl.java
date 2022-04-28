package com.furnapp.service;


import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FurnitureServiceImpl implements IFurnitureService {

    private IFurnitureRepository furnitureRepository;

    @Autowired
    public void setFurnitureRepository(IFurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }


    @Override
    public void addFurniture(Furniture furniture) {
         furnitureRepository.save(furniture);

    }

    @Override
    public void updateFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        furnitureRepository.deleteById(furnitureId);
    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
        Furniture furniture= furnitureRepository.findByFurnitureId(furnitureId);
        if(furniture==null)
            throw new FurnitureNotFoundException();
        return furniture;

    }

    @Override
    public List<Furniture> getAll() throws FurnitureNotFoundException {
        List<Furniture>  furnitureList= furnitureRepository.findAll();
        if(furnitureList.isEmpty())
            throw  new FurnitureNotFoundException();
        return furnitureList;
    }

    @Override
    public List<Furniture> getByBrand(String brand) throws FurnitureNotFoundException {
         List<Furniture> furniture= furnitureRepository.findByBrand(brand);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByCategory(String category) throws FurnitureNotFoundException {
        List<Furniture> furniture= furnitureRepository.findByCategory(category);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;

    }

    @Override
    public List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException {
        List<Furniture> furniture= furnitureRepository.findByRoomType(roomType);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException {
        List<Furniture> furniture= furnitureRepository.findByMaterial(material);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByStyle(Style style) throws FurnitureNotFoundException {
        List<Furniture> furniture= furnitureRepository.findByStyle(style);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByStorageAvailable(boolean Storage) {
        List<Furniture> furniture= furnitureRepository.findByStorageAvailable(Storage);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByPriceRange(double minPrice, double maxPrice) {
        List<Furniture> furniture= furnitureRepository.findByPriceRange(minPrice,maxPrice);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByMatAndBrand(String material, String brand) {
        List<Furniture> furniture= furnitureRepository.findByMatAndBrand(material,brand);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public List<Furniture> getByRoomAndCategory(String RoomType, String category) {
        List<Furniture> furniture= furnitureRepository.findByRoomAndCategory(RoomType,category);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException();
        return furniture;
    }

    @Override
    public Integer getTotal() {
        int furnitureTotal= furnitureRepository.findTotal();
        if(furnitureTotal==0)
            throw  new FurnitureNotFoundException();
        return furnitureTotal;

    }

    @Override
    public Integer getCategoryCost(String category) {
        //return furnitureRepository.findCategoryCost(category);
        int furnitureTotal= furnitureRepository.findCategoryCost(category);
        if(furnitureTotal==0)
            throw  new FurnitureNotFoundException();
        return furnitureTotal;
    }
}
