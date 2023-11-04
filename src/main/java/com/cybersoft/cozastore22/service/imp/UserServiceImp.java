package com.cybersoft.cozastore22.service.imp;

import com.cybersoft.cozastore22.payload.request.SignUpRequest;

public interface UserServiceImp {
    boolean insertUser(SignUpRequest signUpRequest);
}
