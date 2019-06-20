package it.openreply.xchange19;



import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.GpioCallback;
import com.google.android.things.pio.PeripheralManager;

import org.openalpr.OpenALPR;

import java.io.File;
import java.io.IOException;
import java.util.List;

import it.openreply.xchange19.camera.CameraHandler;
import it.openreply.xchange19.camera.ImageHelper;
import it.openreply.xchange19.camera.ImagePreprocessor;
import it.openreply.xchange19.model.Candidate;
import it.openreply.xchange19.model.Results;

/**
 * Android Things project for Reply Xchange 19
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

    }

}
