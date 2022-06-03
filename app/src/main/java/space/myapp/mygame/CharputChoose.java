package space.myapp.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CharputChoose extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charpet_choose);
        MainActivity m = new MainActivity();
        final TextView FamilyState = (TextView) findViewById(R.id.familyState);
        final TextView FriendsState = (TextView) findViewById(R.id.friendsState);
        final TextView KnowState = (TextView) findViewById(R.id.knowState);
        final Button buttonCharpetOne = (Button) findViewById(R.id.charpetOne);
        buttonCharpetOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(CharputChoose.this, FirstEpide.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    System.out.println("y");
                    e.printStackTrace();
                }
            }
        });
    }
}