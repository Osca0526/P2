package com.example.p2.frontend;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.p2.R;
import com.example.p2.backend.questionnaire.Score;
import com.example.p2.backend.questionnaire.Test;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private Score scoreResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        defineButtons();
        Intent intent = getIntent();
        Test test = intent.getParcelableExtra("test");
        scoreResult = test.getScore();

        TextView socialScoreTitle = findViewById(R.id.socialScore);
        TextView healthScoreTitle = findViewById(R.id.healthScore);
        TextView metaScoreTitle = findViewById(R.id.metaScore);

        socialScoreTitle.setText(scoreResult.getScore().get(0).getCategoryName());
        healthScoreTitle.setText(scoreResult.getScore().get(1).getCategoryName());
        metaScoreTitle.setText(scoreResult.getScore().get(2).getCategoryName());

        int socialScore = scoreResult.getScore().get(0).getCategoryScoreCount();
        int healthScore = scoreResult.getScore().get(1).getCategoryScoreCount();
        int metaScore = scoreResult.getScore().get(2).getCategoryScoreCount();

        int maxSocialScore = scoreResult.getScore().get(0).getCategoryScoreMaximum();
        int maxHealthScore = scoreResult.getScore().get(1).getCategoryScoreMaximum();
        int maxMetaScore = scoreResult.getScore().get(2).getCategoryScoreMaximum();

        BarChart barChart = (BarChart) findViewById(R.id.bargraph);
        ArrayList<BarEntry> barEntries1 = new ArrayList<>(0);
        ArrayList<BarEntry> barEntries2 = new ArrayList<>();
        barEntries1.add( new BarEntry(1f, socialScore));
        barEntries2.add( new BarEntry(2f, maxSocialScore));
        barEntries1.add( new BarEntry(4f, healthScore));
        barEntries2.add( new BarEntry(5f, maxHealthScore));
        barEntries1.add( new BarEntry(7f, metaScore));
        barEntries2.add( new BarEntry(8f, maxMetaScore));
        BarDataSet barDataSet1 = new BarDataSet(barEntries1, "Your Score");
        BarDataSet barDataSet2 = new BarDataSet(barEntries2, "Maximum Score");
        barDataSet1.setColors(Color.parseColor("#B8BAFF"));
        barDataSet2.setColors(Color.parseColor("#5C5D80"));

        ArrayList<String> categories = new ArrayList<>();
        categories.add(scoreResult.getScore().get(0).getCategoryName());
        categories.add(scoreResult.getScore().get(1).getCategoryName());
        categories.add(scoreResult.getScore().get(2).getCategoryName());

        //creating the chart
        BarData data = new BarData(barDataSet1, barDataSet2);
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.WHITE);

        //setting the data to the chart
        barChart.setData(data);

        //accessing the x and y axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(false);
        xAxis.setDrawGridLines(false);
        xAxis.setCenterAxisLabels(true);

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setAxisMinimum(0);
        yAxisLeft.setAxisMaximum(max(maxSocialScore,maxHealthScore,maxMetaScore));
        yAxisLeft.setTextSize(16f);
        yAxisLeft.setTextColor(Color.WHITE);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawLabels(false);

        Description DescText = barChart.getDescription();
        DescText.setEnabled(false);

        Legend legend = barChart.getLegend();
        legend.setTextColor(Color.WHITE);
        barChart.setFitBars(true);
        barChart.setTouchEnabled(false);
        barChart.animateY(2000);
        barChart.invalidate();
    }

    public void defineButtons(){
        findViewById(R.id.buttonR1).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonR1:
                    startActivity(new Intent(ResultActivity.this, MainActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    break;
            }
        }
    };

    public int max(int... values) {
        int max = 0;
        for (int value : values) {
            if (max == 0 || (value != 0 && value > max)) {
                max = value;
            }
        }
        return max;
    }

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}