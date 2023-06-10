package com.example.photopuzzlesproject_4.Activity;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.photopuzzlesproject_4.R;
import com.example.photopuzzlesproject_4.Adapter.ThirdPage_Recycler_Adapter;
import com.example.photopuzzlesproject_4.Adapter.Third_Color_Adapter;
import com.example.photopuzzlesproject_4.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity
{

    ImageView thirdPageHintImage ,  thirdPageTheamImage ,  thirdPageRightPositionTic , thirdPageLevelImage;

    TextView thirdPageHintCount , thirdPageClickedTimeText ;

    RelativeLayout pageThirdBackground;
    RecyclerView thirdPageRecyclrView;

    int clickedImagePosition;
    Drawable drawable;
    ArrayList<String> arrayListNameImage = new ArrayList<>();


    AlertDialog.Builder alertDilogFullImage;
    AlertDialog.Builder alertDilogTimeLimit;
    AlertDialog.Builder alertDilogLevel;
    AlertDialog.Builder alertDilogColor;
    AlertDialog.Builder alertDilogTimeUp;
    AlertDialog.Builder alertDialogWinner;
    AlertDialog.Builder alertDilogExit;


    int hintCount = 0;
    CountDownTimer timer = null;
    int [] levelTimeLimit = {30 , 60 , 90 , 120};


    String[] levelWords = {"Beginner" , "Master" , "Expert" , "Challenge"};
    int level = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        thirdPageRecyclrView = findViewById(R.id.ThirdPageRecyclrView);
        thirdPageHintImage = findViewById(R.id.ThirdPageHintImage);
        thirdPageTheamImage = findViewById(R.id.ThirdPageTheamImage);
        thirdPageRightPositionTic = findViewById(R.id.ThirdPageRightPositionTic);
        thirdPageLevelImage = findViewById(R.id.ThirdPageLevelImage);
        thirdPageHintCount = findViewById(R.id.ThirdPageHintCount);
        thirdPageClickedTimeText = findViewById(R.id.ThirdPageClickedTimeText);
        pageThirdBackground = findViewById(R.id.ThirdPageRelativeBackground);


        clickedImagePosition = getIntent().getIntExtra("clickedImagePosition", 0);
        arrayListNameImage = getIntent().getStringArrayListExtra("arrayListNameImage");

        InputStream inputStream = null;

        try {

            inputStream = getAssets().open("Photos/" + arrayListNameImage.get(clickedImagePosition));
            drawable = Drawable.createFromStream(inputStream, null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        alertDialogBoxBeginningMethod();    // first dialog box method


//////////////////------>>   Third Page Grid Adapter for Recycler View    <<<<---------/////////////////////////////////////


        ThirdPage_Recycler_Adapter thirdPage_grid_adapter = new ThirdPage_Recycler_Adapter(this, drawable);
        thirdPageRecyclrView.setAdapter(thirdPage_grid_adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        thirdPageRecyclrView.setLayoutManager(gridLayoutManager);


////////////////////////------>>>>>      DialogBox For Hint Image    <<<<<--------------///////////////////////////////////////////////


        alertDilogFullImage = new AlertDialog.Builder(this);

        thirdPageHintImage.setOnClickListener(v -> {

            View view = LayoutInflater.from(this).inflate(R.layout.third_hint_image_dialogbox, null, false);

            ImageView imageView = view.findViewById(R.id.dialogHintCloseImage);
            ImageView imageView1 = view.findViewById(R.id.dialogHintFullImage);

            imageView1.setImageDrawable(drawable);

            alertDilogFullImage.setView(view);

            AlertDialog alertDialog = alertDilogFullImage.show();

            imageView.setOnClickListener(v1 -> {

                alertDialog.dismiss();

            });

            //------------->>    Hint Counting in TextView    <<------------------//

            hintCount++;
            thirdPageHintCount.setText("Hint - " + hintCount);

        });


   ///////////////////---->>      Alert DilogBox For Theme Color     <<<--------//////////////////////////////////////////////////////


        alertDilogColor = new AlertDialog.Builder(this);

        thirdPageTheamImage.setOnClickListener(v -> {

            View view = LayoutInflater.from(this).inflate(R.layout.third_color_dialogbox, null, false);

            ImageView imageView = view.findViewById(R.id.ColorThemeCancle);
            GridView gridView = view.findViewById(R.id.ThirdPageColorThemeGridview);

            alertDilogColor.setView(view);

            AlertDialog alertDialog = alertDilogColor.show();

            Third_Color_Adapter third_color_adapter = new Third_Color_Adapter(this);
            gridView.setAdapter(third_color_adapter);

            gridView.setOnItemClickListener((adapterView, view1, i, l) -> {

                pageThirdBackground.setBackgroundResource(config.colorArray[i]);

                thirdPageClickedTimeText.setTextColor(getColor(config.colorTextArray[i]));
                thirdPageHintCount.setTextColor(getColor(config.colorTextArray[i]));

                alertDialog.dismiss();

            });

            imageView.setOnClickListener(v1 -> {

                alertDialog.dismiss();
            });


        });


        ///////////////////-------->>>>>>>    AlertDialogBox For Level    <<<<------//////////////////////////////////////////////


        alertDilogLevel = new AlertDialog.Builder(this);

        thirdPageLevelImage.setOnClickListener(v -> {

            View view = LayoutInflater.from(this).inflate(R.layout.third_level_dialogebox, null, false);

            ImageView imageView = view.findViewById(R.id.ThirdPageDialogeLevelClose);
            TextView textView1 = view.findViewById(R.id.DialogeLevelText1);
            TextView textView2 = view.findViewById(R.id.DialogeLevelText2);
            TextView textView3 = view.findViewById(R.id.DialogeLevelText3);
            TextView textView4 = view.findViewById(R.id.DialogeLevelText4);

            alertDilogLevel.setView(view);

            AlertDialog alertDialog = alertDilogLevel.show();


            imageView.setOnClickListener(view1 -> {

                alertDialog.dismiss();
            });


            textView1.setOnClickListener(view1 -> {

                level = 0;

                alertDialogBoxBeginningMethod();

                alertDialog.dismiss();
            });


            textView2.setOnClickListener(view1 -> {

                level = 1;

                alertDialogBoxBeginningMethod();

                alertDialog.dismiss();
            });


            textView3.setOnClickListener(view1 -> {

                level = 2;

                alertDialogBoxBeginningMethod();

                alertDialog.dismiss();
            });


            textView4.setOnClickListener(view1 -> {

                level = 3;

                alertDialogBoxBeginningMethod();

                alertDialog.dismiss();
            });

        });

    }


    ////////////////////////////////////  Alert Dialog Box - BeginingMethod - first Method //////////////////////////////


    public void alertDialogBoxBeginningMethod() {

        if (timer != null) {

            timer.cancel();
        }

        alertDilogTimeLimit = new AlertDialog.Builder(this);

        View view1 = LayoutInflater.from(this).inflate(R.layout.third_timelimit_dialogbox,null,false);

        CheckBox checkBoxFirst = view1.findViewById(R.id.TimeLimitCheckBox);
        TextView textViewFirst = view1.findViewById(R.id.TimeLess30Second);
        TextView textView1First = view1.findViewById(R.id.TimeLimitDialogboxText);
        ImageView imageViewFirst = view1.findViewById(R.id.TimeLimitDialogboxPlay);

        alertDilogTimeLimit.setView(view1);

        AlertDialog alertDialogFirst =  alertDilogTimeLimit.show();

        for (int i = 0; i < 4; i++) {

            if (level == i) {

                textViewFirst.setText("Time Limit : " + levelTimeLimit[level] + " sec");
                textView1First.setText("" + levelWords[level]);
            }
        }

        imageViewFirst.setOnClickListener(v -> {

            if (checkBoxFirst.isChecked()) {

                timeLimitTextViewMethod();
                thirdPageClickedTimeText.setVisibility(View.VISIBLE);

            } else {

                thirdPageClickedTimeText.setVisibility(View.INVISIBLE);
            }

            alertDialogFirst.dismiss();

        });

    }



    @Override
    public void onBackPressed()
    {
//        super.onBackPressed();

        alertDilogExit = new AlertDialog.Builder(this);


        View view = LayoutInflater.from(this).inflate(R.layout.exit_dialogbox , null , false);

        alertDilogExit.setView(view);

        ImageView YesImage = view.findViewById(R.id.ExitDialogYes);
        ImageView NoImage = view.findViewById(R.id.ExitDialogNo);

        AlertDialog alertDialog = alertDilogExit.show();

        YesImage.setOnClickListener(view1 -> {

            Intent Iback = new Intent(MainActivity3.this , MainActivity2.class);
            startActivity(Iback);
            finish();

        });
        NoImage.setOnClickListener(view1 -> {

            alertDialog.dismiss();

        });

    }


/////////////////////////////////--->>     TimeLimit Method For Time Clock in Tectview   <<<<-------//////////////////////


        public void timeLimitTextViewMethod()
        {
            if (timer != null)
            {
                timer.cancel();
            }

            timer = new CountDownTimer((levelTimeLimit[level] + 2) * 1000, 1000)
            {

                @Override
                public void onTick(long l)
                {
                    if (l < 2005)
                    {
                        alertDialogBoxTimeUpMethod();
                    }

                    int second = (int) ( (l / 1000) - 1);
                    int minutes = second / 60;
                    second = second % 60;

                    thirdPageClickedTimeText.setText(minutes + " : " + second);
                }

                public void onFinish()
                {

                }
            } ;

            timer.start();

        }

    //////////////////------->>   Aleart DialogBox Wining Methord   <<<<----------------------/////////////////////////////////


        public void alertDialogBoxWinningMethod()
        {
            if (timer != null)
            {

                timer.cancel();
            }

            alertDilogTimeLimit = new AlertDialog.Builder(this);

            View view1 = LayoutInflater.from(this).inflate(R.layout.third_timelimit_dialogbox,null,false);

            CheckBox checkBoxFirst = view1.findViewById(R.id.TimeLimitCheckBox);
            TextView textViewFirst = view1.findViewById(R.id.TimeLess30Second);
            TextView textView1First = view1.findViewById(R.id.TimeLimitDialogboxText);
            ImageView imageViewFirst = view1.findViewById(R.id.TimeLimitDialogboxPlay);

            alertDilogTimeLimit.setView(view1);

            AlertDialog alertDialogFirst =  alertDilogTimeLimit.show();

            for (int i = 0; i < 4; i++) {

                if (level == i) {

                    textViewFirst.setText("Time Limit : " + levelTimeLimit[level] + " sec");
                    textView1First.setText("" + levelWords[level]);
                }
            }

            imageViewFirst.setOnClickListener(v -> {

                if (checkBoxFirst.isChecked()) {

                    timeLimitTextViewMethod();

                    thirdPageClickedTimeText.setVisibility(View.VISIBLE);

                }
                else
                {

                    thirdPageClickedTimeText.setVisibility(View.INVISIBLE);
                }

                alertDialogFirst.dismiss();

            });

        }

 //////////////////////------->>>     AlertDialogBox TimeUp Method    <<----------------/////////////////////////////////////////

        public void alertDialogBoxTimeUpMethod()
        {
            alertDilogTimeUp = new AlertDialog.Builder(this);

            View view = LayoutInflater.from(this).inflate(R.layout.third_time_up_dialogbox, null , false);

            TextView textViewTimeUp = view.findViewById(R.id.TimeUpDialogText);

            alertDilogTimeUp.setView(view);

            AlertDialog alertDialog = alertDilogTimeUp.show();

            textViewTimeUp.setOnClickListener(view1 -> {

                alertDialogBoxBeginningMethod();
                alertDialog.dismiss();
            });
        }

}




