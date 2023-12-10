package android.alberto.applistavip.controller;

import android.alberto.applistavip.model.User;
import android.util.Log;

public class UserController {
    public void saveInfo(User user) {
        Log.i("ControllerInfo", "Saved this: " + user.toString());
    }
}
