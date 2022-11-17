package RestaurantTillSystem;

import java.io.*;

public class LoginDetails implements Serializable {
    String loginName;
    double pin;

    public LoginDetails(String loginName, double pin) {
        setLoginName(loginName);
        setPin(pin);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public double getPin() {
        return pin;
    }

    public void setPin(double pin) {
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
