package com.example.joeymejias.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by joey on 7/29/16.
 */
public class ItemDetails extends AppCompatActivity {
    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        final Intent intent = getIntent();

        final String price = intent.getStringExtra("Item Price");
        final String name = intent.getStringExtra("Item Name");
        String details = intent.getStringExtra("Item Details");

        mTextView1 = (TextView) findViewById(R.id.itemName);
        mTextView2 = (TextView) findViewById(R.id.itemPrice);
        mTextView3 = (TextView) findViewById(R.id.itemDetails);

        mTextView1.setText(name);
        mTextView2.setText(price);
        mTextView3.setText(details);

        final Button button = (Button) findViewById(R.id.goBack);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),MainActivity.class));

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added " + mTextView2.getText() + "to your cart!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
