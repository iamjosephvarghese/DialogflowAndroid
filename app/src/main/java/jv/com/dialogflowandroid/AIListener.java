package jv.com.dialogflowandroid;

import ai.api.model.AIError;
import ai.api.model.AIResponse;

/**
 * Created by josephvarghese on 07/04/18.
 */

public interface AIListener {
    void onResult(AIResponse); // here process response
    void onError(AIError error); // here process error
    void onAudioLevel(float level); // callback for sound level visualization
    void onListeningStarted(); // indicate start listening here
    void onListeningCanceled(); // indicate stop listening here
    void onListeningFinished(); // indicate stop listening here
}