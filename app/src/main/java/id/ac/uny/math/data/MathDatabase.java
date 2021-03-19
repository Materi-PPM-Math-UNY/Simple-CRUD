package id.ac.uny.math.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;


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
