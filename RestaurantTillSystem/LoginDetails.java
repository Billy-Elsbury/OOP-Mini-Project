package RestaurantTillSystem;

import java.io.*;

public class LoginDetails implements Serializable {

    String loginName;
    int pin;

    public LoginDetails(){
        this("User does not exist",000000);
    }

    public LoginDetails(String loginName, int pin) {
        setLoginName(loginName);
        setPin(pin);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "LoginDetails{" +
                "name='" + getLoginName() + '\'' +
                ", pin=" + getPin() +
                '}';
    }
}
