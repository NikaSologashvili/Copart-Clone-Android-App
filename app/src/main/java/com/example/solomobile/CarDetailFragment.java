package com.example.solomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class CarDetailFragment extends Fragment {

    private ImageView carImageView;
    private TextView carTitleTextView, currentBidLabel, currentBidValue, timeRemainingLabel, timeRemainingValue, descriptionLabel, descriptionContent;
    private EditText bidAmountEditText;
    private Button placeBidButton, addToWatchlistButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_detail, container, false);

        // Initialize views
        carImageView = view.findViewById(R.id.carImageView);
        carTitleTextView = view.findViewById(R.id.carTitleTextView);
        currentBidLabel = view.findViewById(R.id.currentBidLabel);
        currentBidValue = view.findViewById(R.id.currentBidValue);
        timeRemainingLabel = view.findViewById(R.id.timeRemainingLabel);
        timeRemainingValue = view.findViewById(R.id.timeRemainingValue);
        descriptionLabel = view.findViewById(R.id.descriptionLabel);
        descriptionContent = view.findViewById(R.id.descriptionContent);
        bidAmountEditText = view.findViewById(R.id.bidAmountEditText);
        placeBidButton = view.findViewById(R.id.placeBidButton);
        addToWatchlistButton = view.findViewById(R.id.addToWatchlistButton);

        Bundle args = getArguments();
        if (args != null) {
            String carTitle = args.getString("carTitle");
            String currentBid = args.getString("currentBid");
            String timeRemaining = args.getString("timeRemaining");
            int carImageResId = args.getInt("carImageResId", 0);

            if (carTitle != null) carTitleTextView.setText(carTitle);
            if (currentBid != null) currentBidValue.setText(currentBid);
            if (timeRemaining != null) timeRemainingValue.setText(timeRemaining);

            if (carImageResId != 0) {
                carImageView.setImageResource(carImageResId);
            } else {
            }



        } else {
            Toast.makeText(getContext(), "No car details available.", Toast.LENGTH_SHORT).show();
        }

        placeBidButton.setOnClickListener(v -> {
            String bidAmount = bidAmountEditText.getText().toString();
            if (bidAmount.isEmpty()) {
                Toast.makeText(getContext(), "Please enter a bid amount.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "You placed a bid of $" + bidAmount, Toast.LENGTH_SHORT).show();
            }
        });

        addToWatchlistButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Added to watchlist!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}