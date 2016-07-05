package com.example.guest.weatherapi.adapters;

    import android.content.Context;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import com.example.guest.weatherapi.R;

    import java.util.ArrayList;

    import butterknife.Bind;
    import butterknife.ButterKnife;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>{
    private ArrayList<String> mDescriptions = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<String> descriptions) {
        mContext = context;
        mDescriptions = descriptions;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
    //    holder.bindWeather(mDescriptions.get(position));
    }

    @Override
    public int getItemCount() {
        return mDescriptions.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.cityView) TextView mCityView;

        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(String location) {
            mCityView.setText(location);
        }
    }
}