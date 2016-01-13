package net.alexandroid.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeShowFragment extends Fragment {

    public JokeShowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke_show, container, false);
        TextView tvJoke = (TextView) root.findViewById(R.id.tv_joke);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null && bundle.containsKey(Intent.EXTRA_TEXT)) {
            String joke = bundle.getString(Intent.EXTRA_TEXT, getString(R.string.error));
            tvJoke.setText(joke);
        } else {
            tvJoke.setText(getString(R.string.error));
        }

        return root;
    }
}