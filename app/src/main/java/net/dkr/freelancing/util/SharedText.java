package net.dkr.freelancing.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashSet;

public class SharedText {

    private Context context;
    private SharedPreferences sharedPreferences;

    public SharedText(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userText",Context.MODE_PRIVATE);
    }

//    public void setUserText(String userName,boolean isSeller){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("UserName",userName);
//        editor.putBoolean("isSeller",isSeller);
//        editor.commit();
//    }
    public void setUserText(boolean isSeller){
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("UserName",userName);
        editor.putBoolean("isSeller",isSeller);
        editor.commit();
    }

    public void setLog(String st){
       SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putString("isLog",st);
       editor.commit();
    }

    public void setSearch(boolean b){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isSearch",b);
        editor.commit();
    }

    public String getCookie(){
        HashSet<String> cookies = (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(context).getStringSet("PREF_COOKIES", new HashSet<String>());
        String cookie = cookies.toString();
        String mCookies[] = cookie.substring(1,cookie.length()-1).split("=");
        String mCookie[] = mCookies[1].split(";");
        return mCookie[0];
    }

    public boolean getSearch(){
        return sharedPreferences.getBoolean("isSearch",false);
    }

    public boolean getLog(){
        return sharedPreferences.getString("isLog","notLog").equals("log");
    }
    public boolean userType(){
        return sharedPreferences.getBoolean("isSeller",false);
    }

    public void setUserId(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserId",id);
        editor.commit();

    }

    public String getUserId(){
        return sharedPreferences.getString("UserId",null);
    }

    public void setUsers(String senderId, String receiverId){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("sender",senderId);
        editor.putString("receiver",receiverId);
        editor.commit();

    }

    public void setChat(String chatId){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("chatId",chatId);
        editor.commit();

    }
//    public String getChat(){
//
//    }
    public boolean isChat(String senderId,String receiverId){
        if (sharedPreferences.getString("sender",null).equals(senderId) &&
                sharedPreferences.getString("receiver",null).equals(receiverId)){
            return true;
        }
        return false;
    }
}
