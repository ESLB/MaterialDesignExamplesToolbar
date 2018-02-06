package com.pruebas.elsve.materialdesignexamples;

import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.pruebas.elsve.materialdesignexamples.Drawer.DrawerFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Hola");
        toolbar.setSubtitle("Cómo estás?");
        setUpDrawer();
        //Compatibility by Java

//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
//            toolbar.setElevation(10f);
//        }

//        toolbar.setLogo(R.drawable.ic_action_name);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);


        //En el caso de que quisieramos utilizar el toolbar no como ActionBar sino como StandAlone tendrías que eliminar los Override Methods
        //Y usar las siguientes funciones:
//        toolbar.setTitle()
//        toolbar.setSubtitle();
//        toolbar.inflateMenu(R.menu.menu_main);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                String msg = "";
//                switch (item.getItemId()){
//                    case R.id.discard:
//                        msg = "Delete";
//                        break;
//                    case R.id.settings:
//                        msg = "Settings";
//                        break;
//                }
//
//                Toast.makeText(MainActivity.this, msg +" clicked!", Toast.LENGTH_SHORT).show();
//
//                return true;
//            }
//        });
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void setUpDrawer() {
        DrawerFragment drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerFragment.setUpDrawer(R.id.drawer_fragment, drawerLayout, toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msg = "";

        switch (item.getItemId()){
            case R.id.discard:
                msg = "Delete";
                break;
            case R.id.settings:
                msg = "Settings";
                break;
        }

        Toast.makeText(this, msg +" clicked!", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
