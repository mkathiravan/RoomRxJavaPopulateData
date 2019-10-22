package net.kathir.nativesdkapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SampleLocationDao {


    @Query("SELECT * from location_table ORDER BY data ASC")


    LiveData<List<SampleLocationModel>> getAlphabetizedWords();

    @Insert
    void insert(SampleLocationModel sampleLocationModel);



    @Query("DELETE FROM location_table")
    void deleteAll();


}
