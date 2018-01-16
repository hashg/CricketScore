package com.example.hgowda.cricketscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamIndia = 0;
    int ballsTeamIndia = 0;
    int wicketsTeamIndia = 0;
    TextView scoreViewIndia;
    TextView overViewIndia;
    LinearLayout layoutIndia;

    int scoreTeamSA = 0;
    int ballsTeamSA = 0;
    int wicketsTeamSA = 0;
    TextView scoreViewSA;
    TextView overViewSA;
    LinearLayout layoutSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewIndia = findViewById(R.id.team_india_score);
        overViewIndia = findViewById(R.id.team_india_overs);
        layoutIndia = findViewById(R.id.team_india_layout);

        scoreViewSA = findViewById(R.id.team_sa_score);
        overViewSA = findViewById(R.id.team_sa_overs);
        layoutSA = findViewById(R.id.team_sa_layout);

        if (savedInstanceState != null) {
            scoreTeamIndia = savedInstanceState.getInt("scoreTeamIndia");
            ballsTeamIndia = savedInstanceState.getInt("ballsTeamIndia");
            wicketsTeamIndia = savedInstanceState.getInt("wicketsTeamIndia");

            scoreTeamSA = savedInstanceState.getInt("scoreTeamSA");
            ballsTeamSA = savedInstanceState.getInt("ballsTeamSA");
            wicketsTeamSA = savedInstanceState.getInt("wicketsTeamSA");
        }
        disableButtons(layoutSA);
        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);
    }

    public void disableButtons(LinearLayout layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof Button) {
                child.setEnabled(false);
            }
            if (child instanceof LinearLayout) {
                disableButtons((LinearLayout) child);
            }
        }
    }

    public void enableButtons(LinearLayout layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof Button) {
                child.setEnabled(true);
            }
            if (child instanceof LinearLayout) {
                enableButtons((LinearLayout) child);
            }
        }
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
        //if team has completed 20 overs or lost all 10 wickets
        // then innings has to shift to next team
        if (balls >= 120 || wickets >= 10) {
            disableButtons(layoutIndia);
            enableButtons(layoutSA);
        }

        String scoreLocal = fmtScore(score, wickets);
        scoreViewIndia.setText(scoreLocal);

        String overs = calcOver(balls);
        overViewIndia.setText(overs);
    }

    public void displayForTeamSA(int score, int balls, int wickets) {
        //if team has completed 20 overs or lost all 10 wickets
        // then innings has to shift to next team
        if (balls >= 120 || wickets >= 10) {
            disableButtons(layoutSA);
            enableButtons(layoutIndia);
        }

        String scoreLocal = fmtScore(score, wickets);
        scoreViewSA.setText(scoreLocal);

        String overs = calcOver(balls);
        overViewSA.setText(overs);
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

    public void resetScore(View view) {
        scoreTeamIndia = 0;
        ballsTeamIndia = 0;
        wicketsTeamIndia = 0;

        scoreTeamSA = 0;
        ballsTeamSA = 0;
        wicketsTeamSA = 0;

        displayForTeamIndia(scoreTeamIndia, ballsTeamIndia, wicketsTeamIndia);
        displayForTeamSA(scoreTeamSA, ballsTeamSA, wicketsTeamSA);

        enableButtons(layoutIndia);
        disableButtons(layoutSA);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("scoreTeamIndia", scoreTeamIndia);
        savedInstanceState.putInt("ballsTeamIndia", ballsTeamIndia);
        savedInstanceState.putInt("wicketsTeamIndia", wicketsTeamIndia);

        savedInstanceState.putInt("scoreTeamSA", scoreTeamSA);
        savedInstanceState.putInt("ballsTeamSA", ballsTeamSA);
        savedInstanceState.putInt("wicketsTeamSA", wicketsTeamSA);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        scoreTeamIndia = savedInstanceState.getInt("scoreTeamIndia");
        ballsTeamIndia = savedInstanceState.getInt("ballsTeamIndia");
        wicketsTeamIndia = savedInstanceState.getInt("wicketsTeamIndia");

        scoreTeamSA = savedInstanceState.getInt("scoreTeamSA");
        ballsTeamSA = savedInstanceState.getInt("ballsTeamSA");
        wicketsTeamSA = savedInstanceState.getInt("wicketsTeamSA");
    }
}
