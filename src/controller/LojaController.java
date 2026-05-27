package controller;

import java.util.Objects;

public class LojaController {

    public boolean loginLoja(String user, String password){
        if(Objects.equals(user, "admin") && Objects.equals(password, "admin")){
            return true;
        }
        return false;
    }

}
