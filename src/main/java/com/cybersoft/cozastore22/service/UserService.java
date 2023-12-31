package com.cybersoft.cozastore22.service;

import com.cybersoft.cozastore22.entity.UserEntity;
import com.cybersoft.cozastore22.payload.request.SignUpRequest;
import com.cybersoft.cozastore22.repository.UserRepository;
import com.cybersoft.cozastore22.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean insertUser(SignUpRequest signUpRequest) {
        boolean isSuccess = false;
        UserEntity user = new UserEntity();
        user.setEmail(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        try {
            userRepository.save(user);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("Loi insert user " + e.getLocalizedMessage());
        }

        return isSuccess;
    }
}
