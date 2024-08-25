package net.dkr.freelancing.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = SaveListModel.class ,version = 3)
public abstract class SaveListDb extends RoomDatabase {
    private static SaveListDb db;
   abstract public Doa doa();

    public static synchronized SaveListDb getDb(Context context) {
        if (db == null){
            db = Room.databaseBuilder(context,SaveListDb.class,"saveGig")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }
}
