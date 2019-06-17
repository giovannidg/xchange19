package it.openreply.xchange19;

public class Step3 {

    /*

    //BUILD GRADLE
    apply plugin: 'com.android.application'

    repositories {
        maven { url "https://jitpack.io" }
    }

    implementation 'com.github.SandroMachado:openalpr-android:1.1.2'
    implementation 'com.fasterxml.jackson.core:jackson-core:2.9.5'
    implementation 'com.fasterxml.jackson.core:jackson-annotations:2.9.5'
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.9.5'

    //FILE DI CONFIGURAZIONE DENTRO ASSETS OPENALPR.CONF






    //MAIN ACTIVITY

    //HEADER

    //Plate recognition
    static final String ANDROID_DATA_DIR = "/data/data/it.openreply.xchange19";
    final String openAlprConfFile = ANDROID_DATA_DIR + File.separatorChar + "runtime_data" + File.separatorChar + "openalpr.conf";
    //Plate number  filter
    private String regexTarga = "[a-zA-Z]{2}[0-9]{3}[a-zA-Z]{2}";

    //nell'ohPhotoReady

    private void onPhotoReady(Bitmap bitmap) {
        // SHOW BITMAP WITH A SCREEN
        //RECOGNIZE NUMBER PLATE
        File file = new File(ImageHelper.IMAGE_PATH, ImageHelper.IMAGE_NAME);
        if (file != null) {
            OpenALPR alpr = OpenALPR.Factory.create(MainActivity.this, ANDROID_DATA_DIR);
            String result = alpr.recognizeWithCountryRegionNConfig("eu", "it", file.getAbsolutePath(), openAlprConfFile, 10);
            Log.e("RESULT", "result: " + result);
            if (!TextUtils.isEmpty(result)) {
                parseResultAndGetPlate(result);
            }
        }
    }


    @NonNull
    private String parseResultAndGetPlate(String result) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Results results = mapper.readValue(result, Results.class);
            for (Candidate candidate : results.getResults().get(0).getCandidates()) {
                if (candidate.getPlate().matches(regexTarga)) {
                    Log.d(LOG_TAG, "plate: " + candidate.getPlate());
                    return candidate.getPlate();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

*/
}
