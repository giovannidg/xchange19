package it.openreply.xchange19;

import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.GpioCallback;
import com.google.android.things.pio.PeripheralManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import it.openreply.xchange19.camera.CameraHandler;
import it.openreply.xchange19.camera.ImageHelper;
import it.openreply.xchange19.camera.ImagePreprocessor;

/**
 * Android Things project for Reply Xchange 19
 */
public class MainActivity extends AppCompatActivity {

    private Gpio ledGpio;
    private Gpio buttonGpio;
    private static String LED_GPIO = "BCM26";
    private static String BUTTON_GPIO = "BCM4";
    private static final String LOG_TAG = "XCHANGE19";
    //Camera
    private ImagePreprocessor mImagePreprocessor;
    private CameraHandler mCameraHandler;
    private boolean isProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        PeripheralManager manager = PeripheralManager.getInstance();
        List<String> gpios = manager.getGpioList();
        Log.d(LOG_TAG, gpios.toString());

        setupIO(manager);
        registerButtonCallback();

        initCamera();
    }

    private void setupIO(PeripheralManager manager) {
        try {
            ledGpio = manager.openGpio(LED_GPIO);

            ledGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            buttonGpio = manager.openGpio(BUTTON_GPIO);
            buttonGpio.setDirection(Gpio.DIRECTION_IN);

            buttonGpio.setActiveType(Gpio.ACTIVE_LOW);
            buttonGpio.setEdgeTriggerType(Gpio.EDGE_BOTH);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerButtonCallback() {
        try {
            buttonGpio.registerGpioCallback(new GpioCallback() {
                @Override
                public boolean onGpioEdge(Gpio gpio) {
                    try {
                        turnOnLed(gpio.getValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Continue listening for more interrupts
                    return true;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void turnOnLed(boolean isOn) {
        Log.d(LOG_TAG, "isOn" + isOn);
        if (ledGpio != null) {
            try {
                ledGpio.setValue(isOn);
                loadPhoto();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onDestroy() {
        //Close Led GPIO
        if (ledGpio != null) {
            try {
                ledGpio.close();
                ledGpio = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Close the obstacle avoidance GPIO
        if (buttonGpio != null) {
            try {
                buttonGpio.close();
                buttonGpio = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeCamera();
        super.onDestroy();
    }

    /**
     * Initialize the camera that will be used to capture images.
     */
    private void initCamera() {
        // ADD CAMERA SUPPORT
        mImagePreprocessor = new ImagePreprocessor();
        mCameraHandler = CameraHandler.getInstance();
        Handler threadLooper = new Handler(getMainLooper());

        mCameraHandler.initializeCamera(this, threadLooper,
                new ImageReader.OnImageAvailableListener() {
                    @Override
                    public void onImageAvailable(ImageReader imageReader) {
                        isProcessing = false;
                        Bitmap bitmap = mImagePreprocessor.preprocessImage(imageReader.acquireNextImage());
                        onPhotoReady(bitmap);
                    }
                });
//        CameraHandler.dumpFormatInfo(this);
    }

    private void onPhotoReady(Bitmap bitmap) {
        // SHOW BITMAP WITH A SCREEN
        //RECOGNIZE NUMBER PLATE
        /*File file = new File(ImageHelper.IMAGE_PATH, ImageHelper.IMAGE_NAME);
        if (file != null) {
            OpenALPR alpr = OpenALPR.Factory.create(MainActivity.this, ANDROID_DATA_DIR);
            String result = alpr.recognizeWithCountryRegionNConfig("eu", "it", file.getAbsolutePath(), openAlprConfFile, 10);
            Log.e("RESULT", "result: " + result);
            if (!TextUtils.isEmpty(result)) {
                parseResultAndGetPlate(result);
            }
        }*/
    }

    private void loadPhoto() {
        // ADD CAMERA SUPPORT
        if (!isProcessing) {
            isProcessing = true;
            mCameraHandler.takePicture();
        }
    }

    private void closeCamera(){
        mCameraHandler.shutDown();
    }

}
