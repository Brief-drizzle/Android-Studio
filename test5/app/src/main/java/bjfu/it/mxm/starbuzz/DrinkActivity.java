package bjfu.it.mxm.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKID="drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int drinkId=getIntent().getIntExtra(EXTRA_DRINKID,0);
        Drink drink=Drink.drinks[drinkId];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        ImageView photo=findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        TextView name=findViewById(R.id.name);
        name.setText(drink.getName());

        TextView description=findViewById(R.id.description);
        description.setText(drink.getDescription());
    }
}