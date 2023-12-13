package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.alberto.applistavip.R;
import android.alberto.applistavip.controller.UserController;
import android.alberto.applistavip.model.entities.User;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user;
    UserController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new UserController();
        controller.initializeSharedPreferences(this);

        user = new User();


        EditText editTextFirstname = findViewById(R.id.editTextFirstname);
        EditText editTextSurname = findViewById(R.id.editTextSurname);
        EditText editTextIntendedCourse = findViewById(R.id.editTextIntendedCourse);
        EditText editTextContactNum = findViewById(R.id.editTextContactNum);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // SHOW THE DATA ON EDITTEXT PLACE
        controller.getData(user);
        editTextFirstname.setText(user.getFirstname());
        editTextSurname.setText(user.getSurname());
        editTextIntendedCourse.setText(user.getIntendedCourse());
        editTextContactNum.setText(user.getPhoneNumber());

        btnClear.setOnClickListener(v -> {
            editTextFirstname.setText("");
            editTextSurname.setText("");
            editTextIntendedCourse.setText("");
            editTextContactNum.setText("");
            Toast.makeText(MainActivity.this, "Cleaned", Toast.LENGTH_LONG).show();

            controller.clean();
        });

        btnSubmit.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_LONG).show();

            finish();
        });

        btnSave.setOnClickListener(v -> {
            user.setFirstname(editTextFirstname.getText().toString());
            user.setSurname(editTextSurname.getText().toString());
            user.setIntendedCourse(editTextIntendedCourse.getText().toString());
            user.setPhoneNumber(editTextContactNum.getText().toString());
            Toast.makeText(MainActivity.this, "Saved data: " + user.toString(), Toast.LENGTH_LONG).show();

            controller.saveInfo(user);
        });
    }
}