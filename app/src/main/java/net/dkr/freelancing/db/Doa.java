package net.dkr.freelancing.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Doa {
    @Insert
    void saveListAdd(SaveListModel model);
    @Delete
    void deletSaveListItem(SaveListModel model);
    @Query("Select * from saveListGig where gigId = :id")
    SaveListModel isSaved(String id);
    @Query("select * from saveListGIg ")
    List<SaveListModel> saveListsGet();
}
