package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Player2InfoActivity extends AppCompatActivity {
    Button backButton, enterButton;
    TextInputLayout player2TextInput;
    TextView player2Text;
    TextInputEditText player2EditText;
    ImageView player2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2_info);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ((TextView) findViewById(R.id.tic_tac_toe_text)).setText(Html.fromHtml("<h1><font color='#e0a56b'>T</font><font color='#ffffff'>ic</font> <font color='#e0a56b'>T</font><font color='#ffffff'>ac</font> <font color='#e0a56b'>T</font><font color='#ffffff'>oe</font></h1>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            ((TextView) findViewById(R.id.tic_tac_toe_text)).setText(Html.fromHtml("<h1><font color='#e0a56b'>T</font><font color='#ffffff'>ic</font> <font color='#e0a56b'>T</font><font color='#ffffff'>ac</font> <font color='#e0a56b'>T</font><font color='#ffffff'>oe</font></h1>"));
        }

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v->{
            finish();
        });

        player2Text = findViewById(R.id.player2_text);

        player2EditText = findViewById(R.id.player2_edit_text);
        player2TextInput = findViewById(R.id.player2_text_input);
        player2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                player2Text.setText("Player 2: " + String.valueOf(charSequence));
                if (player2EditText.getText().toString().trim().length() == 0) {
                    player2EditText.setError("Enter a valid name");
                    player2TextInput.setErrorEnabled(true);
                }else{
                    player2TextInput.setError("");
                    player2TextInput.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        player2Button = findViewById(R.id.player_2_button);
        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
            player2Button.setImageResource(R.drawable.ic_selected_o_button);
            Game.getInstance().setPlayer2SelectedCardType("O");
        }else{
            player2Button.setImageResource(R.drawable.ic_selected_star_player);
            Game.getInstance().setPlayer2SelectedCardType("X");
        }

        enterButton = findViewById(R.id.enter_button);

        enterButton.setOnClickListener(v -> {
            if (player2EditText.getText().toString().trim().length() == 0) {
                player2TextInput.setError("Enter a valid name");
                player2TextInput.setErrorEnabled(true);
            } else{
                if (player2EditText.getText().toString().trim().equals(Game.getInstance().getPlayer1Name())) {
                    player2TextInput.setError("Enter a different name");
                    player2TextInput.setErrorEnabled(true);
                }else {
                    player2TextInput.setError("");
                    player2TextInput.setErrorEnabled(false);

                    Game.getInstance().setPlayer2Name(player2EditText.getText().toString());

                    startActivity(new Intent(getApplicationContext(), GameActivity.class));
                }
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