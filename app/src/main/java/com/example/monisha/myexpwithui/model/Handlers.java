package com.example.monisha.myexpwithui.model;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Monisha on 2/4/2017.
 */

public class Handlers {
    public void onTextViewClick(View view) {
        Log.d("test", "Handler called");
        Toast.makeText(view.getContext(), "Toasting", Toast.LENGTH_SHORT).show();
    }
}
