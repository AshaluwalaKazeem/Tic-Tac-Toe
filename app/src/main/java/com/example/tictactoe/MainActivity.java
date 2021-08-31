package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button cancelButton;
    TextView player1Text;
    TextInputEditText player1EditText;
    ImageView playerOImageButton, playerXImageButton;
    String selectedMakerType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ((TextView) findViewById(R.id.tic_tac_toe_text)).setText(Html.fromHtml("<h1><font color='#e0a56b'>T</font><font color='#ffffff'>ic</font> <font color='#e0a56b'>T</font><font color='#ffffff'>ac</font> <font color='#e0a56b'>T</font><font color='#ffffff'>oe</font></h1>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            ((TextView) findViewById(R.id.tic_tac_toe_text)).setText(Html.fromHtml("<h1><font color='#e0a56b'>T</font><font color='#ffffff'>ic</font> <font color='#e0a56b'>T</font><font color='#ffffff'>ac</font> <font color='#e0a56b'>T</font><font color='#ffffff'>oe</font></h1>"));
        }

        cancelButton = findViewById(R.id.cancel_button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        player1Text = findViewById(R.id.player1_text);

        player1EditText = findViewById(R.id.player1_edit_text);
        player1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                player1Text.setText("Player 1: " + String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        playerOImageButton = findViewById(R.id.player_o_image_button);
        playerXImageButton = findViewById(R.id.player_x_image_button);

        playerOImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedMakerType = "O";
                playerXImageButton.getLayoutParams().width = 60;
                playerXImageButton.getLayoutParams().height = 60;
                playerXImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                playerXImageButton.requestLayout();
                playerOImageButton.getLayoutParams().width = 100;
                playerOImageButton.getLayoutParams().height = 100;
                playerOImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                playerOImageButton.requestLayout();
            }
        });

        playerXImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedMakerType = "X";

                playerXImageButton.getLayoutParams().width = 100;
                playerXImageButton.getLayoutParams().height = 100;
                playerXImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                playerOImageButton.getLayoutParams().width = 60;
                playerOImageButton.getLayoutParams().height = 60;
                playerOImageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                playerXImageButton.requestLayout();
                playerOImageButton.requestLayout();
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility((View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY));
        }

    }

}