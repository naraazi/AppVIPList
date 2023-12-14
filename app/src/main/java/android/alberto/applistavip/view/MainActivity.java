package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.alberto.applistavip.R;
import android.alberto.applistavip.controller.CourseController;
import android.alberto.applistavip.controller.UserController;
import android.alberto.applistavip.model.entities.User;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user;
    UserController userController;
    CourseController courseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner); //activity_main

        userController = new UserController();
        userController.initializeSharedPreferences(this);

        user = new User();
        courseController = new CourseController();

        EditText editTextFirstname = findViewById(R.id.editTextFirstname);
        EditText editTextSurname = findViewById(R.id.editTextSurname);
        EditText editTextIntendedCourse = findViewById(R.id.editTextIntendedCourse);
        EditText editTextContactNum = findViewById(R.id.editTextContactNum);
        Spinner spinnerIntendedCourse = findViewById(R.id.spinnerIntendedCourse);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // SHOW THE DATA ON EDITTEXT PLACE
        userController.getData(user);
        editTextFirstname.setText(user.getFirstname());
        editTextSurname.setText(user.getSurname());
        editTextIntendedCourse.setText(user.getIntendedCourse());
        editTextContactNum.setText(user.getPhoneNumber());

        // ADAPTER
        ArrayAdapter<String> arraySpinnerIntendedCourse = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                courseController.courseListSpinner());
        arraySpinnerIntendedCourse.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerIntendedCourse.setAdapter(arraySpinnerIntendedCourse);

        btnClear.setOnClickListener(v -> {
            editTextFirstname.setText("");
            editTextSurname.setText("");
            editTextIntendedCourse.setText("");
            editTextContactNum.setText("");
            Toast.makeText(MainActivity.this, "Cleaned", Toast.LENGTH_LONG).show();

            userController.clean();
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
            Toast.makeText(MainActivity.this,
                    "Saved data: " + user.toString(),
                    Toast.LENGTH_LONG).show();

            userController.saveInfo(user);
        });
    }
}