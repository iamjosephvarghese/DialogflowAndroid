package jv.com.dialogflowandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.ui.AIButton;

public class MainActivity extends AppCompatActivity {

//    AIConfiguration config = new AIConfiguration("ce6a85a61d7c4ef69b71f80eef0ebfb6",
//            AIConfiguration.SupportedLanguages.English,
//            AIConfiguration.RecognitionEngine.System);

//    AIService aiService = AIService.getService(getApplicationContext(),config).setListener();

    AIButton aiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AIConfiguration config = new AIConfiguration("ce6a85a61d7c4ef69b71f80eef0ebfb6",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);


        aiButton = (AIButton) findViewById(R.id.micButton);
        aiButton.initialize(config);
        aiButton.setResultsListener(new AIButton.AIButtonListener() {
            @Override
            public void onResult(AIResponse result) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                        Log.d("ApiAi", "onResult");
                        // TODO process response here
//                    }
//                });
            }

            @Override
            public void onError(AIError error) {

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                        Log.d("ApiAi", "onError");
                        Log.d("error",error.toString());
                        // TODO process error here
//                    }
//                });
            }

            @Override
            public void onCancelled() {

            }
        });


//        config = new AIConfiguration("ce6a85a61d7c4ef69b71f80eef0ebfb6",
//                AIConfiguration.SupportedLanguages.English,
//                AIConfiguration.RecognitionEngine.System);
    }








}

