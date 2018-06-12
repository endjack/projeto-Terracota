package com.example.ender.terracota;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,new FragmentMain())
                .commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homeItem:
                        FragmentMain fragmentHome = new FragmentMain();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentHome)
                                .commit();
                        break;
                    case R.id.atosItem:
                        FragmentAtos fragmentAtos = new FragmentAtos();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentAtos)
                                .commit();
                        break;
                    case R.id.interacaoItem:
                        FragmentIter fragmentIter = new FragmentIter();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentIter)
                                .commit();
                        break;
                    case R.id.sobreItem:
                        FragmentSobre fragmentSobre = new FragmentSobre();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentSobre)
                                .commit();
                        break;
                }
                return true;
            }
        });

    }
}
