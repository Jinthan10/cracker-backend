package com.example.crackerapp.Controller;

import com.example.crackerapp.Model.Contactus;
import com.example.crackerapp.Service.ContactusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "https://fronty.z29.web.core.windows.net")
// @CrossOrigin

public class ContactusController {

    @Autowired
    private ContactusService contactusService;

    @PostMapping("/contactus")
    public Contactus contact(@RequestBody Contactus contactus){
        return contactusService.send(contactus);
    }

}
