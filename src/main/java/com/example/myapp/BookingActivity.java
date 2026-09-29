package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    TextView tvCarName;
    TextView tvPrice;

    EditText etDays;

    Button btnConfirm;

    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);

        tvCarName = findViewById(R.id.tvCarName);
        tvPrice = findViewById(R.id.tvPrice);

        etDays = findViewById(R.id.etDays);

        btnConfirm = findViewById(R.id.btnConfirm);


        // ==============================
        // RECEVOIR LE BUNDLE
        // ==============================

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("car_data");

        if (bundle != null) {

            String carName = bundle.getString(
                    "car_name",
                    ""
            );

            price = bundle.getInt(
                    "car_price",
                    0
            );

            tvCarName.setText(carName);

            tvPrice.setText(
                    price + " TND / day"
            );
        }


        // ==============================
        // CONFIRM BOOKING
        // ==============================

        btnConfirm.setOnClickListener(v -> {

            String daysText =
                    etDays.getText().toString().trim();


            if (daysText.isEmpty()) {

                Toast.makeText(
                        this,
                        "Enter number of days",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            int days = Integer.parseInt(daysText);

            int total = days * price;


            Toast.makeText(
                    this,
                    "Booking confirmed! Total: "
                            + total + " TND",
                    Toast.LENGTH_LONG
            ).show();
        });
    }
}