package com.example.solomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.solomobile.data.model.Car;
import com.example.solomobile.data.ui.CarAuctionAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyBidsWatchlistFragment extends Fragment {

    private RadioGroup bidWatchlistToggle;
    private RadioButton myBidsRadioButton, watchlistRadioButton;
    private RecyclerView myBidsWatchlistRecyclerView;
    private CarAuctionAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_bids_watchlist, container, false);

        bidWatchlistToggle = view.findViewById(R.id.bidWatchlistToggle);
        myBidsRadioButton = view.findViewById(R.id.myBidsRadioButton);
        watchlistRadioButton = view.findViewById(R.id.watchlistRadioButton);
        myBidsWatchlistRecyclerView = view.findViewById(R.id.myBidsWatchlistRecyclerView);
        myBidsWatchlistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Car> myBidsCars = new ArrayList<>();
        myBidsCars.add(new Car("2016 Mercedes-Benz C-Class", "$18,000", "0d 02h (Losing)", R.drawable.mercedes_front));
        myBidsCars.add(new Car("2020 Honda Civic", "$12,600", "2d 09h (Winning)", R.drawable.cicvi_front)); // Corrected typo here, assuming it was cicvi_front

        List<Car> watchlistCars = new ArrayList<>();
        watchlistCars.add(new Car("2019 Tesla Model 3", "$30,000", "0d 23h", R.drawable.tesla_front));
        watchlistCars.add(new Car("2010 Jeep Wrangler", "$7,000", "9d 01h", R.drawable.jeep_front));

        adapter = new CarAuctionAdapter(myBidsCars, new CarAuctionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Car car) {
                if (getActivity() != null) {
                    CarDetailFragment detailFragment = new CarDetailFragment();
                    Bundle args = new Bundle();
                    args.putString("carTitle", car.getTitle());
                    args.putString("currentBid", car.getCurrentBid());
                    args.putString("timeRemaining", car.getTimeRemaining());
                    args.putInt("carImageResId", car.getImageResId());
                    detailFragment.setArguments(args);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, detailFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        myBidsWatchlistRecyclerView.setAdapter(adapter);

        bidWatchlistToggle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.myBidsRadioButton) {
                    adapter.updateData(myBidsCars);
                    Toast.makeText(getContext(), "Showing My Bids", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.watchlistRadioButton) {
                    adapter.updateData(watchlistCars);
                    Toast.makeText(getContext(), "Showing Watchlist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}