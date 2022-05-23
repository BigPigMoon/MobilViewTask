package com.example.mobilviewtask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.CalendarView

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var calendarView: CalendarView

    @SuppressLint("ClickableViewAccessibility", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        calendarView = findViewById(R.id.calendarView)

        webView.settings.javaScriptEnabled = true

        val dayToday = 23
        val monthToday = returnCurrectMonth(4)

        var url = "data:text/html, <!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><script>fetch('https://weather.rambler.ru/api/v3/detailed/?all_data=0&url_path=v-novosibirske&date=${dayToday}-${monthToday}').then(r => r.json()).then(data => {document.getElementById(\"date\").innerHTML = \"%D0%94%D0%B0%D1%82%D0%B0: \" + data[\"date_weather\"][\"date\"];document.getElementById(\"temp\").innerHTML = \"%D0%A2%D0%B5%D0%BC%D0%BF%D0%B5%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0: \" + data[\"date_weather\"][\"temperature\"];document.getElementById(\"icon\").innerHTML = \"%D0%A7%D0%B5 %D0%BD%D0%B0 %D1%83%D0%BB%D0%B8%D1%86%D0%B5: \" + data[\"date_weather\"][\"icon\"];document.getElementById(\"ws\").innerHTML = \"%D0%A1%D0%BA%D0%BE%D1%80%D0%BE%D1%81%D1%82%D1%8C %D0%B2%D0%B5%D1%82%D1%80%D0%B0: \" + data[\"date_weather\"][\"wind_speed\"];document.getElementById(\"wd\").innerHTML = \"%D0%9E%D1%82%D0%BA%D1%83%D0%B4%D0%B0 %D0%B2%D0%B5%D1%82%D0%B5%D1%80 %D0%B4%D1%83%D0%B5%D1%82: \" + data[\"date_weather\"][\"wind_direction\"];});</script></head><body><h1 id=\"date\"></h1><p id=\"temp\"></p><p id=\"icon\"></p><p id=\"ws\"></p><p id=\"wd\"></p></body></html>"
        webView.loadUrl(url)

        webView.setOnTouchListener { v, event -> true }
        
        calendarView.setOnDateChangeListener { calendarView, year, month, day ->
            var stringMonth = returnCurrectMonth(month)
            url = "data:text/html, <!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><script>fetch('https://weather.rambler.ru/api/v3/detailed/?all_data=0&url_path=v-novosibirske&date=$day-$stringMonth').then(r => r.json()).then(data => {document.getElementById(\"date\").innerHTML = \"%D0%94%D0%B0%D1%82%D0%B0: \" + data[\"date_weather\"][\"date\"];document.getElementById(\"temp\").innerHTML = \"%D0%A2%D0%B5%D0%BC%D0%BF%D0%B5%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0: \" + data[\"date_weather\"][\"temperature\"];document.getElementById(\"icon\").innerHTML = \"%D0%A7%D0%B5 %D0%BD%D0%B0 %D1%83%D0%BB%D0%B8%D1%86%D0%B5: \" + data[\"date_weather\"][\"icon\"];document.getElementById(\"ws\").innerHTML = \"%D0%A1%D0%BA%D0%BE%D1%80%D0%BE%D1%81%D1%82%D1%8C %D0%B2%D0%B5%D1%82%D1%80%D0%B0: \" + data[\"date_weather\"][\"wind_speed\"];document.getElementById(\"wd\").innerHTML = \"%D0%9E%D1%82%D0%BA%D1%83%D0%B4%D0%B0 %D0%B2%D0%B5%D1%82%D0%B5%D1%80 %D0%B4%D1%83%D0%B5%D1%82: \" + data[\"date_weather\"][\"wind_direction\"];});</script></head><body><h1 id=\"date\"></h1><p id=\"temp\"></p><p id=\"icon\"></p><p id=\"ws\"></p><p id=\"wd\"></p></body></html>"
            webView.loadUrl(url);
        }
    }

    fun returnCurrectMonth(m: Int): String {
        when (m) {
            0 -> return "january"
            1 -> return "february"
            2 -> return "march"
            3 -> return "april"
            4 -> return "may"
            5 -> return "june"
            6 -> return "july"
            7 -> return "august"
            8 -> return "september"
            9 -> return "october"
            10 -> return "november"
            11 -> return "december"
        }

        return ""
    }
}