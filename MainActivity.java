package com.whatsapp.dm2.whatsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private Menu menu;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Llamadas", ContextCompat.getDrawable(this, android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Chats", ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Contactos", ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(1);

        cargarVista2();

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override

            public void onTabChanged(String tabId) {

                if(tabId.equalsIgnoreCase("mitab1")){
                    menu.getItem(2).setIcon(getResources().getDrawable(R.drawable.abc_btn_rating_star_off_mtrl_alpha));

                }else if(tabId.equalsIgnoreCase("mitab2")){
                    menu.getItem(2).setIcon(getResources().getDrawable(R.drawable.abc_ic_menu_paste_mtrl_am_alpha));

                }else if(tabId.equalsIgnoreCase("mitab3")){
                    menu.getItem(2).setIcon(getResources().getDrawable(R.drawable.phone));
                }
            }
        });


    }

    public void llamar(String tel){
        try{
            Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+tel));
            startActivity(i);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void cargarVista2() {

        lv = (ListView) findViewById(R.id.listView);

        ArrayList<Item> items = obtenerItems();

        ItemAdapter adapter = new ItemAdapter(this, items);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int posicion, long arg3) {
                Toast.makeText(MainActivity.this, "siiiiiiii", Toast.LENGTH_SHORT).show();
                llamar("677675104");
            }
        });
    }
    private ArrayList<Item> obtenerItems() {
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(1, "Iñaki Zurdo", "10:45 PM", "drawable/cara"));
        items.add(new Item(2, "Manoli Mantas", "03:45 AM", "drawable/cara"));
        items.add(new Item(3, "David Manteiga", "07:05 PM", "drawable/cara"));
        items.add(new Item(4, "El charlie", "12:15 AM", "drawable/cara"));
        items.add(new Item(5, "Abuela", "08:23 PM", "drawable/cara"));
        items.add(new Item(6, "Milagros Maria", "10:44 AM", "drawable/cara"));
        items.add(new Item(7, "Jorge Perez", "01:03 PM", "drawable/cara"));
        items.add(new Item(1, "Iñaki Zurdo", "10:45 PM", "drawable/cara"));
        items.add(new Item(2, "Manoli Mantas", "03:45 AM", "drawable/cara"));
        items.add(new Item(3, "David Manteiga", "07:05 PM", "drawable/cara"));
        items.add(new Item(4, "El charlie", "12:15 AM", "drawable/cara"));
        items.add(new Item(5, "Abuela", "08:23 PM", "drawable/cara"));
        items.add(new Item(6, "Milagros Maria", "10:44 AM", "drawable/cara"));
        items.add(new Item(7, "Jorge Perez", "01:03 PM", "drawable/cara"));

        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
