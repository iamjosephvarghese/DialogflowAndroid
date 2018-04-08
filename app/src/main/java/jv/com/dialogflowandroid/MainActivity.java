package jv.com.dialogflowandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.ui.AIButton;

public class MainActivity extends AppCompatActivity{

//    AIConfiguration config = new AIConfiguration("ce6a85a61d7c4ef69b71f80eef0ebfb6",
//            AIConfiguration.SupportedLanguages.English,
//            AIConfiguration.RecognitionEngine.System);

//    AIService aiService = AIService.getService(getApplicationContext(),config).setListener();

    AIButton aiButton;

    TextView resultTextView;

    private AIService aiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);


        AIConfiguration config = new AIConfiguration("ce6a85a61d7c4ef69b71f80eef0ebfb6",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);


        aiService = AIService.getService(this, config);


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
                        Log.d("result",result.toString());




                // Get parameters
                String parameterString = "";
                if (result.getResult().getParameters() != null && !result.getResult().getParameters().isEmpty()) {
                    for (final Map.Entry<String, JsonElement> entry : result.getResult().getParameters().entrySet()) {
                        parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
                    }
                }

                // Show results in TextView.
                resultTextView.setText("Query:" + result.getResult().getResolvedQuery() +
                        "\nAction: " + result.getResult().getAction() +
                        "\nParameters: " + parameterString);


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

