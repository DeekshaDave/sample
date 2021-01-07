package com.example.finalproject;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FinalProjectprefs {

    private FinalProjectprefs(){

    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("PermanentPrefs", Context.MODE_PRIVATE);
    }

    public static boolean containKeyDevice(Context context, String strkey){
        return getSharedPreferences(context).contains(strkey);
    }

    public static void putStringFlagValue(Context context, String editorkey, String editorvalue) {
        SharedPreferences.Editor mEditor = getSharedPreferences(context).edit();
        mEditor.putString(editorkey, editorvalue);
        mEditor.commit();
    }

    public static String getStringFlagValue(Context context, String editorkey, String defValue) {
        String PrefValue = getSharedPreferences(context).getString(editorkey, defValue);
        return PrefValue;

    }

    public static void setIsFirstTime(Context context, String editorkey, boolean editorvalue) {
        SharedPreferences.Editor mEditor = getSharedPreferences(context).edit();
        mEditor.putBoolean(editorkey, editorvalue);
        mEditor.commit();
    }

    public static boolean getIsFirstTime(Context context, String editorkey, boolean defValue){
        return getSharedPreferences(context).getBoolean(editorkey, defValue);
    }

    public static List<MedLogModel> getMedArray(Context context, String medName) {
        Gson gson = new Gson();
        String json = getSharedPreferences(context).getString(medName, null);
        Type type=new TypeToken<List<MedLogModel>>() {}.getType();
        List<MedLogModel> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setMedArray(Context context, List<MedLogModel> result, String medName) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        Gson gson = new Gson();
        String json = gson.toJson(result);
        edit.putString(medName, json);
        edit.commit();

    }

    public static void clearDeviceData(Context context) {
        try {
            SharedPreferences.Editor mEditor = getSharedPreferences(context).edit();
            mEditor.clear();
            mEditor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
