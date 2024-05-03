package com.project.Camp.services;

import com.project.Camp.controller.CamperModel;
import com.project.Camp.repositories.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CamperService {
    @Autowired
    CamperRepository repository;

    //CRUD
    public CamperModel saveCamper(CamperModel camper){
        //Validar que el telefono no exista en otro campero
        Long searchPhone = camper.getPhone();
        String searchEmail = camper.getEmail();
        //Buscar en el repository en el metodo findByPhone si estamos usando el numero
        if(repository.findByPhone(searchPhone).isEmpty() && repository.findByEmail(searchEmail).isEmpty()){
            //Si no existe, agregarlo
            return repository.save(camper);
        }else{
            //si ya existe, retornarlo con el id -1
            CamperModel camperModel = new CamperModel();
            camperModel.setId(-1L);
            return camperModel;
        }
    }

    public ArrayList<CamperModel> getAllCampers(){ return (ArrayList<CamperModel>) repository.findAll(); }

    public Optional<CamperModel> findCamperById(Long id){
        return repository.findById(id);
    }

    public Optional<CamperModel> findCamperByName(String name){
        return repository.findByName(name);
    }
    public Optional<CamperModel> findCamperByEmail(String email){ return repository.findByEmail(email); }


    public CamperModel editCamper(CamperModel camper){
        return repository.save(camper);
    }

    public String deleteCamperById(Long id){
        if(findCamperById(id).isPresent()){
            repository.deleteById(id);
            return "Camper deleted successfully";
        }else {
            return "Camper with id = "+ id + " not found";
        }
    }

    public Optional<CamperModel> findStudentByPhone(Long phone){ return repository.findByPhone(phone);}
}
