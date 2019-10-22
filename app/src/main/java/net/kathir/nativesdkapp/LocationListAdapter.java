package net.kathir.nativesdkapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.LocationViewHolder> {

    private static final String TAG = LocationListAdapter.class.getSimpleName();

    class LocationViewHolder extends RecyclerView.ViewHolder {
        private final TextView timeStampValue,dataVal;

        private LocationViewHolder(View itemView) {
            super(itemView);
            timeStampValue = itemView.findViewById(R.id.timeStampValue);
            dataVal = itemView.findViewById(R.id.dataVal);

        }
    }

    private final LayoutInflater mInflater;
    private List<SampleLocationModel> mWords; // Cached copy of words

    LocationListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {

        Log.d(TAG,"Bind_View_Item" + mWords.get(position).getData());
        if (mWords != null) {
            SampleLocationModel sampleLocationModel = mWords.get(position);
            holder.timeStampValue.setText(mWords.get(position).getTimestamp());
            holder.dataVal.setText(mWords.get(position).getData());
        } else {
            // Covers the case of data not being ready yet.
            holder.timeStampValue.setText("No Word");
        }
    }

    void setWords(List<SampleLocationModel> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }
}
