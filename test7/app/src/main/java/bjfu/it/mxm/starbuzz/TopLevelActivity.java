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
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {
    private Cursor favouriteCursor;
    private SQLiteDatabase db;

    public void onDestroy(){
        super.onDestroy();
        db.close();
        favouriteCursor.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        setupOptionsListView();
        setupFavouriteListView();
    }

    private void setupOptionsListView() {
        AdapterView.OnItemClickListener itemClickListener=
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i==0){
                            Intent intent=new Intent(TopLevelActivity.this,
                                    DrinkCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        ListView listView=findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
    private void setupFavouriteListView(){
        ListView listFavourites = findViewById(R.id.list_favourite);
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            db=  starbuzzDatabaseHelper.getReadableDatabase();
            favouriteCursor = db.query("DRINK",
                    new String[]{"_id","NAME"},
                    "FAVOURITE = 1",
                    null,null,null,null);
            CursorAdapter favouriteAdapter =
                    new SimpleCursorAdapter(TopLevelActivity.this,
                            android.R.layout.simple_list_item_1,favouriteCursor,
                            new String[]{"NAME"},
                            new int[]{android.R.id.text1},0);
            listFavourites.setAdapter(favouriteAdapter);
        }catch (SQLException e){
            Log.e("sqlite",e.getMessage());
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
        listFavourites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TopLevelActivity.this,DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKID,(int)l);
                startActivity(intent);
            }
        });
    }

    public void onRestart() {

        super.onRestart();
        Cursor newcursor = db.query("DRINK",
                new String[]{"_id","NAME"},"FAVOURITE=1",
                null,null,null,null);
        ListView listFavourites = findViewById(R.id.list_favourite);
        CursorAdapter adapter = (CursorAdapter)listFavourites.getAdapter();
        adapter.changeCursor(newcursor);
        favouriteCursor = newcursor;
    }
}