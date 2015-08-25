package com.example.drwillsmith.myedittext;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    Button helloButton;
    EditText ageText;
    TextView greetingText;
    TextView scrollResult;
    ImageView picture;
    int age;
    int picVal;
    SeekBar ageScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        helloButton = (Button)findViewById(R.id.button);
        ageText = (EditText)findViewById(R.id.editText);
        greetingText  = (TextView)findViewById(R.id.textView);
        picture = (ImageView)findViewById(R.id.imageView);
        ageScroller = (SeekBar)findViewById(R.id.seekBar);
        scrollResult = (TextView)findViewById(R.id.scrollOutput);
        ageScroller.setMax(110);

        picture.setImageResource(R.drawable.dog7);
        picVal=0;


        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Integer.valueOf(ageText.getText().toString());
                age = age/7;
                greetingText.setText("If you were a dog, you would be "+age+" years old");

            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (picVal==0){
                    picture.setImageResource(R.drawable.will);
                    picVal=1;}
                else {
                    picture.setImageResource(R.drawable.dog7);
                    picVal=0;
                }
            }
        });

        ageScroller.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scrollResult.setText("You age : "+progress);
                greetingText.setText("Dog age: " +(progress/7));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
