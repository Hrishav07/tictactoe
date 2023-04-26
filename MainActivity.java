package com.techyminati.hrishav_tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageclicked=-1;
    int player=1;
    int [][]winstates={{0,1,2},{3,4,5},{6,7,8}};
    int []gamestates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view)
    {
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        if(isWinner==false && imageclicked==-1 ){
            if(player==1) {
                v.setImageResource(R.drawable.x);
                gamestates[tag]=player;
                Toast.makeText(this, tag+""+"cross", Toast.LENGTH_SHORT).show();
                player = 0;
            }
            else
            {
                v.setImageResource(R.drawable.o);
                gamestates[tag]=player;
                Toast.makeText(this, tag+""+"zero", Toast.LENGTH_SHORT).show();
                player=1;
            }
            for(int i=0;i<winstates.length;i++){
                if(gamestates[winstates[i][0]]==gamestates[winstates[i][1]] && gamestates[winstates[i][1]]==gamestates[winstates[i][2]] && gamestates[winstates[i][0]]>-1){
                    Toast.makeText(this, "Winner is "+(player==0?1:0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_image=gridLayout.getChildCount();
        for(int i=0;i<total_image;i++){
            ImageView v =(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageclicked=-1;
        player=1;
        for(int i=0;i<gamestates.length;i++){
            gamestates[i]=-1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}