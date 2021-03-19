package id.ac.uny.math.data;

import android.os.Parcel;
import android.os.Parcelable;

public class MhsParcel implements Parcelable {
    public static final Creator<MhsParcel> CREATOR = new Creator<MhsParcel>() {
        @Override
        public MhsParcel createFromParcel(Parcel in) {
            return new MhsParcel(in);
        }

        @Override
        public MhsParcel[] newArray(int size) {
            return new MhsParcel[size];
        }
    };
    private int id;
    private String nama;
    private String alamat;
    private String hp;

    public MhsParcel(){}

    protected MhsParcel(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        alamat = in.readString();
        hp = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nama);
        dest.writeString(alamat);
        dest.writeString(hp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public MhsEntity toEntity(){
        MhsEntity mhsEntity = new MhsEntity();
        mhsEntity.setId(id);
        mhsEntity.setHp(hp);
        mhsEntity.setNama(nama);
        mhsEntity.setAlamat(alamat);
        return mhsEntity;
    }
}
