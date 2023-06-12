# Capstone Project MBTI App (C23-PS211)

Project Name		: MBTI-EDU: A Personality Identification Application for Improving the Quality of Learning

## Authors

- (ML) M125DKY4715 – Jasmin Nur Hanifa - (Active)
- (ML) M125DKY4697 – Mega Maulina - (Active)
- (CC) C172DSY2213 – Syifa Layla - (Active)
- (CC) C172DSY2614 – Firda Nurul Izza - (Active)
- (MD) A150DSX2099 – Bayu Tantra Bramandhita - (Active)
- (MD) A172DKX4032 – Jafar Nurrizki Mosary - (Active)
## Documentation


### Changing API's URL
API's URL can be changed at**build.properties :** 
![App Screenshot](https://github.com/bayutb123/capstone_mbti/blob/main/Screenshots/change%20api%20url.png)

## Plugins

```kotlin
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-parcelize'
}
```

## Dependencies Used

```kotlin
dependencies {

    // Default Dependencies
    implementation 'androidx.core:core-ktx:1.10.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    // RecyclerView for MBTI Recommendation Lists
    implementation 'androidx.recyclerview:recyclerview:1.3.0'

    // Retrofit for API Connection
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

}
```

## Clone the project
```bash
  git clone https://github.com/bayutb123/capstone_mbti.git
```
#### Launch Android Studio and Open Project **MBTIApp** in the **capstone_mbti** folder

#### Launch using Android Studio Emulator :
- Click **Run App** or press **Shift + F10**

#### Build app to install it on physical device :
- Click **Build** -> **Build Bundle(s) / APK(s)** -> **Build APK(s)**
- Your exported ***app-debug.apk*** files will be on **capstone_mbti\MBTIApp\app\build\outputs\apk\debug**




