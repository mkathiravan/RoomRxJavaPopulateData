package net.kathir.nativesdkapp;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SampleLocationRepository {


    private SampleLocationDao sampleLocationDao;
    private LiveData<List<SampleLocationModel>> mAllWords;

    SampleLocationRepository(Application application) {
        SampleLocationDatabase db = SampleLocationDatabase.getDatabase(application);
        sampleLocationDao = db.sampleLocationDao();
        mAllWords = sampleLocationDao.getAlphabetizedWords();

    }

    LiveData<List<SampleLocationModel>> getAllWords() {
        return mAllWords;
    }


    public void insert (SampleLocationModel word) {
        new insertAsyncTask(sampleLocationDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<SampleLocationModel, Void, Void> {

        private SampleLocationDao mAsyncTaskDao;

        insertAsyncTask(SampleLocationDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final SampleLocationModel... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


}
