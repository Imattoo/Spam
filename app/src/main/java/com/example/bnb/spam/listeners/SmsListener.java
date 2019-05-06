package com.example.bnb.spam.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.example.bnb.spam.Classifier;

//import android.content.Intent;

public class SmsListener extends BroadcastReceiver{

   // private mainactiv MainActivity;

    @Override
    public void onReceive(Context context, Intent intent) {

    	Log.e("DEBUG", "New SMS");
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
        	Log.e("DEBUG", "Correct Intent");
            Bundle bundle = intent.getExtras();
            SmsMessage [] msgs = null;
            String msgFrom;
            String msgBody;

            if (bundle != null) {
                try {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for (int i = 0; i < msgs.length; i++) {
                        msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        msgFrom = msgs[i].getOriginatingAddress();
                        msgBody = msgs[i].getMessageBody();

                        // If spam,
                        Log.e("DEBUG", "From: " + msgFrom);
                        Log.e("DEBUG", "Body: " + msgBody);

                        Classifier snag = new Classifier(context);
                        if (snag.isSpam(msgFrom + " " + msgBody)) {
                            Log.e("DEBUG", "Is spam");
                            abortBroadcast();
                            // Add to db
                            snag.addSpamSMS(msgFrom, msgBody);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    	
    }

    private void startActivity(Intent intenti) {
    }


}
