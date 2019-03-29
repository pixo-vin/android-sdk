## VIN Barcode Scanner SDK for Android ##

###Overview###

The VIN Barcode Scanner Software Development Kit for Android is packaged as an Android Library archive **AndroidScanLib.aar**. The library currently supports the following ABIs: *armeabi, armeabi-v7a, x86, x86_64, arm64-v8a*

To enable barcode scanning in your application you will need to obtain a SDK key. This key is tied to your application through its Package ID. The Package ID is the string, generally in a reverse-DNS format, which identifies your application uniquely in the Google Play store. For example: *com.company-name.application-name*

Contact us at info@pixovin.com to initiate a free trial or commercial license and activate your SDK key.

---

###Getting Started###

To add VIN Barcode scanning to your Android application, follow these 4 simple steps:

1. Include **AndroidScanLib.aar** from this repository in your application project
2. Create an Activity or Fragment
	1. Activities must extend from **com.pixotech.android.scanner.library.ScannerActivity**
	2. Fragments must extend from **com.pixotech.android.scanner.library.ScannerFragment**
3. Implement the **handleDecode** API method to receive scanned VINs
4. Overlay your interface on the camera preview with the **addLayout** API method.

---

####Include AndroidScanLib.aar####

 1. Clone or download this repository
 2. Copy **AndroidScanLib.aar** from <i class="icon-folder">AndroidScanLib/libs</i> into your projects **libs** directory.
  1. The default location in a new Android Studio project would be *Project/app/libs/*
 3. Add **AndroidScanLib.aar** to your project:
  1. <i class="icon-folder">AndroidScanLib</i> contains an example Gradle file **AndroidScanLib.gradle** which needs to be merged with your projects **build.gradle**
  2. Your existing **build.gradle** may not contain a *repositories* section. If not, this section should be added at the root level of the file.

####Create an Activity or Fragment and implement **handleDecode**####

```
import com.pixotech.android.scanner.library.ScannerActivity;

public class ScanActivity extends ScannerActivity {
    @Override
    public void handleDecode(String result) {
		// do something with the result
	}
}
```

**ScannerActivity** extends directly from ***android.app.Activity***.

####OR####

```
import com.pixotech.android.scanner.library.ScannerFragment;

public class ScanFragment extends ScannerFragment {

    public ScanFragment() {
        // Required public constructor
    }

    @Override
    public void handleDecode(String result) {
        // do something with the result
    }
}
```

For broadest Android compatibility **ScannerFragment** extends from ***android.support.v4.app.Fragment***.

####Overlay your interface layout####

To overlay your own interface layout on top of ScannerActivity or ScannerFragment's camera preview, pass your layout's Resource ID to the **addLayout** API method. This call must be made **after** the call to the superclass's onResume method:

```
@Override
public void onResume() {
    super.onResume();

    addLayout(R.layout.scan_layout);
}
```

The VIN Barcode Scanner SDK provides two simple laser viewfinder Views that can be added to your layout: LaserView and DataMatrixLaserView. The DataMatrixLaserView includes an outline of a square region near the middle of the screen. This region is positioned and sized to optimize recognition of DataMatrix codes. You can add either viewfinder to your layout as a View with one of the custom classes

* *com.pixotech.scanner.library.LaserView*
* *com.pixotech.scanner.library.DataMatrixLaserView*

```
<com.pixotech.android.scanner.library.LaserView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```

---

###Scanner API###

The **ScannerActivity** and **ScannerFragment** classes both provide the following API.

####**handleDecode** - ***required***####

handleDecode is called on your Activity when a value has been successfully read from a barcode. Scanning is stopped immediately before the call to handleDecode to avoid duplicate scans. You may restart the scanning process by calling *startScan*.

```
public abstract void handleDecode(String result);
```

> **result**: A string containing the value read from a barcode

####**setSDKKey** - *deprecated*####

```
@Deprecated
public void setSDKKey(String key);
```

> **key**: A string containing your assigned SDK key

> ***Note:*** *In previous versions of the SDK a call to this method was required. In the latest version this method is deprecated; passing an SDK key to this method has no effect.*

####**setSound**####

Sets a sound resource that will be played when a barcode has been scanned.

```
public void setSound(int sound);
```

> **sound**: The Resource ID of a sound file. e.g.: *R.raw.scan_sound*

####**startScan**####

Starts the barcode scanning process.

```
public void startScan();
```

####**stopScan**####

Stops the barcode scanning process.

```
public void stopScan();
```

####**toggleTorch**####

Turns the torch on/off if the device camera has a flash that may be used as a flashlight. **toggleTorch** may be referenced directly by a Button's onClick property in your layout.

```
public void toggleTorch(View view);
```

####**hasTorch**####

```
public boolean hasTorch();
```

> **returns**: *true* if the flash may be used as a flashlight, otherwise *false*
