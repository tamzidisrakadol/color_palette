package com.example.colorpalette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView img1,img2,img3,img4,img5,img6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=findViewById(R.id.image1);
        img2=findViewById(R.id.image2);
        img3=findViewById(R.id.image3);
        img4=findViewById(R.id.image4);
        img5=findViewById(R.id.image5);
        img6=findViewById(R.id.image6);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageView){

            ImageView imageView = (ImageView) v;
            Drawable drawable = imageView.getDrawable();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();

            try (FileOutputStream fileOutputStream = openFileOutput("My_image", Context.MODE_PRIVATE)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Intent intent = new Intent(this,ImageActivity.class);
            startActivity(intent);
        }
    }
}