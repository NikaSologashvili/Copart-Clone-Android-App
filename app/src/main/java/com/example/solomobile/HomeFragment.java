package com.example.solomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.solomobile.data.model.Car;
import com.example.solomobile.data.ui.CarAuctionAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView featuredAuctionsRecyclerView;
    private CarAuctionAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        featuredAuctionsRecyclerView = view.findViewById(R.id.featuredAuctionsRecyclerView);
        featuredAuctionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<Car> dummyCars = new ArrayList<>();

        dummyCars.add(new Car("2020 Honda Civic", "$12,500", "2d 10h", R.drawable.cicvi_front));
        dummyCars.add(new Car("2017 Ford F-150", "$21,000", "5d 03h", R.drawable.ford_front));
        dummyCars.add(new Car("2019 Tesla Model 3", "$30,000", "0d 23h", R.drawable.tesla_front));
        dummyCars.add(new Car("2015 Jeep Renegade", "$11,200", "10d 01h", R.drawable.jeep_two));
        dummyCars.add(new Car("2015 BMW M 3", "$34,000", "4d 20h", R.drawable.bmw_m3));
        dummyCars.add(new Car("2018 Toyota Camry", "$16,500", "3d 05h", R.drawable.camry));
        adapter = new CarAuctionAdapter(dummyCars, new CarAuctionAdapter.OnItemClickListener() {
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
        featuredAuctionsRecyclerView.setAdapter(adapter);

        return view;
    }
}