package com.example.p2.frontend;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.p2.R;
import com.example.p2.backend.questionnaire.Score;
import com.example.p2.backend.questionnaire.Test;


public class Result_Chart extends AppCompatActivity {

    private Score scoreResult;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Test test = intent.getParcelableExtra("test");
        scoreResult = test.getScore();

        setContentView(R.layout.activity_result_wip);
        WebView webview = findViewById(R.id.webView1);
        String content = String.format(
                scoreResult.getStringLocale(),
                "<html>"
                + "  <head>"
                + "    <script type=\"text/javascript\" src=\"jsapi.js\"></script>"
                + "    <script type=\"text/javascript\">"
                + "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
                + "      google.setOnLoadCallback(drawChart);"
                + "      function drawChart() {"
                + "        var data = google.visualization.arrayToDataTable(["
                + "          ['Year', 'Sales', 'Expenses'],"
                + "          ['2010',  1000,      400],"
                + "          ['2011',  1170,      460],"
                + "          ['2012',  660,       1120],"
                + "          ['2013',  1030,      540]"
                + "        ]);"
                + "        var options = {"
                + "          title: 'Truiton Performance',"
                + "          hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}"
                + "        };"
                + "        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));"
                + "        chart.draw(data, options);"
                + "      }"
                + "    </script>"
                + "  </head>"
                + "  <body>"
                + "    <div id=\"chart_div\" style=\"width: 1000px; height: 500px;\"></div>"
                + "	   <img style=\"padding: 0; margin: 0 0 0 330px; display: block;\" src=\"truiton.png\"/>"
                + "  </body>" + "</html>",
                scoreResult.getJSArrayString());

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.requestFocusFromTouch();
        webview.loadDataWithBaseURL( "file:///android_asset/", content, "text/html", "utf-8", null );
    }
}
