package sg.edu.rp.c346.id20024402.oursingapore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Island> IslandList;
    // ArrayAdapter adapter;
    CustomAdapter caIsland;
    String moduleCode;
    int requestCode = 9;
    Button btn5Stars;

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(this);
        IslandList.clear();
        IslandList.addAll(dbh.getAllIslands());
        caIsland.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("My Singapore ~ Show Islands");

        lv = (ListView) this.findViewById(R.id.lv);
        btn5Stars = (Button) this.findViewById(R.id.btnShow5Stars);

        DBHelper dbh = new DBHelper(this);
        IslandList = dbh.getAllIslands();
        dbh.close();

        caIsland = new CustomAdapter(this, R.layout.row, IslandList);
        lv.setAdapter(caIsland);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("island", IslandList.get(position));
                startActivityForResult(i, requestCode);
            }
        });

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                IslandList.clear();
                IslandList.addAll(dbh.getAllIslandsByRating(5));
                caIsland.notifyDataSetChanged();
            }
        });


    }
}
