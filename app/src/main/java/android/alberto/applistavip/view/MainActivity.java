package android.alberto.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.alberto.applistavip.R;
import android.alberto.applistavip.model.User;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user = new User(
            "Lorenzo",
            "Alberto",
            "Computing",
            "93 991853287"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextFirstname = findViewById(R.id.editTextFirstname);
        EditText editTextSurname = findViewById(R.id.editTextSurname);
        EditText editTextIntendedCourse = findViewById(R.id.editTextIntendedCourse);
        EditText editTextContactNum = findViewById(R.id.editTextContactNum);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // editTextFirstName.setText(user.getFirstName()); -- showed in the screen

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstname.setText("");
                editTextSurname.setText("");
                editTextIntendedCourse.setText("");
                editTextContactNum.setText("");
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Finalizado", Toast.LENGTH_LONG).show();

                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFirstname(editTextFirstname.getText().toString());
                user.setSurname(editTextSurname.getText().toString());
                user.setIntendedCourse(editTextIntendedCourse.getText().toString());
                user.setPhoneNumber(editTextContactNum.getText().toString());

                Toast.makeText(MainActivity.this, "Resposta salva: " + user.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}