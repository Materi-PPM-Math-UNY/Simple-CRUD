package id.ac.uny.math.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.ac.uny.math.R;
import id.ac.uny.math.data.Mhs;

public class ViewItemMhs extends RelativeLayout {

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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.layout_item_mhs, null);
        txtHP = findViewById(R.id.txtHP);
        txtNama = findViewById(R.id.txtNama);
        txtAlamat = findViewById(R.id.txtAlamat);
        btnEdit = findViewById(R.id.btnEdit);
    }
}
