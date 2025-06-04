package com.example.solomobile.data.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView; // Make sure ImageView is imported
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.solomobile.R; // Make sure this R is correctly imported
import com.example.solomobile.data.model.Car; // Import your Car model class

import java.util.List;

public class CarAuctionAdapter extends RecyclerView.Adapter<CarAuctionAdapter.CarViewHolder> {

    private List<Car> carList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Car car);
    }

    public CarAuctionAdapter(List<Car> carList, OnItemClickListener listener) {
        this.carList = carList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_auction_preview, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.bind(car, listener);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public void updateData(List<Car> newCarList) {
        this.carList = newCarList;
        notifyDataSetChanged();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView carThumbnail;
        TextView carTitle;
        TextView currentBid;
        TextView timeRemaining;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carThumbnail = itemView.findViewById(R.id.carThumbnail);
            carTitle = itemView.findViewById(R.id.carTitle);
            currentBid = itemView.findViewById(R.id.currentBid);
            timeRemaining = itemView.findViewById(R.id.timeRemaining);
        }

        public void bind(final Car car, final OnItemClickListener listener) {
            carTitle.setText(car.getTitle());
            currentBid.setText("Current Bid: " + car.getCurrentBid());
            timeRemaining.setText("Time Left: " + car.getTimeRemaining());

            // Set the image resource using the ID from the Car object
            // R.drawable.your_image_name
            carThumbnail.setImageResource(car.getImageResId()); // <--- This is the key line
            // carThumbnail.setImageResource(R.drawable.ic_launcher_background); // Remove this placeholder if it's still there

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(car);
                    }
                }
            });
        }
    }
}