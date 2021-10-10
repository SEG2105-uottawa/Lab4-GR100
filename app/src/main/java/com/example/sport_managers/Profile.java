package com.example.sport_managers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    private static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void SetTeamIcon(View view) {
        Intent returnIntent = new Intent();
        ImageView selectedImage = (ImageView) view;
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
        id = selectedImage.getId();
        finish();

    }
    public void load_from_phone(View view){
        Toast toast;
        toast = Toast.makeText(this, "You do not have permission to do that", Toast.LENGTH_SHORT);
        toast.show();
    }
    public static int getid(){
        return id;
    }



}