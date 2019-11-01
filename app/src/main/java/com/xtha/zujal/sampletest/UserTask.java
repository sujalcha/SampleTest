package com.xtha.zujal.sampletest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import com.xtha.zujal.sampletest.Adapters.UserAdapter;
import com.xtha.zujal.sampletest.Model.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static java.sql.DriverManager.println;

public class UserTask extends AsyncTask<String, String, String> {

    private ProgressDialog dialog;

    private ListView listView;
    private Context context;

//    public UserTask(ListView listView, Context context){
//        this. listView = listView;
//        this.context = context;
//    }

    ArrayList<UserInfo> User;

    private static UserAdapter adapter;

    protected void onPreExecute() {
        super.onPreExecute();
//        dialog = new ProgressDialog(context);
//        dialog.setMessage("Please wait");
//        dialog.setCancelable(false);
//        dialog.show();
    }


    public interface AsyncResponse {
        void processFinish(String output);
    }

//    public interface GetInfoCallback {
//        void processingFinish(String output);
//    }

    public AsyncResponse delegate = null;
    public GetInfoCallback delegate2;

    public UserTask(GetInfoCallback delegate2){
        this.delegate2 = delegate2;
       // this.context = context;
    }


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

               //Log.i("buffer",buffer.toString());
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
        super.onPostExecute(result); {
            //parse JSON data

           // Log.i("result",result);
           // delegate.processFinish(result);
            delegate2.processingFinish(result);


//            if (dialog.isShowing()) {
//                dialog.dismiss();
//            }


        } // protected void onPostExecute(Void v)
    } //class MyAsyncTask extends AsyncTask<St
}