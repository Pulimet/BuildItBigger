package net.alexandroid.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class JokeShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_show);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(Intent.EXTRA_TEXT)) {
            Toast.makeText(this, bundle.getString(Intent.EXTRA_TEXT, getString(R.string.error)), Toast.LENGTH_SHORT).show();
        }
    }
}
