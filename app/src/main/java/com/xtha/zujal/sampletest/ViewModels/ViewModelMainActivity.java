package com.xtha.zujal.sampletest.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.xtha.zujal.sampletest.*;
import com.xtha.zujal.sampletest.Model.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ViewModelMainActivity extends AndroidViewModel implements GetInfoCallback {

    private ObservableInfoModel mInfo;
    public ObservableInfoModel getInfo() {
        if (mInfo == null) {
            mInfo = new ObservableInfoModel(new String());
        }
        return mInfo;
    }

    Context context;
    GetInfoCallback delegator;

    private MutableLiveData<ArrayList<UserInfo>> users;
    private ArrayList<UserInfo> users2;
    private String hero;

    public ViewModelMainActivity(@NonNull Application application) {
        super(application);
    }


    public LiveData<ArrayList<UserInfo>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<ArrayList<UserInfo>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {


        UserTask usertask = new UserTask(this);
        usertask.execute("getusers");

        if(mInfo !=null){
           // users = mInfo.getOutput();
            Log.i("users2",mInfo.getOutput());
            try {
                JSONArray jArray = new JSONArray(mInfo.getOutput());

                    for (int i=0; i<=jArray.length();i++) {

                        JSONObject jObject = jArray.getJSONObject(i);

                        int id = jObject.getInt("id");
                    String name = jObject.getString("name");
                    String email = jObject.getString("email");
                    String phonenumber = jObject.getString("phone");

                        UserInfo userInfo = new UserInfo(id, name, email, phonenumber);
                        users2.add(userInfo);
                    } // End Loop

                user
                } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //mRepository.getInfo(this);

//        getInfo();
//        mInfo.getOutput();
//        String afinallly = mInfo.getOutput().toString();

      //  Log.i("Finally",afinallly);

        //UserTask usertask = new UserTask().execute("getusers");
//        try {
//            users2 = usertask.execute("getusers").get();
//
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        mRepository.getInfo(this, itemId);
//
//        MyAsyncTask asyncTask = (MyAsyncTask) new MyAsyncTask(new GetInfoCallback(){
//
//            @Override
//            public void processingFinish(String output){
//                Log.i("Üsering",output);
//            }
//        }).execute("getusers");


//        users = UserTask( UserTask.AsyncResponse object  {
//            override fun processFinish(output: String) {
//                //Here you will receive the result fired from async class
//                //of onPostExecute(result) method.
//                stin = output
//                User = ArrayList<UserInfo>()
//
//                try {
//                    val jArray = JSONArray(output)
//
//                    for (i in 0 until jArray.length()) {
//
//                        val jObject = jArray.getJSONObject(i)
//
//                        val id = jObject.getInt("id")
//                        val name = jObject.getString("name")
//                        val email = jObject.getString("email")
//                        val phonenumber = jObject.getString("phone")
//
//                        val userInfo = UserInfo(id, name, email, phonenumber)
//                        User.add(userInfo)
//
//                        Haude = User
//                    } // End Loop
//
//                } catch (e: JSONException) {
//                    Log.e("JSONException", "Error: $e")
//                }
//                // catch (JSONException e)
//            }
//        },getApplication().getApplicationContext()).execute("getusers");
//        // Do an asynchronous operation to fetch users.
    }




    private InfoRepository mRepository;

    public UserTask.AsyncResponse delegate = null;
    public void prepareData() {

        // [Get data from Model-Layer]


      //  new UserTask(delegate,getApplication().getApplicationContext()).execute("getusers");
        //String output = mInfo.getOutput();

      //  Log.i("output",output);

      //  mRepository.getInfo(this);
        UserTask usertask = new UserTask(this);
        usertask.execute("getusers");
    }

    private void gettinguser(){

    }
    @Override
    public void processingFinish(String output) {
      //  mInfo.setValue(output);

        //Log.i("output",output);
        getInfo();
        mInfo.setOutput(output);

        completed();



    }

    public void completed(){
        loadUsers();
    }
}