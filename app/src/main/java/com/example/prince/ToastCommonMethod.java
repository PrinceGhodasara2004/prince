package com.example.prince;

import android.content.Context;
import android.widget.Toast;

public class ToastCommonMethod {

    ToastCommonMethod(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
