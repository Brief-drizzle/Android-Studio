package bjfu.it.mxm.starbuzz;

import androidx.annotation.NonNull;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] drinks={
            new Drink("latte","A couple of espresso shots with steamed milk",
                    R.drawable.latte),
            new Drink("cappuccino","espresso,hotmilk,and a steamed milk foam",
                    R.drawable.cappuccino),
            new Drink("filter","hightest quality beans roasted and brewed fresh",
                    R.drawable.filter)
    };

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
