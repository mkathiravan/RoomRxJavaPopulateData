package net.kathir.nativesdkapp;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {SampleLocationModel.class}, version = 1)
public abstract class SampleLocationDatabase extends RoomDatabase {


    public abstract SampleLocationDao sampleLocationDao();

    private static volatile SampleLocationDatabase INSTANCE;

    static SampleLocationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SampleLocationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SampleLocationDatabase.class, "location_database").
                            addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback()
    {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }

    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final SampleLocationDao mDao;

        PopulateDbAsync(SampleLocationDatabase db) {
            mDao = db.sampleLocationDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();

            SampleLocationModel sampleLocationModel = new SampleLocationModel();
            sampleLocationModel.setTimestamp("22-10-2019");
            sampleLocationModel.setData("Test1");
            mDao.insert(sampleLocationModel);

            sampleLocationModel.setTimestamp("23-10-2019");
            sampleLocationModel.setData("Test2");
            mDao.insert(sampleLocationModel);
            return null;
        }
    }

}
