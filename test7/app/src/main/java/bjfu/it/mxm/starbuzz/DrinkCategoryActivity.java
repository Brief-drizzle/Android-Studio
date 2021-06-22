package bjfu.it.mxm.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Objects;

public class DrinkCategoryActivity extends AppCompatActivity {
    private Cursor cursor;

    public void onDestroy(){
        super.onDestroy();
        cursor.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        ListView listDrink=findViewById(R.id.list_drinks);
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try(SQLiteDatabase db=starbuzzDatabaseHelper.getReadableDatabase()){
            cursor=db.query("DRINK",
                    new String[]{"_id","NAME"},
                    null,null,null,null,null);

            SimpleCursorAdapter listadapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, cursor,
                    new String[]{"NAME"}, new int[]{android.R.id.text1},0);
            listDrink.setAdapter(listadapter);
        }catch (SQLException e){
            Log.e("sqlite", Objects.requireNonNull(e.getMessage()));
            Toast toast=Toast.makeText(this,"Datebase unable",Toast.LENGTH_SHORT);
            toast.show();
        }
        AdapterView.OnItemClickListener itemClickListener=
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(DrinkCategoryActivity.this,
                                DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID,(int)l);
                        startActivity(intent);
                    }
                };
        listDrink.setOnItemClickListener(itemClickListener);

    }
}