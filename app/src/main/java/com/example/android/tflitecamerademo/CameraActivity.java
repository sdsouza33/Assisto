/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends AppCompatActivity {

  static TextToSpeech t1;
  Button b1;
  //int status;
  boolean oninit = true;




  public void setUpTTS(){

    //new change
    t1 = new TextToSpeech(getApplicationContext(),
            new TextToSpeech.OnInitListener() {
              @Override
              public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS) {
                  oninit = true;
                  /*
                  if(t1.isLanguageAvailable(Locale.ENGLISH)==TextToSpeech.LANG_AVAILABLE){
                    t1.setLanguage(Locale.ENGLISH);
                  }
                  */
                  Locale l = Locale.getDefault();
                  //int result = t1.isLanguageAvailable(l);
                  //if(result == TextToSpeech.LANG_AVAILABLE
                  //        || result==TextToSpeech.LANG_COUNTRY_AVAILABLE
                  //        || result==TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE){
                  t1.setLanguage(l);
                  //}

                }
                else{
                  Toast.makeText(getApplicationContext(),"ERROR",
                          Toast.LENGTH_SHORT).show();
                }


              }
            });

    /*
    b1 = (Button)findViewById(R.id.btn_speak);

    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //TextView textV = (TextView) view.findViewById(R.id.text);
        //String toSpeak = textV.getText().toString();
        //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        //t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, "s");
        Toast.makeText(getApplicationContext(),
                "Hello, my name is TFLite",
                Toast.LENGTH_SHORT
                ).show();
      }
    });
    */
    //new change
  }







  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);

    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitleTextColor(getResources().getColor(R.color.toolbarText));

    setUpTTS();
    /*
    while (i < 1000) {
      Log.d("onInit", "Still false");
      setUpTTS();
      i++;
    }
*/

    if (null == savedInstanceState) {
      getFragmentManager()
              .beginTransaction()
              .replace(R.id.container, Camera2BasicFragment.newInstance())
              .commit();

    }
  }



  @Override
  protected void onResume() {
    super.onResume();
    setUpTTS();
  }

  protected void onPause(){
    super.onPause();
    t1.stop();
    t1.shutdown();

  }
  protected void onDestroy(){
    super.onDestroy();
    t1.stop();
    t1.shutdown();
  }


}





















