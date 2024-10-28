package com.example.appsederhana;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama, editTextEmail, editTextTelepon;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxReading, checkBoxTraveling, checkBoxGaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextNama = findViewById(R.id.editTextNama);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelepon = findViewById(R.id.editTextTelepon);
        radioGroupGender = findViewById(R.id.radioGroupGender);

        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxTraveling = findViewById(R.id.checkBoxTraveling);
        checkBoxGaming = findViewById(R.id.checkBoxGaming);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = editTextNama.getText().toString();
                String email = editTextEmail.getText().toString();
                String telepon = editTextTelepon.getText().toString();


                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedGenderId);
                String gender = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Tidak dipilih";


                StringBuilder hobbies = new StringBuilder();
                if (checkBoxReading.isChecked()) {
                    hobbies.append("Membaca ");
                }
                if (checkBoxTraveling.isChecked()) {
                    hobbies.append("Bepergian ");
                }
                if (checkBoxGaming.isChecked()) {
                    hobbies.append("Bermain Game ");
                }
                if (hobbies.length() == 0) {
                    hobbies.append("Tidak ada hobi yang dipilih");
                }


                String result = "Nama: " + nama + "\n" +
                        "Email: " + email + "\n" +
                        "Telepon: " + telepon + "\n" +
                        "Jenis Kelamin: " + gender + "\n" +
                        "Hobi: " + hobbies.toString();


                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
