package id.ac.uny.math.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * MhsDao adalah kelas interface yang berisi kumpulan method query/CRUD(Create Read Update dan Delete)
 */
@Dao
public interface MhsDao {

    // Insert
    @Insert
    void insert(Mhs... mhs);

    @Query("update mhs set nama=:nama, alamat=:alamat, hp=:hp where id=:id")
    void update(String nama, String alamat, String hp, int id);

    // Delete
    @Query("delete from mhs")
    void delete();


    //Read
    @Query("select * from mhs")
    List<Mhs> getMhs();

    @Query("select * from mhs where nama like :param or alamat like :param")
    List<Mhs> getMhs(String param);

    @Query("select * from mhs where hp =:hp")
    Mhs getMhsByHp(String hp);
}
