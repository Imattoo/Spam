package com.example.bnb.spam.ui;

//import com.snagapp.android.R;
//import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bnb.spam.R;

public class HomeActivity extends AppCompatActivity {

    HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeFragment = new HomeFragment();
        //getSupportActionBar().setTitle("Snagged");
    }

    @Override
    public void onResume() {
        super.onResume();
        // Execute pending fragments before checking isAdded
        getSupportFragmentManager().executePendingTransactions();

        if (!mHomeFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_frame, mHomeFragment).commit();
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i = new Intent(this, HomeActivity.class);
        if (id == R.id.action_new) {
            //i = new Intent(this, PostActivity.class);
        } else if (id == R.id.action_rate) {
            //i = new Intent(this, AccountActivity.class);
        } else if (id == R.id.action_about) {
            i = new Intent(this, MainAct.class);
        }
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }*/

    public void onDestroy() {
        super.onDestroy();
    }

}