package com.xtha.zujal.sampletest;

public class InfoRepository {


    public void getInfo(GetInfoCallback callback) {
        new UserTask(callback).execute("getusers");
    }
}
