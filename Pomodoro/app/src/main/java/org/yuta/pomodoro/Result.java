package org.yuta.pomodoro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import java.util.ArrayList;

public class Result extends Activity {
    private static final String[] texts = {
            "abc ", "bcd", "cde", "def", "efg",
            "fgh", 	"ghi", "hij", "ijk", "jkl",
            "klm"
    };
    private ArrayList<String> data = new ArrayList<String>();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor c = db.query("SectionCountTable", new String[] { "Date", "Count" }, null, null, null, null, null);

        ListView listView = new ListView(this);

        boolean mov = c.moveToFirst();

        while (mov) {
           data.add(String.format("%s : %s", c.getString(0),
                   c.getInt(1)));
            mov = c.moveToNext();
        }


        setContentView(R.layout.result_main);
        ListView listView1 = (ListView)findViewById(R.id.listView);
        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        listView1.setAdapter(arrayAdapter);

        c.close();
        db.close();
    }
}