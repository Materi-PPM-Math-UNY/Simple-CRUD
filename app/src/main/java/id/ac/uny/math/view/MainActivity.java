package id.ac.uny.math.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

   public static int CRUD_REQ = 222;

    LinearLayout linMain;
    FloatingActionButton btnAdd;

    List<Mhs> mhsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiviews();
        initaction();
        initdata();
    }

    void initdata(){
        if (mathDatabase.getMhsDao().getMhs() == null) return;

        mhsList = mathDatabase.getMhsDao().getMhs();

        linMain.removeAllViews();
        for (int i = 0; i < mhsList.size(); i++){
            ViewItemMhs viewItemMhs = new ViewItemMhs(this);
            viewItemMhs.setMhs(mhsList.get(i));
            linMain.addView(viewItemMhs, 0);
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
                startActivityForResult(intent, CRUD_REQ);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CRUD_REQ && resultCode == RESULT_OK){

            boolean isNew = data.getBooleanExtra("isNew", false);
            MhsParcel mhsParcel = data.getParcelableExtra("mhs");
            Mhs mhs = mhsParcel.toMhs();

            if (isNew){
                mathDatabase.getMhsDao().insert(mhs);
            } else {
                mathDatabase.getMhsDao().update(mhs.getNama(), mhs.getAlamat(), mhs.getHp(), mhs.getId());
            }
            initdata();
        }
    }
}