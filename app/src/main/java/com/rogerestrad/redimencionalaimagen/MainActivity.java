package com.rogerestrad.redimencionalaimagen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView imagen;
SeekBar seekBar;
private int iwidth=65;
private int iheigth=52;
float density;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics= getResources().getDisplayMetrics();
        density=displayMetrics.densityDpi;
        imagen=(ImageView)findViewById(R.id.imageView);
        seekBar=(SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("valor","Holllalalalla"+progress);
                float ancho=(progress+iwidth)*density/160;
                float alto=(progress+iheigth)*density/160;
                imagen.getLayoutParams().height=(int)alto;
                imagen.getLayoutParams().width=(int)ancho;
                imagen.requestLayout();
                if ((progress==0)||(progress==100)){
                    Toast.makeText(MainActivity.this,"se a llegado al limite",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
