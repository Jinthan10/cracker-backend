package com.example.crackerapp.Service;

import com.example.crackerapp.Model.Contactus;
import com.example.crackerapp.Repository.Contactusrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactusService {

    @Autowired
    private Contactusrepo contactusrepo;

    public Contactus send(Contactus contactus){
        return contactusrepo.save(contactus);
    }

    // 🔥 ADD THIS
    public List<Contactus> getAllContacts(){
        return contactusrepo.findAll();
    }
}
