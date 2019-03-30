package com.example.bottomandappintro;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.bottomandappintro.databinding.TestLayoutBinding;

import java.util.List;

public class FragmentExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TestLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.fragment_activity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f instanceof ImagePickerFragment) {
                    f.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }
}
