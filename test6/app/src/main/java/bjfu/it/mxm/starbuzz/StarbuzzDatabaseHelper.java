package bjfu.it.mxm.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper{
    private static final String name="starbuzz.db";
    private static final int version=3;

    public StarbuzzDatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINK (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"NAME TEXT,"
                +"DESCRIPTION TEXT,"
                +"IMAGE_RESOURCE_ID INTEGER);");
        insertDrink(db,"Latte","Espresso and steamed milk",R.drawable.latte);
        insertDrink(db,"Cappuccion","Espresso,hot milk and steamed mild foam",
                R.drawable.cappuccino);
        insertDrink(db,"Filter","Our best drip coffee",R.drawable.filter);
    }

    private static void insertDrink(SQLiteDatabase db,String name,String description,int resourceId){
        ContentValues drinkValues=new ContentValues();
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        long result = db.insert("DRINK",null,drinkValues);
        Log.d("sqlite","insert "+name+",id:"+result);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i<=1){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVOURITE NUMERIC;");
        }
        if (i<=2){
            ContentValues latteDesc=new ContentValues();
            latteDesc.put("DESCRIPTION","Tasty");
            db.update("DRINK",latteDesc,"NAME=?",new String[]{"Latte"});
        }
    }
}
