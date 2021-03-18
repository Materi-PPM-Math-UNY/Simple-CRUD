package id.ac.uny.math.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.ac.uny.math.R;

public class MainActivity extends AppCompatActivity {

    LinearLayout linMain;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiviews();
        initaction();
    }

    void intiviews(){
        linMain = findViewById(R.id.linMain);
        btnAdd = findViewById(R.id.btnAdd);
    }

    void initaction(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }
}