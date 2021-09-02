package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    Button endGame, restartGame;
    ImageView element00, element01, element02, element10, element11, element12, element20, element21, element22;
    TextView player1Score, player2Score, playersTurnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initFields();
        clickListeners();
    }

    private void initFields() {
        endGame = findViewById(R.id.end_game);
        player1Score = findViewById(R.id.player_1_score);
        player1Score.setText(Game.getInstance().getPlayer1Name() + "'s score : " + String.valueOf(Game.getInstance().getPlayer1Score()));
        player2Score = findViewById(R.id.player_2_score);
        player2Score.setText(Game.getInstance().getPlayer2Name() + "'s score : " + String.valueOf(Game.getInstance().getPlayer2Score()));
        restartGame = findViewById(R.id.restart_game);
        element00 = findViewById(R.id.element_00);
        element01 = findViewById(R.id.element_01);
        element02 = findViewById(R.id.element_02);
        element10 = findViewById(R.id.element_10);
        element11 = findViewById(R.id.element_11);
        element12 = findViewById(R.id.element_12);
        element20 = findViewById(R.id.element_20);
        element21 = findViewById(R.id.element_21);
        element22 = findViewById(R.id.element_22);
        playersTurnText = findViewById(R.id.players_turn_text);
        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
    }

    private void clickListeners() {
        endGame.setOnClickListener(v -> {
            onEndGameClicked();
        });
        restartGame.setOnClickListener(v -> {
            onRestartGameClicked();
        });

        element00.setOnClickListener(v -> {
            onElementClickListener(00);
        });

        element01.setOnClickListener(v -> {
            onElementClickListener(01);
        });

        element02.setOnClickListener(v -> {
            onElementClickListener(02);
        });

        element10.setOnClickListener(v -> {
            onElementClickListener(10);
        });

        element11.setOnClickListener(v -> {
            onElementClickListener(11);
        });

        element12.setOnClickListener(v -> {
            onElementClickListener(12);
        });

        element20.setOnClickListener(v -> {
            onElementClickListener(20);
        });

        element21.setOnClickListener(v -> {
            onElementClickListener(21);
        });

        element22.setOnClickListener(v -> {
            onElementClickListener(22);
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

    public void onEndGameClicked(){
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Are you sure you want to exist the game?");
        builder.setMessage("All your game data will be lost");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Exist", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(GameActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                Game.getInstance().endGameDate();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        onEndGameClicked();
    }

    public void onRestartGameClicked(){
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Are you sure you want to restart the game?");
        builder.setMessage("All your game will be restarted");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Game.getInstance().restartGame();
                element00.setImageResource(R.drawable.ic_not_selected);
                element00.setScaleType(ImageView.ScaleType.FIT_XY);
                element01.setImageResource(R.drawable.ic_not_selected);
                element01.setScaleType(ImageView.ScaleType.FIT_XY);
                element02.setImageResource(R.drawable.ic_not_selected);
                element02.setScaleType(ImageView.ScaleType.FIT_XY);
                element10.setImageResource(R.drawable.ic_not_selected);
                element10.setScaleType(ImageView.ScaleType.FIT_XY);
                element11.setImageResource(R.drawable.ic_not_selected);
                element11.setScaleType(ImageView.ScaleType.FIT_XY);
                element12.setImageResource(R.drawable.ic_not_selected);
                element12.setScaleType(ImageView.ScaleType.FIT_XY);
                element20.setImageResource(R.drawable.ic_not_selected);
                element20.setScaleType(ImageView.ScaleType.FIT_XY);
                element21.setImageResource(R.drawable.ic_not_selected);
                element21.setScaleType(ImageView.ScaleType.FIT_XY);
                element22.setImageResource(R.drawable.ic_not_selected);
                element22.setScaleType(ImageView.ScaleType.FIT_XY);

                player1Score.setText(Game.getInstance().getPlayer1Name() + "'s score : " + String.valueOf(Game.getInstance().getPlayer1Score()));
                player2Score.setText(Game.getInstance().getPlayer2Name() + "'s score : " + String.valueOf(Game.getInstance().getPlayer2Score()));
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void onElementClickListener(int index){
        switch (index){
            case 00:
                if(Game.getInstance().getGameDataByIndex(0, 0).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element00.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element00.setImageResource(R.drawable.ic_o_player);
                        }
                        element00.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(0, 0, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element00.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element00.setImageResource(R.drawable.ic_o_player);
                        }
                        element00.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(0, 0, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 01:
                if(Game.getInstance().getGameDataByIndex(0, 1).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element01.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element01.setImageResource(R.drawable.ic_o_player);
                        }
                        element01.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(0, 1, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element01.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element01.setImageResource(R.drawable.ic_o_player);
                        }
                        element01.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(0, 1, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 02:
                if(Game.getInstance().getGameDataByIndex(0, 2).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element02.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element02.setImageResource(R.drawable.ic_o_player);
                        }
                        element02.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(0, 2, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element02.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element02.setImageResource(R.drawable.ic_o_player);
                        }
                        element02.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(0, 2, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 10:
                if(Game.getInstance().getGameDataByIndex(1, 0).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element10.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element10.setImageResource(R.drawable.ic_o_player);
                        }
                        element10.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(1, 0, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element10.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element10.setImageResource(R.drawable.ic_o_player);
                        }
                        element10.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(1, 0, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 11:
                if(Game.getInstance().getGameDataByIndex(1, 1).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element11.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element11.setImageResource(R.drawable.ic_o_player);
                        }
                        element11.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(1, 1, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element11.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element11.setImageResource(R.drawable.ic_o_player);
                        }
                        element11.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(1, 1, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 12:
                if(Game.getInstance().getGameDataByIndex(1, 2).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element12.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element12.setImageResource(R.drawable.ic_o_player);
                        }
                        element12.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(1, 2, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element12.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element12.setImageResource(R.drawable.ic_o_player);
                        }
                        element12.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(1, 2, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 20:
                if(Game.getInstance().getGameDataByIndex(2, 0).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element20.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element20.setImageResource(R.drawable.ic_o_player);
                        }
                        element20.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(2, 0, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element20.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element20.setImageResource(R.drawable.ic_o_player);
                        }
                        element20.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(2, 0, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 21:
                if(Game.getInstance().getGameDataByIndex(2, 1).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element21.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element21.setImageResource(R.drawable.ic_o_player);
                        }
                        element21.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(2, 1, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element21.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element21.setImageResource(R.drawable.ic_o_player);
                        }
                        element21.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(2, 1, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
            case 22:
                if(Game.getInstance().getGameDataByIndex(2, 2).equals("")){
                    if(Game.getInstance().isPlayer1Turn()){
                        if(Game.getInstance().getPlayer1SelectedCardType().equals("X")){
                            element22.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element22.setImageResource(R.drawable.ic_o_player);
                        }
                        element22.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(2, 2, Game.getInstance().getPlayer1SelectedCardType());
                    }else{
                        if(Game.getInstance().getPlayer2SelectedCardType().equals("X")){
                            element22.setImageResource(R.drawable.ic_star_player);
                        }else{
                            element22.setImageResource(R.drawable.ic_o_player);
                        }
                        element22.setScaleType(ImageView.ScaleType.FIT_XY);
                        Game.getInstance().setGameDataByIndex(2, 2, Game.getInstance().getPlayer2SelectedCardType());
                    }
                    if(Game.getInstance().isPlayer1Turn()){
                        Game.getInstance().setPlayer1Turn(false);
                        playersTurnText.setText(Game.getInstance().getPlayer2Name() + " turn");
                    }else{
                        Game.getInstance().setPlayer1Turn(true);
                        playersTurnText.setText(Game.getInstance().getPlayer1Name() + " turn");
                    }
                }
                break;
        }



        Toast.makeText(getApplicationContext(), String.valueOf(Game.getInstance().getWhoWin()), Toast.LENGTH_SHORT).show();
        if(Game.getInstance().getWhoWin() == 1){// Player 1 won
            // 1. increase player 1 score
            Game.getInstance().increasePlayer1Score();
            player1Score.setText(Game.getInstance().getPlayer1Name() + "'s score : " + String.valueOf(Game.getInstance().getPlayer1Score()));
            // 2. Display Win dialog
            displayDialogForSuccessfulWin(Game.getInstance().getPlayer1Name());
        }else if(Game.getInstance().getWhoWin() == 2){// Player 2 won
            // 1. increase player 2 score
            Game.getInstance().increasePlayer2Score();
            player2Score.setText(Game.getInstance().getPlayer2Name() + "'s score : " + String.valueOf(Game.getInstance().getPlayer2Score()));
            // 2. Display win dialog
            displayDialogForSuccessfulWin(Game.getInstance().getPlayer2Name());
        }else{// No one win. Check if all elements are selected
            if (Game.getInstance().isAllElementSelected()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("OOops.");
                builder.setCancelable(false);
                builder.setMessage("Don't relent, you can still win your opponent");
                builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Game.getInstance().resetGameDashboard();
                        element00.setImageResource(R.drawable.ic_not_selected);
                        element00.setScaleType(ImageView.ScaleType.FIT_XY);
                        element01.setImageResource(R.drawable.ic_not_selected);
                        element01.setScaleType(ImageView.ScaleType.FIT_XY);
                        element02.setImageResource(R.drawable.ic_not_selected);
                        element02.setScaleType(ImageView.ScaleType.FIT_XY);
                        element10.setImageResource(R.drawable.ic_not_selected);
                        element10.setScaleType(ImageView.ScaleType.FIT_XY);
                        element11.setImageResource(R.drawable.ic_not_selected);
                        element11.setScaleType(ImageView.ScaleType.FIT_XY);
                        element12.setImageResource(R.drawable.ic_not_selected);
                        element12.setScaleType(ImageView.ScaleType.FIT_XY);
                        element20.setImageResource(R.drawable.ic_not_selected);
                        element20.setScaleType(ImageView.ScaleType.FIT_XY);
                        element21.setImageResource(R.drawable.ic_not_selected);
                        element21.setScaleType(ImageView.ScaleType.FIT_XY);
                        element22.setImageResource(R.drawable.ic_not_selected);
                        element22.setScaleType(ImageView.ScaleType.FIT_XY);
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        }
    }

    public void displayDialogForSuccessfulWin(String playerName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Who dey!!!!!!");
        builder.setMessage(playerName + " won the game");
        builder.setCancelable(false);
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Game.getInstance().resetGameDashboard();
                element00.setImageResource(R.drawable.ic_not_selected);
                element00.setScaleType(ImageView.ScaleType.FIT_XY);
                element01.setImageResource(R.drawable.ic_not_selected);
                element01.setScaleType(ImageView.ScaleType.FIT_XY);
                element02.setImageResource(R.drawable.ic_not_selected);
                element02.setScaleType(ImageView.ScaleType.FIT_XY);
                element10.setImageResource(R.drawable.ic_not_selected);
                element10.setScaleType(ImageView.ScaleType.FIT_XY);
                element11.setImageResource(R.drawable.ic_not_selected);
                element11.setScaleType(ImageView.ScaleType.FIT_XY);
                element12.setImageResource(R.drawable.ic_not_selected);
                element12.setScaleType(ImageView.ScaleType.FIT_XY);
                element20.setImageResource(R.drawable.ic_not_selected);
                element20.setScaleType(ImageView.ScaleType.FIT_XY);
                element21.setImageResource(R.drawable.ic_not_selected);
                element21.setScaleType(ImageView.ScaleType.FIT_XY);
                element22.setImageResource(R.drawable.ic_not_selected);
                element22.setScaleType(ImageView.ScaleType.FIT_XY);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

}
