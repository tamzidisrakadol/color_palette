package com.example.colorpalette;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class ImageActivity extends AppCompatActivity {
    public static final String Image_key = "this is my image key";
    ImageView imageView;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView=findViewById(R.id.imageView);
        layout=findViewById(R.id.layout);

        File file = new File(getFilesDir(),"My_image");
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

        if (bitmap != null){
            imageView.setImageBitmap(bitmap);

            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(@Nullable Palette palette) {
                    Palette.Swatch swatch = palette.getLightVibrantSwatch();


                    if (swatch != null){
                        int rgb = swatch.getRgb();

                        layout.setBackgroundColor(rgb);

                    }
                }
            });
        }
    }
}