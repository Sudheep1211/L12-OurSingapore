package sg.edu.rp.c346.id20024402.oursingapore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Island> IslandList;

    public CustomAdapter (Context context, int resource, ArrayList<Island> objects){
        super (context, resource, objects);

        parent_context = context;
        layout_id = resource;
        IslandList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvArea = rowView.findViewById(R.id.tvArea);
        TextView tvDescription = rowView.findViewById(R.id.tvDescription);

        RatingBar rbStars = rowView.findViewById(R.id.ratingBarStars);


        Island currentIsland = IslandList.get(position);


        tvName.setText(currentIsland.getName());
        tvDescription.setText(currentIsland.getDescription());
        tvArea.setText(currentIsland.getArea() + "");

        if(currentIsland.getRating() == 1){
            rbStars.setRating(1);

        } if (currentIsland.getRating() == 2){
            rbStars.setRating(2);

        } if (currentIsland.getRating() == 3){
            rbStars.setRating(3);

        } if (currentIsland.getRating() == 4){
            rbStars.setRating(4);

        } if (currentIsland.getRating() == 5){
            rbStars.setRating(5);

        }

        return rowView;
    }
}
