package com.example.crackerapp.Controller;

import com.example.crackerapp.Model.Contactus;
import com.example.crackerapp.Service.ContactusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContactusController {

    @Autowired
    private ContactusService contactusService;

    @PostMapping("/contactus")
    public Contactus contact(@RequestBody Contactus contactus){
        return contactusService.send(contactus);
    }

    // 🔥 ADD THIS METHOD
    @GetMapping("/contactus")
    public List<Contactus> getAllContacts(){
        return contactusService.getAllContacts();
    }
}
