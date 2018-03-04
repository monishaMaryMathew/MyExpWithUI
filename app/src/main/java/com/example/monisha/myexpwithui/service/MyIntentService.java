package com.example.monisha.myexpwithui.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.example.monisha.myexpwithui.util.Constants;

/**
 * Created by Monisha on 2/7/2018.
 */

//class needs to extend IntentService class
public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("DefaultCall");
    }

    //Default constructor with string parameter mandatory
    public MyIntentService(String serviceName) {
        super(serviceName);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //The intent decides the nature of thee work that needs to be done
        //How do we do that
        //by extracting the data string
        //String dataString = intent.getDataString(); // used to fetch the URI where you can find the latest data, say a file location etc
        String extraString = intent.getStringExtra(Constants.EXTRA_DATA);
        createIntentAndBroadcast(extraString);
        switch (/*dataString*/extraString){
            //add cases for the data string and decide what kind of work needs to be done
            default:
                break;
        }
    }
    //There is no needs to override the other callbacks of a Service, such as onStartCommand(). They are automatically invoked by the IntentService
    //In an IntentSerive you should avoid overriding these callbacks

    public void createIntentAndBroadcast(String string){
        Intent intent = new Intent(Constants.BROADCAST_ACTION)
                .putExtra(Constants.EXTENDED_DATA_STATUS, "some status")
                .putExtra(Constants.EXTRA_DATA, string);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
