package br.com.galaxyware.myapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.navigationView) BottomNavigationView navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationBar.setOnNavigationItemSelectedListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.menu_config);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_academia: {
                Fragment gym = GymFragment.newInstace();
                openFragment(gym);
                break;
            }
            case R.id.navigation_compras: {
                Fragment compras = ComprasFragment.newInstace();
                openFragment(compras);
                break;
            }
            case R.id.navigation_tarefas: {
                Fragment gym = GymFragment.newInstace();
                openFragment(gym);
                break;
            }
            case R.id.navigation_metas: {
                Fragment gym = GymFragment.newInstace();
                openFragment(gym);
                break;
            }
        }
        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
