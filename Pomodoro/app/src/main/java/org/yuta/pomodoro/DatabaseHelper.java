package org.yuta.pomodoro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {

        /*
            ここで任意のデータベースファイル名と、バージョンを指定する
            データベースファイル名 = MyTable.db
            バージョン = 1
         */
        super(context, "MyTable.db", null, 1);
    }

    //onCreateメソッド
    /*
    onCreateメソッドはデータベースを初めて使用する時に実行される処理
    ここでテーブルの作成や初期データの投入を行う
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブルの作成
        db.execSQL("CREATE TABLE SectionCountTable" +
                "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", Date TEXT" +
                ", Count INTEGER" +
                ")");

        // 初期データ投入
        db.execSQL("INSERT INTO SectionCountTable(Date,Count) values (00050226,300);");
        db.execSQL("INSERT INTO SectionCountTable(Date,Count) values (19900118,200);");
        db.execSQL("INSERT INTO SectionCountTable(Date,Count) values (20140809,100);");
    }

    /*
     * onUpgradeメソッド
     * onUpgrade()メソッドはデータベースをバージョンアップした時に呼ばれる
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // とりあえず今回は空でOK
    }
}