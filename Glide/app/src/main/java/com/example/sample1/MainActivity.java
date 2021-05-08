package com.example.sample1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import javax.crypto.spec.IvParameterSpec;

public class MainActivity extends AppCompatActivity {
    String url;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        url = "https://via.placeholder.com/600/92c9512";
        GlideUrl url = new GlideUrl("https://via.placeholder.com/600/92c9512", new LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build());

        Glide.with(this).load(url).into(imageView);

    }
}