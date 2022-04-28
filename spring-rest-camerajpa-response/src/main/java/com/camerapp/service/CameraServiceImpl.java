package com.camerapp.service;


import com.camerapp.exception.CameraNotFoundException;
import com.camerapp.model.Camera;
import com.camerapp.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CameraServiceImpl implements ICameraService {

    private ICameraRepository cameraRepository;
    @Autowired
    public void setCameraRepository(ICameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public Camera addCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    @Override
    public void updateCamera(Camera camera) {
            cameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
            cameraRepository.deleteById(cameraId);
    }

    @Override
    public List<Camera> getAll() throws CameraNotFoundException {

        return cameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) throws CameraNotFoundException {
        List<Camera> cameras =cameraRepository.findByBrandAndPrice(brand, price);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("camera brnad and price not found");
        return  cameras;
    }

    @Override
    public List<Camera> getByLensType(String lensType) throws CameraNotFoundException {
        List<Camera> cameras =cameraRepository.findByLensType(lensType);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("camera lens type not found");
        return  cameras;
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException {
        List<Camera> cameras =cameraRepository.findByCameraType(cameraType);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("camera camera type not found");
        return  cameras;
    }

    @Override
    public List<Camera> getByPrice(double price) throws CameraNotFoundException {

        List<Camera> cameras =cameraRepository.findByPrice(price);
        if(cameras.isEmpty())
            throw new CameraNotFoundException("camera price  not found");
        return  cameras;
    }

    @Override
    public Camera getById(int cameraId) throws CameraNotFoundException {
        Camera camera =  cameraRepository.findById(cameraId);
        if (camera == null)
            throw new CameraNotFoundException("camera id"+ cameraId+" not found");
        return camera;
    }
}




