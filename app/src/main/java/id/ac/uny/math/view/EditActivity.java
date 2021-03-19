package id.ac.uny.math.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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
    boolean isNew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mhsParcel = getIntent().getParcelableExtra("mhs");
        isNew = (mhsParcel == null);

        initview();
        initData();
        initAction();
    }

    void initview(){
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(isNew? "Tambah":"Edit");

        edtAlamat = findViewById(R.id.edtAlamat);
        edtNama = findViewById(R.id.edtNama);
        edtPhone = findViewById(R.id.edtHp);
        btnSimpan = findViewById(R.id.btnSimpan);
    }

    void initData(){
        if (mhsParcel != null) {
            edtNama.setText(mhsParcel.getNama());
            edtNama.requestFocus();
            edtNama.setSelection(edtNama.getText().length());

            edtPhone.setText(mhsParcel.getHp());
            edtAlamat.setText(mhsParcel.getAlamat());

        }
    }

    void doSave(){
        if (isNew) mhsParcel = new MhsParcel();
        mhsParcel.setHp(edtPhone.getText().toString());
        mhsParcel.setNama(edtNama.getText().toString());
        mhsParcel.setAlamat(edtAlamat.getText().toString());
        Log.d("MATH", "CEK-MATH:"+mhsParcel.getNama());
        Log.d("MATH", "CEK-MATH:"+mhsParcel.getAlamat());
    }

    void initAction(){
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doSave();

                Intent intent = getIntent();
                intent.putExtra("mhs", mhsParcel);
                intent.putExtra("isNew", isNew);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}