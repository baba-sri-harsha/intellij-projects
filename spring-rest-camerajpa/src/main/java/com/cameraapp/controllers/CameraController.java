package com.cameraapp.controllers;

import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cameras-api")
public class CameraController {

    private ICameraService cameraService;

    public CameraController(ICameraService cameraService) {
        this.cameraService = cameraService;
    }

    @PostMapping("/cameras")
    public Camera addCamera(@RequestBody Camera camera){
        return cameraService.addCamera(camera);
    }

    @PutMapping("/cameras")
    public void updateCamera(@RequestBody Camera camera){
        cameraService.updateCamera(camera);
    }

    @DeleteMapping("/cameras/cameraId/{cameraId}")
    public void deleteCamera(@PathVariable("cameraId")int cameraId){
        cameraService.deleteCamera(cameraId);
    }

    @GetMapping("/cameras")
    public List<Camera> showCameras(){
        return  cameraService.getAll();
    }

    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public List<Camera> showCameraBy(@PathVariable("brand")String brand, @PathVariable("price") double price){
        return  cameraService.getByBrandAndPrice(brand,price);
    }

    @RequestMapping("/cameras/lenstype/{lensType}")
    public  List<Camera>showByLensType(@PathVariable("lensType") String lensType){
        return cameraService.getByLensType(lensType);
    }


    @RequestMapping("/cameras/cameratype/{cameraType}")
    public  List<Camera>showByCameraType( @PathVariable("cameraType") String cameraType){
        return cameraService.getByCameraType(cameraType);
    }


    @RequestMapping("/cameras/getByPrice/{price}")
    public  List<Camera>showByPrice(@PathVariable("price") double price){
        return cameraService.getByPrice(price);
    }


    @RequestMapping("/cameras/id/{cameraId}")
    public Camera showById(@PathVariable("cameraId") int cameraId){
        return cameraService.getById(cameraId);
    }



}
