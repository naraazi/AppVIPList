package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.alberto.applistavip.R;
import android.alberto.applistavip.controller.CourseController;
import android.alberto.applistavip.controller.UserController;
import android.alberto.applistavip.model.entities.User;
import android.content.Intent;
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
        setContentView(R.layout.activity_main);

        userController = new UserController();
        userController.initializeSharedPreferences(this);

        user = new User();
        courseController = new CourseController();

        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextSurname = findViewById(R.id.editTextSurname);
        EditText editTextContactNum = findViewById(R.id.editTextContactNum);
        Spinner spinnerIntendedCourse = findViewById(R.id.spinnerIntendedCourse);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        Button btnContentHistory = findViewById(R.id.btnContentHistory);

        // ADAPTER
        ArrayAdapter<String> arraySpinnerIntendedCourse = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                courseController.courseListSpinner());
        arraySpinnerIntendedCourse.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerIntendedCourse.setAdapter(arraySpinnerIntendedCourse);

        btnClear.setOnClickListener(v -> {
            editTextFirstName.setText("");
            editTextSurname.setText("");
            editTextContactNum.setText("");
            Toast.makeText(MainActivity.this, "Cleaned", Toast.LENGTH_LONG).show();

            userController.clean();
            userController.saveInfo(user);
        });

        btnSubmit.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_LONG).show();

            finish();
        });

        btnSave.setOnClickListener(v -> {
            user.setFirstName(editTextFirstName.getText().toString());
            user.setSurname(editTextSurname.getText().toString());
            user.setIntendedCourse(spinnerIntendedCourse.getSelectedItem().toString());
            user.setPhoneNumber(editTextContactNum.getText().toString());
            Toast.makeText(MainActivity.this,
                    "Saved data",
                    Toast.LENGTH_LONG).show();

            userController.saveInfo(user);
        });

        btnContentHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);

            startActivity(intent);
        });
    }
}