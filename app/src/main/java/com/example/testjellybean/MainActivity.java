package com.example.testjellybean;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int countJB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAdd(View view) {
        countJB++;
       updateCountTV();
    }//end add button handler

    public void onClickSubtract(View view) {
        countJB--;
        updateCountTV();
    }//end subraction method

    public void openDialogue(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(  this);
        builder.setMessage("Confirm reset count");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick (DialogInterface dialogInterface, int i){
                Toast.makeText(MainActivity.this, "yepppers", Toast.LENGTH_LONG).show();
                countJB = 0;
                updateCountTV();
            })
        });//end set positive button


        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

                // on click
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }//end handler tp open dialogue box for reset count


    //Barin Methods
    private void updateCountTV()
    {
        TextView countTextview = (TextView) findViewById(R.id.countTV);
        countTextview.setText("Counting Jelly Beans gives me " + countJB);
    }
}
