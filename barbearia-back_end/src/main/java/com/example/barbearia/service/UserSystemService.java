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
       if(userSystem!=null && userSystem.getId()>=0)
           if (verifyPassword(password, userSystem.getId()))
           return true;
       return false;
    }

    private boolean verifyPassword(String Password, long id){
        UserSystem user = userSystemRepository.findById(id);
        if(Password.equals(user.getPassword()))
            return true;
        return false;
    }

}
