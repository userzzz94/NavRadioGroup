package activity.huafeng.com.navradiogroup;

import android.Manifest;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by leovo on 2018-08-24.
 */

public class Manager_Mine extends Fragment {

    public View onCreateView(LayoutInflater inflater ,
                             ViewGroup container, Bundle savedInstanceState){
        View view =inflater .inflate(R.layout .manager_mine ,null ) ;
        return view ;
    }


}