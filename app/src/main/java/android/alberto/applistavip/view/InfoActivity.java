package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.alberto.applistavip.controller.UserController;
import android.alberto.applistavip.model.entities.User;
import android.content.Intent;
import android.os.Bundle;
import android.alberto.applistavip.R;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {
    User user;
    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        user = new User();

        userController = new UserController();
        userController.initializeSharedPreferences(this);

        TextView textViewContentFirstName = findViewById(R.id.textViewContentFirstName);
        TextView textViewContentSurname = findViewById(R.id.textViewContentSurname);
        TextView textViewContentPhoneNumber = findViewById(R.id.textViewContentPhoneNumber);
        TextView textViewContentIntendedCourse = findViewById(R.id.textViewContentIntendedCourse);
        Button btnClearHistory = findViewById(R.id.btnClearHistory);
        Button btnBack = findViewById(R.id.btnBack);

        // SHOW THE DATA ON EDITTEXT PLACE
        userController.getData(user);
        textViewContentFirstName.setText(user.getFirstName());
        textViewContentSurname.setText(user.getSurname());
        textViewContentPhoneNumber.setText(user.getPhoneNumber());
        textViewContentIntendedCourse.setText(user.getIntendedCourse());

        btnClearHistory.setOnClickListener(v -> {
            textViewContentFirstName.setText("");
            textViewContentSurname.setText("");
            textViewContentPhoneNumber.setText("");
            textViewContentIntendedCourse.setText("");
            Toast.makeText(InfoActivity.this, "Cleaned", Toast.LENGTH_LONG).show();

            userController.clean();
        });

        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}