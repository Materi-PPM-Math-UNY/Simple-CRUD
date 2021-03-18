package id.ac.uny.math.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.ac.uny.math.R;
import id.ac.uny.math.data.Mhs;

public class ViewItemMhs extends RelativeLayout {

    Context context;
    TextView txtHP;
    TextView txtNama;
    TextView txtAlamat;
    Button btnEdit;
    Mhs mhs;

    public Button getBtnEdit() {
        return btnEdit;
    }

    public ViewItemMhs(Context context) {
        super(context);
        inflate(context);
    }

    public ViewItemMhs(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public ViewItemMhs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public void setMhs(Mhs mhs) {
        this.mhs = mhs;
        txtNama.setText(mhs.getNama());
        txtAlamat.setText(mhs.getAlamat());
        txtHP.setText(mhs.getHp());
    }

    void inflate(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.layout_item_mhs, this);
        txtHP = findViewById(R.id.txtHP);
        txtNama = findViewById(R.id.txtNama);
        txtAlamat = findViewById(R.id.txtAlamat);
        btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("mhs", mhs.toParcel());
                ((Activity)context).startActivityForResult(intent, MainActivity.CRUD_REQ);
            }
        });
    }

}
