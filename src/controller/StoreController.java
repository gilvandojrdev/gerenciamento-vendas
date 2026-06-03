package controller;

import java.util.Objects;

public class StoreController {

    public boolean login(String user, String password){
        if(Objects.equals(user, "admin") && Objects.equals(password, "admin")){
            return true;
        }
        return false;
    }

}
