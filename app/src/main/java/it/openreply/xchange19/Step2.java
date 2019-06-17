package it.openreply.xchange19;

public class Step2 {

    //BUILD GRADLE
    //implementation 'junit:junit:4.12'
    //implementation 'com.android.support:support-annotations:27.1.0'

    //Permission Manifest
    //<uses-permission android:name="android.permission.CAMERA" />
    //<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

    //HEADER
    //private ImagePreprocessor mImagePreprocessor;
    //private CameraHandler mCameraHandler;
    //private boolean isProcessing;

    //onCreate
    /*
    initCamera();


    onDestroy
    closeCamera();


 //main method


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

    */
}
