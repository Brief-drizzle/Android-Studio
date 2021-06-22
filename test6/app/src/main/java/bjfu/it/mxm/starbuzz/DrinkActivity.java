package bjfu.it.mxm.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKID="drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int drinkId=getIntent().getIntExtra(EXTRA_DRINKID,0);
//        Drink drink=Drink.drinks[drinkId];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
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
            
        }catch (SQLException e)
        {
            Log.e("sqlite",e.getMessage());
            Toast toast=Toast.makeText(this,"Datebase unaciliable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}