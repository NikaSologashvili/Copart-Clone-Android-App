package com.example.solomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class AddCarFragment extends Fragment {

    private EditText makeEditText, modelEditText, yearEditText, damageDescriptionEditText, startingBidEditText;
    private Button uploadImagesButton, listCarButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_car, container, false);

        makeEditText = view.findViewById(R.id.makeEditText);
        modelEditText = view.findViewById(R.id.modelEditText);
        yearEditText = view.findViewById(R.id.yearEditText);
        damageDescriptionEditText = view.findViewById(R.id.damageDescriptionEditText);
        startingBidEditText = view.findViewById(R.id.startingBidEditText);
        uploadImagesButton = view.findViewById(R.id.uploadImagesButton);
        listCarButton = view.findViewById(R.id.listCarButton);

        uploadImagesButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Image upload functionality Not Working For Now.", Toast.LENGTH_SHORT).show();
        });

        listCarButton.setOnClickListener(v -> {
            String make = makeEditText.getText().toString();
            String model = modelEditText.getText().toString();
            String year = yearEditText.getText().toString();
            String damage = damageDescriptionEditText.getText().toString();
            String bid = startingBidEditText.getText().toString();

            if (make.isEmpty() || model.isEmpty() || year.isEmpty() || damage.isEmpty() || bid.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Car '" + make + " " + model + "' listed for auction!", Toast.LENGTH_LONG).show();
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new HomeFragment())
                            .commit();
                    ((MainActivity) getActivity()).bottomNavigationView.setSelectedItemId(R.id.nav_home);
                }
            }
        });

        return view;
    }
}