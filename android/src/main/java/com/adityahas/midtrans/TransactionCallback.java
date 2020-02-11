package com.adityahas.midtrans;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;

/**
 * Created by AlSahfer on 23/11/17.
 */

public class TransactionCallback implements TransactionFinishedCallback {

    Callback callback;

    TransactionCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onTransactionFinished(TransactionResult transactionResult) {
        // temporary fix for gopay pending status
        this.callback.invoke(transactionResult);
        if (transactionResult != null && transactionResult.getStatus() != null)
            Log.d("result", transactionResult.getStatus());
    }
}
