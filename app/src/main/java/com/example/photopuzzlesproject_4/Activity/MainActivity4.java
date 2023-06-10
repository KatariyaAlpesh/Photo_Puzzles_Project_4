package com.example.photopuzzlesproject_4.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.photopuzzlesproject_4.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;


public class MainActivity4 extends AppCompatActivity
{

    ImageView imageView;
    Button button;
    Uri resultUri;
    String image;

////////////----->>>    This STRING for Get Parmissition From the usere    <<<<-----////////////////////


    String permission[] = {Manifest.permission.CAMERA ,
                             Manifest.permission.READ_EXTERNAL_STORAGE ,
                             Manifest.permission.WRITE_EXTERNAL_STORAGE };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView = findViewById(R.id.OpenPhotoGalleryIcon);
        button = findViewById(R.id.OpenPhotoAddImageButton);


        //////////------>>>>>    This Methord only for Network is Connected or Not    <<<<<-----///////////////////////
////////    Press on alt + enter and open the Folder Clik on ==   Creat Methord ' isNetworkConnected in' MainActivity4   ////////


        if (isNetworkConnected())
        {

        }
        else
        {
            Toast.makeText(this, "Not Conected", Toast.LENGTH_SHORT).show();
        }

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                ///////////

                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(MainActivity4.this);
                ActivityCompat.requestPermissions(MainActivity4.this , permission , 1);

            }
        });


        imageView.setOnClickListener(view -> {

            Intent Inext ;
            Inext = new Intent(MainActivity4.this , MainActivity5.class);
            Inext.putExtra("PutClickImage" , image );
            startActivity(Inext);

        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
        {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK)
            {

                resultUri = result.getUri();
                image = resultUri.toString();
                imageView.setImageURI(Uri.parse(image));
              //  System.out.println("Result URI="+resultUri);

            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE)
            {

                Exception error = result.getError();

            }
        }

    }


//////////////----->>>   If user give Permission then Get Images in Gallery <<<<<--------///////////////////////
//            ///    this code is for cheque permission is granted or not     /////


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] != PackageManager.PERMISSION_GRANTED ||
            grantResults[1] != PackageManager.PERMISSION_GRANTED ||
            grantResults[2] != PackageManager.PERMISSION_GRANTED)
        {
            finish();
        }

    }


//////////------>>>>>    This Methord only for Network is Connected or Not    <<<<<-----///////////////////////


    private boolean isNetworkConnected()
    {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();

    }


}