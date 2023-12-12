package android.alberto.applistavip.controller;

import android.alberto.applistavip.model.User;
import android.alberto.applistavip.view.MainActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class UserController {
    private SharedPreferences preferences;
    private SharedPreferences.Editor saveSimpleUserData;

    public UserController() {}

    public void initializeSharedPreferences(Context context) {
        preferences = context.getSharedPreferences("saveSimpleUserData", 0);
        saveSimpleUserData = preferences.edit();
    }

    public void saveInfo(User user) {
        Log.i("ControllerInfo", "Saved this: " + user.toString());

        saveSimpleUserData.putString("firstname", user.getFirstname());
        saveSimpleUserData.putString("surname", user.getSurname());
        saveSimpleUserData.putString("intendedCourse", user.getIntendedCourse());
        saveSimpleUserData.putString("contactNum", user.getPhoneNumber());
        saveSimpleUserData.apply();
    }

    public User getData(User user) {
        user.setFirstname(preferences.getString("firstname", "--NOT FOUND--"));
        user.setSurname(preferences.getString("surname", "--NOT FOUND--"));
        user.setIntendedCourse(preferences.getString("intendedCourse", "--NOT FOUND--"));
        user.setPhoneNumber(preferences.getString("contactNum", "--NOT FOUND--"));

        return user;
    }

    public void clean() {
         saveSimpleUserData.clear();
         saveSimpleUserData.apply();
    }
}
