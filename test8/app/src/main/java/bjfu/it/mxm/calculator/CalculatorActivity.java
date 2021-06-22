package bjfu.it.mxm.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorActivity extends AppCompatActivity {
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_0;
    Button btn_c;
    Button btn_ce;
    ImageButton btn_extract;
    Button btn_divide;
    Button btn_multiply;
    Button btn_minus;
    Button btn_plus;
    Button btn_point;
    Button btn_equals;
    EditText et_Text;
    EditText expression_Text;

    double a = 0, result = 0, b = 0;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // 获取页面上的控件
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_ce = (Button) findViewById(R.id.btn_ce);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_multiply = (Button) findViewById(R.id.btn_times);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_equals = (Button) findViewById(R.id.btn_equal);
        btn_extract = (ImageButton)findViewById(R.id.btn_extract);
        et_Text = (EditText) findViewById(R.id.et_Text);
        expression_Text = (EditText) findViewById(R.id.expression_Text);

        et_Text.setText("");
        expression_Text.setText("");

        // 按钮的单击事件
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_1.getText().toString());
                s += btn_1.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_2.getText().toString());
                s += btn_2.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_3.getText().toString());
                s += btn_3.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_4.getText().toString());
                s += btn_4.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_5.getText().toString());
                s += btn_5.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_6.getText().toString());
                s += btn_6.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_7.getText().toString());
                s += btn_7.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_8.getText().toString());
                s += btn_8.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_9.getText().toString());
                s += btn_9.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.append(btn_0.getText().toString());
                s += btn_0.getText().toString();
                expression_Text.setText("");
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.length()>0){
                    s = et_Text.getText().toString();
                    s = s.substring(0, s.length()-1);
                    et_Text.setText(s);
                    expression_Text.setText("");
                }
                expression_Text.setText("");
            }
        });
        btn_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_Text.setText("");
                s = "";
                expression_Text.setText("");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_Text.getText().toString().equals("") && Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1))){
                    et_Text.append("+");
                    expression_Text.setText("");
                }
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_Text.getText().toString().equals("") && Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1))){
                    et_Text.append("/");
                    expression_Text.setText("");
                }
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_Text.getText().toString().equals("") && Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1))){
                    et_Text.append("*");
                    expression_Text.setText("");
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_Text.getText().toString().equals("") || ( Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1)) || et_Text.getText().charAt(et_Text.getText().length()-1) == '√' ) ){
                    et_Text.append("-");
                    expression_Text.setText("");
                }
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_Text.getText().toString().equals("") && Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1))){
                    et_Text.append(".");
                    expression_Text.setText("");
                }
            }
        });
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_Text.getText().toString().equals("") && Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1))){
                    expression_Text.setText(et_Text.getText());
                    expression_Text.append("=");
                    et_Text.setText(calc(et_Text.getText().toString()));
                }

            }
        });
        btn_extract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_Text.getText().toString().equals("") && Character.isDigit(et_Text.getText().charAt(et_Text.getText().length()-1))){
                }
                else{
                    et_Text.append("√");
                    expression_Text.setText("");
                }
                expression_Text.setText("");
            }
        });

    }


    public String calc(String oper){
        while (oper.contains("√")){

            int a = oper.indexOf("√");
            String num = "";
            int b = a+1;
            for(int i=a+1; i<oper.length(); i++){
                if(Character.isDigit(oper.charAt(i)) || oper.charAt(i) == '-'){
                    num += oper.charAt(i);
                    b = i;
                }
                else
                    break;
            }
            if(Double.parseDouble(num) <= 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "开根号的数不能为负数", Toast.LENGTH_SHORT);
                toast.show();
                return "";
            }
            double x = Math.sqrt(Double.parseDouble(num));
            oper = oper.replaceFirst("√"+num, Double.toString(x));


        }
        //1.将运算表达式分离
        //1.1得到所有参与运算的运算符
        List<Character> op = Oper2op(oper);
        //1.2得到所有的参与运算的数字
        List<Double> cha = Oper2cha(oper);

        //遍历运算符容器，完成乘除运算
        for(int i=0;i<op.size();i++){
            Character c = op.get(i);
            if(c=='*'||c=='/'){
                //取得运算符---->把存储的运算符从符号容器中拿出来
                op.remove(i);//是乘除符号则将其从集合中移除出来
                //取得运算数字--->从数字容器中获得对应索引的字符
                Double opl = cha.remove(i);//拿到运算符左侧数字
                Double opr = cha.remove(i);//拿到运算符右侧数字
                //将运算结果放回--->将运算后的数放在数字容器索引出
                if(c=='*'){
                    cha.add(i, opl*opr);//将运算后的数字添加在i的位置，当前i位置的数向后瞬移
                }else{
                    if(opr == 0){
                        Toast toast= Toast.makeText(getApplicationContext(), "除数不能为0", Toast.LENGTH_SHORT);
                        toast.show();
                        return "";
                    }
                    cha.add(i,opl/opr);
                }
                i--;//运算符容器的指针回到原来的位置,防止跳过下一个运算符
            }
        }
        //遍历运算符容器，完成加减运算，当运算符容器为空时，运算结束
        while(!op.isEmpty()){
            //获取运算符
            Character o = op.remove(0);
            //获取左右运算数字
            Double chal = cha.remove(0);
            Double chara = cha.remove(0);
            if(o=='-'){
                chal = chal-chara;
            }
            if(o=='+'){
                chal = chal+chara;
            }
            //将运算结果放回到数字容器中
            cha.add(0,chal);
        }
        return cha.get(0).toString();
    }

    private static List<Character> Oper2op(String oper) {
        //将表达式中的符号替换为@符号
        oper = changeMinus(oper);
        //将字符串按照正则表达式分组
        String regex = "@[0-9]|[0-9]";
        Pattern pt = Pattern.compile(regex);
        String[] split = pt.split(oper);
        //将数组元素放在集合中
        List<Character> list = new ArrayList<>();
        for(int i=0;i<split.length;i++){
            String temp = split[i].trim();
            if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")||temp.equals("√")){
                list.add(temp.trim().charAt(0));
            }
        }
        return list;
    }

    private static List<Double> Oper2cha(String oper) {
        oper = changeMinus(oper);
        //将字符串按照运算符切割，得到字符串数组
        Pattern pt = Pattern.compile("\\+|\\-|\\*|\\/|\\√");
        String[] split = pt.split(oper);

        //遍历数组，判断每个元素，将特殊符号转换成负数符号,并转换成double类型放在list集合中
        List<Double> list = new ArrayList<>();
        for(int i=0;i<split.length;i++){
            String single = split[i];
            if(single.charAt(0)=='@'){
                single = "-"+single.substring(1);
            }
            list.add(Double.parseDouble(single));
        }
        return list;
    }

    private static String changeMinus(String oper) {
        //将表达式中的负数符号使用特殊符号替代，获得没有负数字符串
        for(int i=0;i<oper.length();i++){
            char c = oper.charAt(i);
            if(c=='-'){
                //判断第一个字符是否是负数
                if(i==0){
                    oper = "@"+oper.substring(1);
                }else{
                    //判断前一个字符是否是+-*/中的一个
                    char cprev = oper.charAt(i-1);
                    if(cprev=='+'||cprev=='-'||cprev=='*'||cprev=='/'||cprev=='√'){
                        oper = oper.substring(0, i)+"@"+oper.substring(i+1);
                    }
                }
            }
        }
        return oper;
    }
}