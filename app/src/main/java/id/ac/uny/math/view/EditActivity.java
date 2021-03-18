package id.ac.uny.math.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.ac.uny.math.R;
import id.ac.uny.math.data.MhsParcel;

public class EditActivity extends AppCompatActivity {

    EditText edtNama;
    EditText edtAlamat;
    EditText edtPhone;
    Button btnSimpan;

    MhsParcel mhsParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mhsParcel = getIntent().getParcelableExtra("mhs");

        initview();
        initData();
        initAction();
    }

    void initview(){
        edtAlamat = findViewById(R.id.edtAlamat);
        edtNama = findViewById(R.id.edtNama);
        edtPhone = findViewById(R.id.edtHp);
        btnSimpan = findViewById(R.id.btnSimpan);
    }

    void initData(){
        if (mhsParcel != null) {
            edtPhone.setText(mhsParcel.getHp());
            edtNama.setText(mhsParcel.getNama());
            edtAlamat.setText(mhsParcel.getAlamat());
        }
    }

    void doSave(){
        mhsParcel = new MhsParcel();
        mhsParcel.setHp(edtPhone.getText().toString());
        mhsParcel.setNama(edtNama.getText().toString());
        mhsParcel.setAlamat(edtAlamat.getText().toString());
    }

    /*View.OnClickListener clickSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doSave();

            Intent intent = getIntent();
            intent.putExtra("mhs", mhsParcel);
            setResult(RESULT_OK, intent);
            finish();
        }
    };*/

    void initAction(){
        //btnSimpan.setOnClickListener(clickSave);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doSave();

                Intent intent = getIntent();
                intent.putExtra("mhs", mhsParcel);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}