package sg.edu.rp.c346.id20024402.oursingapore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDescription, etArea;
    Button btnInsert, btnShowList;
    RatingBar rbStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("My Singapore ~ Insert Island");

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etArea = findViewById(R.id.etArea);
        btnInsert = findViewById(R.id.btnInsertIsland);
        btnShowList = findViewById(R.id.btnShowList);

        rbStars = findViewById(R.id.ratingBarInput);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String description = etDescription.getText().toString().trim();
                if (name.length() == 0 || description.length() == 0){
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }

                String stringArea = etArea.getText().toString().trim();
                int area = Integer.valueOf(stringArea);
                int stars = (int) rbStars.getRating();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long result = dbh.insertIsland(name, description, area, stars);

                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Island inserted", Toast.LENGTH_LONG).show();
                    etName.setText("");
                    etDescription.setText("");
                    etArea.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });


    }

}
