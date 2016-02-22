package com.placeholder.fragmentsissue;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAOnClickListener {
    public static final String FRAGMENT_A = "fragment_a";
    public static final String FRAGMENT_B = "fragment_b";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getFragmentManager();
        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag(FRAGMENT_A);

        if (fragmentA == null) {
            fragmentA = new FragmentA();
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.add(R.id.placeholder, fragmentA);
            transaction.commit();
        }
    }

    @Override
    public void onFragmentAClicked() {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.placeholder, fragmentB);
        transaction.addToBackStack(FRAGMENT_B);
        transaction.commit();
    }
}
