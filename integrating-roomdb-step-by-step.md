## Integrasi Room Db

### Install & Setup RoomDb
	Buka Gradle, tambahkan 2 package id berikut ini pada dependencies
  ```
  implementation "androidx.room:room###runtime:2.3.0"
  annotationProcessor "androidx.room:room###compiler:2.3.0"
  ```

### Membuat Pojo Entity beserta Parcelablenya(jika perlu)
  ```
  @Entity
  public class MhsEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "alamat")
    private String alamat;
    @ColumnInfo(name = "hp")
    private String hp;
    ...
    ...
  ```
### Membuat DAOI(Data Access Object Interface)
  ```
  @Dao
  public interface MhsDao {

    // Insert
    @Insert
    void insert(MhsEntity... mhs);

    // Update
    @Query("update MhsEntity set nama=:nama, alamat=:alamat, hp=:hp where id=:id")
    void update(String nama, String alamat, String hp, int id);

    //Read
    @Query("select * from MhsEntity")
    List<MhsEntity> getMhs();
    ...
    ...
  }
  ```
### Membuat Abstract Database.
```
@Database(
        entities = {
                MhsEntity.class  //Tambah entity disini..
        },
        version = 1,
        exportSchema = false
)
public abstract class MathDatabase extends RoomDatabase {
        public abstract MhsDao getMhsDao();
}
```
### Membuat Main Class meng###extends dari Application.
```
public class MathApp extends Application {

    public static MathDatabase mathDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mathDatabase = Room.databaseBuilder(getApplicationContext(), MathDatabase.class, "math###db")
                .allowMainThreadQueries().build();
    }
}
```
### Change App Name pada manifest.
```
<application
        android:name=".MathApp"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
    
...
...
```
View:
### Membuat MainActivity dan LinearLayout untuk menampilkan isi tabel.
### Membuat EditActivity untuk insert dan edit.
### Membuat ViewItem


