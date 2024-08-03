package com.example.videorecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.videorecorder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'videorecorder' library on application startup.
    static {
        System.loadLibrary("videorecorder");
    }

    private ActivityMainBinding binding;
    private Button forward_video_recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        forward_video_recorder = binding.forwardVideoRecorder;
        forward_video_recorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoRecorderActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * A native method that is implemented by the 'videorecorder' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}