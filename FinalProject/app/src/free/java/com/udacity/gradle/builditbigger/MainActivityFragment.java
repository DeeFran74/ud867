package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        // Set listener on button to display Toast advising user to upgrade to paid
        Button tellJokeButton = (Button) root.findViewById(R.id.tellJokeButton);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            Toast fragmentToast = null;
            @Override
            public void onClick(View view) {
                if (fragmentToast != null) {
                    fragmentToast.cancel();
                }
                fragmentToast =
                        Toast.makeText(MainActivityFragment.this.getContext(), "Upgrade to paid version for jokes!", Toast.LENGTH_SHORT);
                fragmentToast.show();
            }
        });

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    public void tellJoke(View view) {
        Toast.makeText(this.getContext(), "Please upgrade to paid version to see joke!", Toast.LENGTH_SHORT).show();
    }
}
