package org.yuta.pomodoro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Result extends Activity {
    private static final String[] texts = {
            "abc ", "bcd", "cde", "def", "efg",
            "fgh", 	"ghi", "hij", "ijk", "jkl",
            "klm"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ListView listView = new ListView(this);
        setContentView(R.layout.result_main);
        ListView listView1 = (ListView)findViewById(R.id.listView);
        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, texts);

        listView1.setAdapter(arrayAdapter);
    }
}