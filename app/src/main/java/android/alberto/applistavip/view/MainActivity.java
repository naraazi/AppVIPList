package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.alberto.applistavip.R;
import android.alberto.applistavip.controller.UserController;
import android.alberto.applistavip.model.User;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor VIPList;
    
    User user = new User(
            "Lorenzo",
            "Alberto",
            "Computing",
            "93 991853287"
    );
    UserController controller = new UserController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("simpleUserData", 0);
        VIPList = preferences.edit();

        EditText editTextFirstname = findViewById(R.id.editTextFirstname);
        EditText editTextSurname = findViewById(R.id.editTextSurname);
        EditText editTextIntendedCourse = findViewById(R.id.editTextIntendedCourse);
        EditText editTextContactNum = findViewById(R.id.editTextContactNum);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnClear.setOnClickListener(v -> {
            editTextFirstname.setText("");
            editTextSurname.setText("");
            editTextIntendedCourse.setText("");
            editTextContactNum.setText("");
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

            VIPList.putString("firstname", user.getFirstname());
            VIPList.putString("surname", user.getSurname());
            VIPList.putString("intendedCourse", user.getIntendedCourse());
            VIPList.putString("contactNum", user.getPhoneNumber());
            VIPList.apply();

            controller.saveInfo(user);
        });
    }
}