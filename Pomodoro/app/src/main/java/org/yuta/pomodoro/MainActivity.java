package org.yuta.pomodoro;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int i=0;
    int count=0;
    private TextView timerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_layout);


        timerText = (TextView) findViewById(R.id.timer);
        timerText.setText("00:00");
        final CountDown countDown = new CountDown(20000, 100);
        countDown.start();
    }

    class CountDown extends CountDownTimer {

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            // 完了
            i++;
            if(i%2==0) {
                final CountDown countDown = new CountDown(20000, 100);
                countDown.start();
                count++;
            }
            else {
                final CountDown countDown = new CountDown(10000, 100);
                countDown.start();
            }
        }

        // インターバルで呼ばれる
        @Override
        public void onTick(long millisUntilFinished) {
            // 残り時間を分、秒、ミリ秒に分割
            long mm = millisUntilFinished / 1000 / 60;
            long ss = millisUntilFinished / 1000 % 60;

            timerText.setText(String.format("%1$02d:%2$02d", mm, ss));
        }
    }
}

