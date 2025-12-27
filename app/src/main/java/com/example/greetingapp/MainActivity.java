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

public class MainActivity extends AppCompatActivity {
    
    // Using private access modifiers is better practice
    private EditText editText;
    private Button myButton;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Standard Edge-to-Edge inset handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initializing Views
        editText = findViewById(R.id.edittext);
        myButton = findViewById(R.id.mybtn);
        title = findViewById(R.id.wlc);

        // Using a Lambda expression for a cleaner click listener
        myButton.setOnClickListener(v -> {
            String input = editText.getText().toString().trim();

            if (!input.isEmpty()) {
                Toast.makeText(MainActivity.this, 
                    "Welcome " + input + " to our App", 
                    Toast.LENGTH_SHORT).show();
            } else {
                // Helpful feedback if the field is empty
                editText.setError("Please enter your name");
            }
        });
    }
}
