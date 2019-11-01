package com.xtha.zujal.sampletest.Model;

public class UserInfo {

    private int userid;
    private String username;
    private String useremail;
    private String usernumber;

    public UserInfo(int id,String username, String useremail, String usernumber)
    {
        this.userid = id;
        this.username = username;
        this.useremail =  useremail;
        this.usernumber =  usernumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", usernumber='" + usernumber + '\'' +
                '}';
    }
}
