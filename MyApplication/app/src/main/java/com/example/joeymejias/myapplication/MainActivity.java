package com.example.joeymejias.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BaseAdapter mItemAdapter;
    ListView listView;
    ArrayList<Items> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use helper method to add items to the list
        mItemList = (ArrayList<Items>) generateItems();

        mItemAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mItemList.size();
            }

            @Override
            public Object getItem(int position) {
                return mItemList.get(position);
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
                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(android.R.layout.simple_list_item_2,null);
                }

                TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
                textView1.setText(mItemList.get(position).getPrice());
                TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
                textView2.setText(mItemList.get(position).getBread());

                mItemList.get(position).getDetails();

                return view;
            }
        };

        listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(mItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ItemDetails.class);
                intent.putExtra("Item Name",mItemList.get(position).getBread());
                intent.putExtra("Item Price",mItemList.get(position).getPrice());
                intent.putExtra("Item Details",mItemList.get(position).getDetails());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Intent intent = new Intent(MainActivity.this,Cart.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Items> generateItems(){
        List<Items> items = new ArrayList<>();

        items.add(new Items("$30","Bara Brith ", "Fruited bread from Wales of which there are many varieties, some made with yeast and others baking powder. Traditionally eaten sliced and buttered."));
        items.add(new Items("$30","Barrel ", "Usually made with a milk bread dough, baked in a ridged mould. Also known as a pistol."));
        items.add(new Items("$30","Batch ", "Loaf baked in a batch with others, rather than separately, wholemeal."));
        items.add(new Items("$30","Bloomer ", "Thick, long, white loaf, lightly cut across the top so that the cuts open out or ‘bloom’ to give a crisp crust. Sometimes sprinkled with poppy seeds."));
        items.add(new Items("$30","Buttery Rowies ", "Traditional Aberdeen butter yeast rolls. Shaped in a round or oval with a crisp crust and light flaky texture."));
        items.add(new Items("$30","Coburg ", "Round, crusty white loaf with a deeply cut cross on the top."));
        items.add(new Items("$30","Cornish Splits ", "Sweet, light yeasted buns enriched with butter and milk. Also called Devonshire splits. Often dusted with icing sugar and traditionally eaten filled with jam and clotted cream."));
        items.add(new Items("$30","Cottage ", "White loaf made from two round pieces of dough. One (smaller than the other) is secured on top of the larger piece. Often dusted with flour before baking."));
        items.add(new Items("$30","Farmhouse ", "White loaf baked in a special tin and cut lengthwise along the top, often dusted with flour."));
        items.add(new Items("$30","Plait ", "A special shape, usually plaited with three strands of white dough, sometimes enriched with eggs or milk."));

        return items;
    }

}
