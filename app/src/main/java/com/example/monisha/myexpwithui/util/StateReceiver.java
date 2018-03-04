package com.example.monisha.myexpwithui.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Monisha on 2/7/2018.
 */

public class StateReceiver extends BroadcastReceiver {

    public StateReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String stateValue = intent.getStringExtra(Constants.EXTENDED_DATA_STATUS);
        String extraValue = intent.getStringExtra(Constants.EXTRA_DATA);
        Toast.makeText(context, "just received : " +action +","+ stateValue + "," + extraValue, Toast.LENGTH_LONG).show();
    }
}
