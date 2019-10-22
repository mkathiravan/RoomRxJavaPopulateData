package net.kathir.nativesdkapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "location_table")
public class SampleLocationModel {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "timestamp")
    private String timestamp;

    @ColumnInfo(name = "data")
    private String data;



    @NonNull
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull String timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }




}
