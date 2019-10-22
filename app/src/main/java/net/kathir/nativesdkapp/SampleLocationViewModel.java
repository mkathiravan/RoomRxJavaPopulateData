package net.kathir.nativesdkapp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SampleLocationViewModel extends AndroidViewModel {

    private SampleLocationRepository mRepository;

    private LiveData<List<SampleLocationModel>> mAllWords;

    public SampleLocationViewModel (Application application) {
        super(application);
        mRepository = new SampleLocationRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<SampleLocationModel>> getAllWords() {
        return mAllWords; }

    public void insert(SampleLocationModel word) {
        mRepository.insert(word); }
}
