package bjfu.it.mxm.ProgramAdviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final ProgramExpert expert=new ProgramExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View button){
        //获得Spinner引用
        Spinner spinner=findViewById(R.id.feature);
        //获得Spinner选项
        String feature=spinner.getSelectedItem().toString();
        //查询模型层
        String language=expert.getLanguage(feature);
        //获得TextView引用
        TextView textView=findViewById(R.id.language);
        //获得TextView文字
        textView.setText(language);
    }
}