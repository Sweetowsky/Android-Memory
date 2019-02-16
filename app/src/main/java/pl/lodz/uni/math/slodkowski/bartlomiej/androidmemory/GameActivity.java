package pl.lodz.uni.math.slodkowski.bartlomiej.androidmemory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class GameActivity extends AppCompatActivity {

    private ArrayList<String> pathList = new ArrayList<String>();
    private int[] Array = {0, 0, 1, 1, 2, 2, 3, 3};
    private int pointCounter =0;
    private long earlierId =99;
    private View earlierView= null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        shuffleArray(Array);


        final GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                
                Toast.makeText(GameActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length -1; i>0; i--){
            int index= rnd.nextInt(i+1);
            int a =ar[index];
            ar[index]=ar[i];
            ar[i]=a;
        }


    }
}
