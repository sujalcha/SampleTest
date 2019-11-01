package com.xtha.zujal.sampletest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import com.xtha.zujal.sampletest.Adapters.AlbumAdapter;
import com.xtha.zujal.sampletest.Model.AlbumInfo;
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

public class AlbumTask extends AsyncTask<String, String, String> {

    private ProgressDialog dialog;
    private ListView listView;
    private Context context;
    private int userid;
    private TextView album_id;

    public AlbumTask(int userid, ListView listView, TextView album_id,Context context){
        this.userid = userid;
        this. listView = listView;
        this.context = context;
        this.album_id = album_id;
    }

    ArrayList<AlbumInfo> albumList;

    private static AlbumAdapter adapter;

    protected void onPreExecute() {

        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        dialog.show();
    }

    protected String doInBackground(String... params) {

        String type = params[0];

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        String getalbumlink = "https://jsonplaceholder.typicode.com/photos";

        if(type.equals("getalbums"))
        {
            try {
                URL url = new URL(getalbumlink);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                     //   Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
                }
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

            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            //parse JSON data

            albumList = new ArrayList<>();
//            Log.d("Result", result);

            try {
                JSONArray jArray = new JSONArray(result);

                for(int i=0; i < jArray.length(); i++) {

                    JSONObject jObject = jArray.getJSONObject(i);

                    int albumid = jObject.getInt("albumId");
                    int id = jObject.getInt("id");
                    String title = jObject.getString("title");
                    String url = jObject.getString("url");
                    String thumbnailUrl = jObject.getString("thumbnailUrl");

                    if (albumid==userid)
                    {
                        AlbumInfo album = new AlbumInfo(albumid,id,title,url,thumbnailUrl);
                        albumList.add(album);

                        album_id.setText(String.valueOf(albumid));
                    }

                    adapter= new AlbumAdapter(this.context,albumList);
                    listView.setAdapter(adapter);


                } // End Loop

                Log.d("Result", albumList.toString());

            } catch (JSONException e) {
                Log.e("JSONException", "Error: " + e.toString());
            } // catch (JSONException e)
        } // protected void onPostExecute(Void v)
    } //class MyAsyncTask extends AsyncTask<St



}