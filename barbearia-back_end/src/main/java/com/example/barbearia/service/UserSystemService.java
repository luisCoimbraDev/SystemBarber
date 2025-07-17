package com.example.barbearia.service;

import com.example.barbearia.model.UserSystem;
import com.example.barbearia.repository.UserSystemRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSystemService {
    private final UserSystemRepository userSystemRepository;

    public UserSystemService(UserSystemRepository userSystemRepository){
        this.userSystemRepository = userSystemRepository;
    }

    public boolean verifyUser(String name, String password){
       UserSystem userSystem  = userSystemRepository.findByloginuser(name);
       if(userSystem==null)
           return false;
       return userSystem.getPassword().equals(password);


    }

}
