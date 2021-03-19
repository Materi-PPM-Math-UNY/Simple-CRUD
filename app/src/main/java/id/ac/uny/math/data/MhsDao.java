package id.ac.uny.math.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * MhsDao adalah kelas interface yang berisi kumpulan method query/CRUD(Create Read Update dan Delete)
 */
@Dao
public interface MhsDao {

    // Insert
    @Insert
    void insert(MhsEntity... mhs);

    @Query("update MhsEntity set nama=:nama, alamat=:alamat, hp=:hp where id=:id")
    void update(String nama, String alamat, String hp, int id);

    // Delete
    @Query("delete from MhsEntity")
    void delete();

    //Read
    @Query("select * from MhsEntity")
    List<MhsEntity> getMhs();

    @Query("select * from MhsEntity where nama like :param or alamat like :param")
    List<MhsEntity> getMhs(String param);

    @Query("select * from MhsEntity where hp =:hp")
    MhsEntity getMhsByHp(String hp);
}
