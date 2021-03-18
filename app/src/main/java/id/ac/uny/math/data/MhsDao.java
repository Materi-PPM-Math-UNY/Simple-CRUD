package id.ac.uny.math.data;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * MhsDao adalah kelas interface yang berisi kumpulan method query/CRUD(Create Read Update dan Delete)
 */

public interface MhsDao {

    // Insert
    @Insert
    void insert(Mhs... mhs);

    // Update
    @Update
    void update(Mhs... mhs);

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
