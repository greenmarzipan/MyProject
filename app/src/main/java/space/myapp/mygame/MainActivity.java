package space.myapp.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int currentEpisode = 1;
    int friends = 0;
    int know = 0;
    int family = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButton.setBackgroundResource(R.drawable.startbuttononclick);
                try{
                    Intent intent = new Intent(MainActivity.this, CharputChoose.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    System.out.println("y");
                    e.printStackTrace();
                }
            }
        });
    }
    public int getCurrentEpisode(){
        return currentEpisode;
    }
    public int getStateFriends(){
        return friends;
    }
    public int getStateFamily(){
        return family;
    }
    public int getStateKnow(){
        return know;
    }
    public void changeCurrentEpisode(){
        currentEpisode += 1;
    }
    public void changeStateFriends(int a){
        friends += a;
    }
    public void changeStateFamily(int a){
        family += a;
    }
    public void changeStateKnow(int a){
        know += a;
    }
}