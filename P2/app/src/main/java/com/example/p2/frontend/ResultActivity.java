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
    Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViewById(R.id.buttonR1).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonR2).setOnClickListener(buttonClickListener);
        Intent intent = getIntent();
        test = intent.getParcelableExtra("test2");
        Score scoreResult = test.getScore();

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

        int minSocialScore = scoreResult.getScore().get(0).getCategoryScoreMinimum();
        int minHealthScore = scoreResult.getScore().get(1).getCategoryScoreMinimum();
        int minMetaScore = scoreResult.getScore().get(2).getCategoryScoreMinimum();

        float avgSocialScore = scoreResult.getScore().get(0).getCategoryAverage();
        float avgHealthScore = scoreResult.getScore().get(1).getCategoryAverage();
        float avgMetaScore = scoreResult.getScore().get(2).getCategoryAverage();

        BarChart barChart = (BarChart) findViewById(R.id.bargraph);
        ArrayList<BarEntry> barScore = new ArrayList<>(0);
        ArrayList<BarEntry> barMax = new ArrayList<>();
        ArrayList<BarEntry> barMin = new ArrayList<>();
        ArrayList<BarEntry> barAvg = new ArrayList<>();

        barScore.add( new BarEntry(1f, socialScore));
        barMin.add( new BarEntry(2f, minSocialScore));
        barAvg.add( new BarEntry(3f, avgSocialScore));
        barMax.add( new BarEntry(4f, maxSocialScore));

        barScore.add( new BarEntry(6f, healthScore));
        barMin.add( new BarEntry(7f, minHealthScore));
        barAvg.add( new BarEntry(8f, avgHealthScore));
        barMax.add( new BarEntry(9f, maxHealthScore));

        barScore.add( new BarEntry(11f, metaScore));
        barMin.add( new BarEntry(12f, minMetaScore));
        barAvg.add( new BarEntry(13f, avgMetaScore));
        barMax.add( new BarEntry(14f, maxMetaScore));

        BarDataSet barDataSet1 = new BarDataSet(barScore, "Your Score");
        BarDataSet barDataSet2 = new BarDataSet(barMin, "Minimum Score");
        BarDataSet barDataSet3 = new BarDataSet(barAvg, "Average Score");
        BarDataSet barDataSet4 = new BarDataSet(barMax, "Maximum Score");

        barDataSet1.setColors(Color.parseColor("#fffd6b"));
        barDataSet2.setColors(Color.parseColor("#B8BAFF"));
        barDataSet3.setColors(Color.parseColor("#565ACB"));
        barDataSet4.setColors(Color.parseColor("#363880"));

        //creating the chart
        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4);
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
        legend.setForm(Legend.LegendForm.CIRCLE);
        barChart.setFitBars(true);
        barChart.setTouchEnabled(false);
        barChart.animateY(2000);
        barChart.invalidate();
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
                case R.id.buttonR2:
                    Intent result = new Intent(ResultActivity.this, ResultTextActivity.class);
                    result.putExtra("test", test);
                    startActivity(result);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
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