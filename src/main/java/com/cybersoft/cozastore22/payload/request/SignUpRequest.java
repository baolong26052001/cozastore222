package com.cybersoft.cozastore22.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SignUpRequest {

    @NotEmpty(message = "Username khong duoc de trong")
    @Length(min = 4, message = "Độ dài của username ít nhất phải là 4 ký tự")
    private String username;

    @NotEmpty(message = "Password khong duoc de trong")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
