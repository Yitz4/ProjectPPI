package com.project.Camp.models;

import com.project.Camp.controller.CamperModel;
import com.project.Camp.services.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    CamperService service;

    @PostMapping()
    public CamperModel saveCamper(@RequestBody CamperModel camper){ return service.saveCamper(camper);}

    @PutMapping
    public CamperModel editCamper(@RequestBody CamperModel camper){ return service.editCamper(camper);}

    @GetMapping
    public ArrayList<CamperModel> getAllCampers(){ return service.getAllCampers();}

    @GetMapping("/findCamperById/{id}")
    public Optional<CamperModel> findCamperById(@PathVariable Long id){ return service.findCamperById(id);}

    @GetMapping("/findCamperByPhone/{phone}")
    public Optional<CamperModel> findCamperByPhone(@PathVariable Long phone){ return service.findStudentByPhone(phone);}

    @GetMapping("/findCamperByName/{name}")
    public Optional<CamperModel> findCamperByName(@PathVariable String name){ return service.findCamperByName(name);}

    @DeleteMapping("/delete-camper-by-id")
    public String deleteCamperById(@RequestParam("id") Long id){ return service.deleteCamperById(id);}
}
