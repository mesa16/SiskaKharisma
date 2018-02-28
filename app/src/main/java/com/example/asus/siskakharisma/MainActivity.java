package com.example.asus.siskakharisma;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentCommunicator {

    private boolean netOk;
    private boolean isDualPane = false;
    private FragmentDetail fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        netOk = NetworkHelper.hasNetworkAccess(this);
        Toast.makeText(this, "Network OK: "+netOk, Toast.LENGTH_LONG).show();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentDetail = (FragmentDetail) fragmentManager.findFragmentById(R.id.fragmentD);
        View fragmentDview = findViewById(R.id.fragmentD);
        isDualPane = fragmentDview != null && fragmentDview.getVisibility() == View.VISIBLE;
    }

    @Override
    public void displayDetail(Mahasiswa mahasiswa) {
        if (isDualPane){
            fragmentDetail.displayData(mahasiswa);
        }else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("mahasiswa", mahasiswa);
            startActivity(intent);
        }
    }

    @Override     public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.menuLogout:finish();
                return true;
            default:return  super.onOptionsItemSelected(item);
        }
    }

}
