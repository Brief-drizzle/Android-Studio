package bjfu.it.mxm.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKID="drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkId=getIntent().getIntExtra(EXTRA_DRINKID,0);
//        Drink drink=Drink.drinks[drinkId];
        //ListView listDrink = findViewById(R.id.list_drinks);
//
//        ImageView photo=findViewById(R.id.photo);
//        photo.setImageResource(drink.getImageResourceId());
//        photo.setContentDescription(drink.getName());
//
//        TextView name=findViewById(R.id.name);
//        name.setText(drink.getName());
//
//        TextView description=findViewById(R.id.description);
//        description.setText(drink.getDescription());
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try(SQLiteDatabase db=starbuzzDatabaseHelper.getReadableDatabase()) {
//            Cursor cursor = db.query("DRINK",
//                    new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
//                    "id=?",
//                    new String[]{Integer.toString(drinkId)},
//                    null,null,null);
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID","FAVOURITE"},
                    "_id=?",
                    new String[]{Integer.toString(drinkId)},
                    null,null,null);


            if (cursor.moveToFirst()){
                String nameText=cursor.getString(0);
                String description=cursor.getString(1);
                int posId=cursor.getInt(2);
                boolean isFavourite=(cursor.getInt(3)==1);

                TextView name=findViewById(R.id.name);
                name.setText(nameText);
                TextView descriptions=findViewById(R.id.description);
                descriptions.setText(description);
                ImageView photo=findViewById(R.id.photo);
                photo.setImageResource(posId);
                photo.setContentDescription(nameText);
                CheckBox favourite=findViewById(R.id.favourite);
                favourite.setChecked(isFavourite);
            }
            cursor.close();
        }catch (SQLException e)
        {
            Log.e("sqlite",e.getMessage());
            Toast toast=Toast.makeText(this,"Datebase unaciliable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onFavouriteClicked(View view) {
        CheckBox favourite=(CheckBox) view;
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("FAVOURITE",favourite.isChecked());
        int drinkId=getIntent().getIntExtra(EXTRA_DRINKID,0);
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try(SQLiteDatabase db=starbuzzDatabaseHelper.getReadableDatabase()){
            int row = db.update("DRINK",drinkValues,
                    "_id=?",
                    new String[]{Integer.toString(drinkId)});
             Log.d("sqlite","update row"+row);
        }catch (SQLException e){
            Log.e("sqlite",e.getMessage());
            Toast toast = Toast.makeText(this,"Database unwriteable",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}