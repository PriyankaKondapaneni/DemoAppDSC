package com.codewithsiri.demoappdsc.ui.aboutUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.codewithsiri.demoappdsc.R;

public class AboutUs extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.about_us_fragment, container, false);
        Button btnLink = root.findViewById(R.id.btnlink);
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myLink = new Intent(Intent.ACTION_VIEW);
                myLink.setData(Uri.parse("https://dscsastra.com"));
                startActivity(myLink);
            }
        });
        return root;
    }
}

