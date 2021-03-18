package id.ac.uny.math;

import android.app.Application;

import androidx.room.Room;

import id.ac.uny.math.data.MathDatabase;

public class MathApp extends Application {

    public static MathDatabase mathDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mathDatabase = Room.databaseBuilder(getApplicationContext(), MathDatabase.class, "math-db")
                .allowMainThreadQueries().build();
    }
}
