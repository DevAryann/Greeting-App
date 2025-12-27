package com.example.yourapp; // Ensure this matches your package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.yourapp.databinding.ActivityMainBinding; 

public class MainActivity extends AppCompatActivity {

    // View Binding replaces individual View declarations
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        EdgeToEdge.enable(this);
        
        // Handle Insets using the binding object
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupListeners();
    }

    private void setupListeners() {
        binding.mybtn.setOnClickListener(v -> {
            String input = binding.edittext.getText().toString().trim();

            if (input.isEmpty()) {
                binding.edittext.setError("Name is required!");
            } else {
                // Change the Title text dynamically
                binding.wlc.setText("Hello, " + input + "!");
                
                // Show the Toast
                Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show();
                
                // Clear the focus and hide keyboard for a better UX
                binding.edittext.clearFocus();
            }
        });
    }
}
