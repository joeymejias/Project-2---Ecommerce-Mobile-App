package com.example.joeymejias.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    public static ListView listView;

    public static BaseAdapter mItemAdapter;

    public static ArrayList<String> mCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mCartList = getCartList();

        mItemAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mCartList.size();
            }

            @Override
            public Object getItem(int position) {
                return mCartList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View view = convertView;
                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) Cart.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(android.R.layout.simple_list_item_1,null);
                }

                TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
                textView1.setText(mCartList.get(position));

                mCartList.get(position);

                return view;
            }
        };

        listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(mItemAdapter);
    }

    public static ArrayList<String> getCartList() {
        return mCartList;
    }

    public static void setCartList(ArrayList<String> mCartList) {


        Cart.mCartList = mCartList;
    }

}
