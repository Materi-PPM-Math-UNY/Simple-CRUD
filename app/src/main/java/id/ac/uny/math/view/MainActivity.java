package id.ac.uny.math.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import id.ac.uny.math.R;
import id.ac.uny.math.data.Mhs;
import id.ac.uny.math.data.MhsParcel;

import static id.ac.uny.math.MathApp.mathDatabase;

public class MainActivity extends AppCompatActivity {

    LinearLayout linMain;
    FloatingActionButton btnAdd;

    List<Mhs> mhsList = new ArrayList<>();
    ViewItemMhs selectedViewMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiviews();
        initaction();
        initdata();
    }

    void initdata(){
        mhsList = mathDatabase.getMhsDao().getMhs();
        for (int i = 0; i < mhsList.size(); i++){
            ViewItemMhs viewItemMhs = new ViewItemMhs(this);
            viewItemMhs.setMhs(mhsList.get(i));

            MhsParcel mhsParcel = mhsList.get(i).toParcel();

            viewItemMhs.getBtnEdit().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedViewMhs = viewItemMhs;
                    Intent intent = new Intent(MainActivity.this, EditActivity.class);
                    intent.putExtra("mhs", mhsParcel);
                    startActivityForResult(intent, 222);
                }
            });

            linMain.addView(viewItemMhs);
        }
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