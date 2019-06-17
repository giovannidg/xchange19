package it.openreply.xchange19;

public class Step1 {

    //Permission Manifest
//    <uses-permission android:name="com.google.android.things.permission.USE_PERIPHERAL_IO"/>
//    <application android:label="@string/app_name"
//      android:theme="@style/Theme.AppCompat.Light">

    //HEADER

//    private Gpio ledGpio;
//    private Gpio buttonGpio;
//    private static String LED_GPIO = "BCM26";
//    private static String BUTTON_GPIO = "BCM4";
//    private static final String LOG_TAG = "XCHANGE19";


    //OnCreate

//    PeripheralManager manager = PeripheralManager.getInstance();
//    List<String> gpios = manager.getGpioList();
//        Log.d(LOG_TAG, gpios.toString());
//
//    setupIO(manager);
//    registerButtonCallback();



//    FOOTER

//    private void setupIO(PeripheralManager manager) {
//        try {
//            ledGpio = manager.openGpio(LED_GPIO);
//
//            ledGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
//
//            buttonGpio = manager.openGpio(BUTTON_GPIO);
//            buttonGpio.setDirection(Gpio.DIRECTION_IN);
//
//            buttonGpio.setActiveType(Gpio.ACTIVE_LOW);
//            buttonGpio.setEdgeTriggerType(Gpio.EDGE_BOTH);
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void registerButtonCallback() {
//        try {
//            buttonGpio.registerGpioCallback(new GpioCallback() {
//                @Override
//                public boolean onGpioEdge(Gpio gpio) {
//                    try {
//                        turnOnLed(gpio.getValue());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    // Continue listening for more interrupts
//                    return true;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void turnOnLed(boolean isOn) {
//        Log.d(LOG_TAG, "isOn" + isOn);
//        if (ledGpio != null) {
//            try {
//                ledGpio.setValue(isOn);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        //Close Led GPIO
//        if (ledGpio != null) {
//            try {
//                ledGpio.close();
//                ledGpio = null;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //Close the obstacle avoidance GPIO
//        if (buttonGpio != null) {
//            try {
//                buttonGpio.close();
//                buttonGpio = null;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        super.onDestroy();
//    }

}
