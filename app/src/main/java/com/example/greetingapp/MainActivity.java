package com.example.yourapp;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.yourapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);

        setupListeners();
    }

    private void setupListeners() {
        // Main Button Click
        binding.mybtn.setOnClickListener(v -> {
            String name = binding.edittext.getText().toString().trim();

            if (name.isEmpty()) {
                binding.edittext.setError("Name cannot be empty");
            } else {
                // Update UI with a personalized greeting
                binding.wlc.setText("Nice to meet you, " + name + "!");
                binding.wlc.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
                
                Toast.makeText(this, "Hello " + name, Toast.LENGTH_SHORT).show();
                
                hideKeyboard();
                binding.edittext.setText(""); // Clear input for next use
                binding.edittext.clearFocus();
            }
        });

        // Long Press the button to reset the title
        binding.mybtn.setOnLongClickListener(v -> {
            binding.wlc.setText("Welcome!");
            binding.wlc.setTextColor(getResources().getColor(android.R.color.black));
            Toast.makeText(this, "App Reset", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
