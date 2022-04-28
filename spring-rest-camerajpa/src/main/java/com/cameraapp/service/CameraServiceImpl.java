package com.cameraapp.service;

import com.cameraapp.model.Camera;
import com.cameraapp.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements ICameraService{

    @Autowired
    ICameraRepository iCameraRepository;

    @Override
    public Camera addCamera(Camera camera) {
        iCameraRepository.save(camera);

        return camera;
    }

    @Override
    public void updateCamera(Camera camera) {
        iCameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
        iCameraRepository.deleteById(cameraId);
    }

    @Override
    public List<Camera> getAll() {
        return iCameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) {
        return iCameraRepository.findByBrandAndPrice(brand,price);
    }

    @Override
    public List<Camera> getByLensType(String lensType) {
        return iCameraRepository.findByLensType(lensType);
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) {
        return iCameraRepository.findByCameraType(cameraType);
    }

    @Override
    public List<Camera> getByPrice(double price) {
        return iCameraRepository.findByPrice(price);
    }

    @Override
    public Camera getById(int cameraId) {
        return iCameraRepository.findById(cameraId);
    }
}
