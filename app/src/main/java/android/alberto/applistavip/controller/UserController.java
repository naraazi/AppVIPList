package android.alberto.applistavip.controller;

import android.alberto.applistavip.model.entities.User;
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

        saveSimpleUserData.putString("firstname", user.getFirstName());
        saveSimpleUserData.putString("surname", user.getSurname());
        saveSimpleUserData.putString("intendedCourse", user.getIntendedCourse());
        saveSimpleUserData.putString("contactNum", user.getPhoneNumber());
        saveSimpleUserData.apply();
    }

    public void getData(User user) { // used to return user
        user.setFirstName(preferences.getString("firstname", "--NOT FOUND--"));
        user.setSurname(preferences.getString("surname", "--NOT FOUND--"));
        user.setIntendedCourse(preferences.getString("intendedCourse", "--NOT FOUND--"));
        user.setPhoneNumber(preferences.getString("contactNum", "--NOT FOUND--"));

    }

    public void clean() {
         saveSimpleUserData.clear();
         saveSimpleUserData.apply();
    }
}
