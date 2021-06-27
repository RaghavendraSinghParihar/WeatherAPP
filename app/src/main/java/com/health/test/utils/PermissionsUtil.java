package com.health.test.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class PermissionsUtil {

   private final Context _context;


    public PermissionsUtil(Context context){
        this._context=context;
    }

    public ArrayList<String> addPermission(ArrayList<String> permissionList, String permission) {
        if (ContextCompat.checkSelfPermission(_context, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(permission);
        }
        return permissionList;
    }


    public boolean checkAllPermissionsGranted(HashMap<String,Integer> map){
        for(String key : map.keySet()){
            if(map.get(key)!= PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }
}
