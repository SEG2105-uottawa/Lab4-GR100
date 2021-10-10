package com.example.sport_managers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText teamlocation;
    private int pic=0;
    private ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    protected void onStart() {

        super.onStart();
        try{
            pic= Profile.getid();
            changeicon(pic);
        }
        catch (Exception e){
        }
    }
    public void OnOpenInGoogleMaps(View view) {
        teamlocation = (EditText) findViewById(R.id.Location);
        String test = teamlocation.getText().toString();
        System.out.println(test);
        if (test.equals("")){
            Toast toast;
            toast = Toast.makeText(this, "The location is empty", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamlocation.getText());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    }
    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), Profile.class);
        startActivity (intent);
    }
    private void changeicon(int pic){
        icon = (ImageView)findViewById(R.id.icon);
        String drawableName;
        switch (pic) {
            case 2131231195:
                drawableName = "ic_logo_01";
                break;
            case 2131231196:
                drawableName = "ic_logo_02";
                break;
            case 2131231197:
                drawableName = "ic_logo_03";
                break;
            case 2131231198:
                drawableName = "ic_logo_04";
                break;
            case 2131231199:
                drawableName = "ic_logo_05";
                break;
            case 2131231100:
                drawableName = "ic_logo_00";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        icon.setImageResource(resID);
    }

}