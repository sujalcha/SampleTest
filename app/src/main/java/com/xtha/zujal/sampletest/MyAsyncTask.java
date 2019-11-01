package com.xtha.zujal.sampletest;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAsyncTask extends AsyncTask<String, String, String> {

    // you may separate this or combined to caller class.

    public GetInfoCallback delegate = null;

    public MyAsyncTask(GetInfoCallback delegate){
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        String getuserlink = "https://jsonplaceholder.typicode.com/users";

        if(type.equals("getusers"))
        {
            try {
                URL url = new URL(getuserlink);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                }

                Log.i("buffer",buffer.toString());
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processingFinish(result);
    }
}
