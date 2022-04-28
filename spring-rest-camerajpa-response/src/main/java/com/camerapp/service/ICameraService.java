package com.camerapp.service;


import com.camerapp.exception.CameraNotFoundException;
import com.camerapp.model.Camera;

import java.util.List;

public interface ICameraService {

    Camera addCamera(Camera camera);
    void updateCamera(Camera camera);
    void deleteCamera(int cameraId);

    List<Camera>getAll() throws CameraNotFoundException;
    List<Camera> getByBrandAndPrice(String brand, double price) throws CameraNotFoundException;
    List<Camera>getByLensType(String lensType) throws CameraNotFoundException;
    List<Camera>getByCameraType(String cameraType) throws CameraNotFoundException;
    List<Camera>getByPrice(double price) throws CameraNotFoundException;
    Camera getById(int cameraId) throws CameraNotFoundException;

}
