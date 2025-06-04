package com.example.solomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
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

public class AuctionListFragment extends Fragment {

    private RecyclerView auctionListRecyclerView;
    private CarAuctionAdapter adapter;
    private SearchView searchView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auction_list, container, false);

        searchView = view.findViewById(R.id.searchView);
        auctionListRecyclerView = view.findViewById(R.id.auctionListRecyclerView);
        auctionListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Car> dummyCars = new ArrayList<>();
        dummyCars.add(new Car("2015 BMW 3 Series", "$9,800", "7d 20h", R.drawable.bmw_front));
        dummyCars.add(new Car("2021 Hyundai Elantra", "$15,200", "2d 15h", R.drawable.elantrafront));
        dummyCars.add(new Car("2010 Jeep Wrangler", "$7,000", "9d 01h", R.drawable.jeep_front));
        dummyCars.add(new Car("2018 Toyota Camry", "$12,500", "3d 05h", R.drawable.campry_front));

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
        auctionListRecyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getContext(), "Search for: " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return view;
    }
}