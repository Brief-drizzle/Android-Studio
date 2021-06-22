package bjfu.it.mxm.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int second=0;
    private boolean running=false;
    private boolean wasrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("life cycle","onCreate");
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            second=savedInstanceState.getInt("second");
            running=savedInstanceState.getBoolean("running");
            wasrunning=savedInstanceState.getBoolean("wasrunning");
        }
        runTime();
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("life cycle","onDestroy");
    }
    protected void onStop() {
        super.onStop();
        Log.d("life cycle","onStop");
    }
    protected void onStart() {
        super.onStart();
        Log.d("life cycle","onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.d("life cycle","onResume");
        if (wasrunning){
            running=true;
        }
    }
    protected void onPause() {
        super.onPause();
        Log.d("life cycle","onPause");
        wasrunning = running;
        running=false;
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("second",second);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasrunning",wasrunning);
    }

    public void onClickStart(View view){
        running=true;
    }

    public void onClickStop(View view){
        running=false;
    }

    public void onClickReset(View view){
        running=false;
        second=0;
    }

    private void runTime(){
        final TextView textView=(TextView) findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        int hour=second/3600;
                        int minute=(second%3600)/60;
                        int seconds=second%60;
                        String time=String.format("%d:%02d:%02d",hour,minute,seconds);
                        textView.setText(time);
                        if (running){
                            second++;
                        }
                        handler.postDelayed(this,1000);
                    }
                }
        );
    }
}