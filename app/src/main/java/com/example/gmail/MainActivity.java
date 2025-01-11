package com.example.gmail;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements
        NavigationView.OnNavigationItemSelectedListener {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu);
       NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
	    navView.setNavigationItemSelectedListener(this);


}
    @Override
public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    boolean fragmentTransaction = false;

    Fragment fragment = null;

        switch (menuItem.getTitle().toString()) {
            case "Sección 1":
                fragment = new home();
                fragmentTransaction = true;
                break;
            case "Sección 2":
                fragment = new profile();
                fragmentTransaction = true;
                break;
            case "Sección 3":
                fragment = new settings();
                fragmentTransaction = true;
                break;

        }

    if(fragmentTransaction) {
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.content_frame, fragment)
        .commit();

        menuItem.setChecked(true);
        getSupportActionBar().setTitle(menuItem.getTitle());
    }
    DrawerLayout drawerLayout =(DrawerLayout)
    drawer_Layout.closeDrawers();
    return true;

}

}