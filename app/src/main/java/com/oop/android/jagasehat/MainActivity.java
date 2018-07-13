package com.oop.android.jagasehat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.onesignal.OneSignal;
import com.oop.android.jagasehat.fragment.FragmentContact;
import com.oop.android.jagasehat.fragment.FragmentAbout;
import com.oop.android.jagasehat.fragment.FragmentMateri;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OneSignal.startInit(this).setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
                .init();
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final TapTargetSequence sequence = new TapTargetSequence(this)
                .targets(
                        TapTarget.forView(findViewById(R.id.navigation_materi), "Materi", "Tap disini untuk melihat daftar materi")
                                .dimColor(android.R.color.black)
                                .outerCircleColor(R.color.color2)
                                .targetCircleColor(R.color.color3)
                                .textColor(R.color.color1),
                        TapTarget.forView(findViewById(R.id.navigation_contact), "Contact", "Tap disini untuk melihat daftar kontak")
                                .dimColor(android.R.color.black)
                                .outerCircleColor(R.color.color2)
                                .targetCircleColor(R.color.color3)
                                .textColor(R.color.color1),
                        TapTarget.forView(findViewById(R.id.navigation_about), "About", "Tap disini untuk melihat deskripsi aplikasi")
                                .dimColor(android.R.color.black)
                                .outerCircleColor(R.color.color2)
                                .targetCircleColor(R.color.color3)
                                .textColor(R.color.color1));

        loadFragment(new FragmentMateri());
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun)
            sequence.start();
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
        //sequence.start();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_materi:
                    fragment = new FragmentMateri();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_about:
                    fragment = new FragmentAbout();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_contact:
                    fragment = new FragmentContact();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getSupportFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            //transaction.addToBackStack(backStateName);
            transaction.commit();
        }
    }

    private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        @Override
        public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {
            try {
                if (additionalData != null) {
                    if (additionalData.has("actionSelected"))
                        Log.d("OneSignalExample", "OneSignal notification button with id " + additionalData.getString("actionSelected") + " pressed");

                    Log.d("OneSignalExample", "Full additionalData:\n" + additionalData.toString());
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }


}
