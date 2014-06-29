package com.example.android.tv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by donaldzhu on 6/25/2014.
 */
public class ContentFragment extends Fragment {
    private TextView mContentView;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mContentView.setText(getArguments().getCharSequence("key", "default"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);
        mContentView = (TextView)view.findViewById(R.id.content);
        return view;
    }

    public void display(CharSequence content) {
       mContentView.setText(content);
    }
}
