package com.example.hgowda.cricketscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamIndia = 0;
    int ballsTeamIndia = 0;
    int wicketsTeamIndia = 0;

    int scoreTeamSA = 0;
    int ballsTeamSA = 0;
    int wicketsTeamSA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public String fmtScore(int score, int wickets) {
        return score + "/" + wickets;
    }

    public String calcOver(int balls) {
        if (balls == 0)
            return "0.0 Ovs";

        int oversLocal = balls / 6;
        int ballsLocal = balls % 6;

        return oversLocal + "." + ballsLocal + " Ovs";
    }

    public void displayForTeamIndia(int score, int balls, int wickets) {
        TextView scoreView = findViewById(R.id.team_india_score);
        String scoreLocal = fmtScore(score, wickets);
        scoreView.setText(scoreLocal);

        TextView overView = findViewById(R.id.team_india_overs);
        String overs = calcOver(balls);
        overView.setText(overs);
    }

    public void displayForTeamSA(int score, int balls, int wickets) {
        TextView scoreView = findViewById(R.id.team_sa_score);
        String scoreLocal = fmtScore(score, wickets);
        scoreView.setText(scoreLocal);

        TextView overView = findViewById(R.id.team_sa_overs);
        String overs = calcOver(balls);
        overView.setText(overs);
    }

    public void add6RunForIndia(View view) {
        scoreTeamIndia += 6;
        ballsTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add4RunForIndia(View view) {
        scoreTeamIndia += 4;
        ballsTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add1RunForIndia(View view) {
        scoreTeamIndia += 1;
        ballsTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add0RunForIndia(View view) {
        ballsTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add1WicketForIndia(View view) {
        if (wicketsTeamIndia <= 10) {
            wicketsTeamIndia += 1;
            ballsTeamIndia += 1;
        }
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add1NoBallForIndia(View view) {
        scoreTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add1WideForIndia(View view) {
        scoreTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add1ByeForIndia(View view) {
        scoreTeamIndia += 1;
        ballsTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add1LegByeForIndia(View view) {
        scoreTeamIndia += 1;
        ballsTeamIndia += 1;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
    }

    public void add6RunForSA(View view) {
        scoreTeamSA += 6;
        ballsTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add4RunForSA(View view) {
        scoreTeamSA += 4;
        ballsTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add1RunForSA(View view) {
        scoreTeamSA += 1;
        ballsTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add0RunForSA(View view) {
        ballsTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add1WicketForSA(View view) {
        if (wicketsTeamSA <= 10) {
            wicketsTeamSA += 1;
            ballsTeamSA += 1;
        }
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add1NoBallForSA(View view) {
        scoreTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add1WideForSA(View view) {
        scoreTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add1ByeForSA(View view) {
        scoreTeamSA += 1;
        ballsTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void add1LegByeForSA(View view) {
        scoreTeamSA += 1;
        ballsTeamSA += 1;
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void resetScore(View view){
        scoreTeamIndia = 0;
        ballsTeamIndia = 0;
        wicketsTeamIndia = 0;

        scoreTeamSA = 0;
        ballsTeamSA = 0;
        wicketsTeamSA = 0;
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }
}
