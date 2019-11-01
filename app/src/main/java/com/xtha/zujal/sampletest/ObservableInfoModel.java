package com.xtha.zujal.sampletest;

import android.util.Log;

public class ObservableInfoModel {

    private String output;

    // Constructor
    public ObservableInfoModel(String output) {
        output = output;
    }

    public String getOutput() {
       // Log.i("output3",output);
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
       // Log.i("output2",output);
    }


//    // Getter
//    public InfoModel getValue() {
//        return mInfoModel;
//    }
//
//    // Setter
//    public void setValue(InfoModel infoModel) {
//        mInfoModel = infoModel;
//        notifyObservers();  // notify observers
//    }
}
