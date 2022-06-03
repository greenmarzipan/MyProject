package space.myapp.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterChooseFriends extends AppCompatActivity {
    public int currentSituation = 0;
    MainActivity m = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_choose_friends);
        final Button goButton = (Button) findViewById(R.id.FriendsGoButton);
        final TextView nameText = (TextView) findViewById(R.id.FriendsTNameTextview);
        final TextView text = (TextView) findViewById(R.id.FriendsTextview);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.FriendsLinearLayout);
        final LinearLayout characterLayout = (LinearLayout) findViewById(R.id.FriendsCharacter);
        Table t = new Table();
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSituation == t.friendsImageFirst.length){
                    try{
                        Intent intent = new Intent(AfterChooseFriends.this, CharputChoose.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        System.out.println("ошибка");
                        e.printStackTrace();
                    }
                }
                if (m.getCurrentEpisode() == 1) {
                    if (currentSituation < t.friendsImageFirst.length) {
                        if (t.friendsImageFirst[currentSituation] == 0) {
                            characterLayout.setBackgroundResource(R.drawable.empty0);
                        } else if (t.friendsImageFirst[currentSituation] == 2) {
                            characterLayout.setBackgroundResource(R.drawable.mothertravel2);
                        } else if (t.friendsImageFirst[currentSituation] == 4) {
                            characterLayout.setBackgroundResource(R.drawable.laura4);
                        } else if (t.friendsImageFirst[currentSituation] == 5) {
                            characterLayout.setBackgroundResource(R.drawable.mary5);
                        }
                        text.setText(t.friendsTextFirst[currentSituation]);
                        nameText.setText(t.friendsNameFirst[currentSituation]);
                        currentSituation++;
                        if (currentSituation == 2) {
                            linearLayout.setBackgroundResource(R.drawable.kitchen);
                        } else if (currentSituation == 4) {
                            linearLayout.setBackgroundResource(R.drawable.laurashouse);
                        } else if (currentSituation == 12) {
                            linearLayout.setBackgroundResource(R.drawable.kitchen);
                        }

                    }
                }

            }
        });

    }
    public int getCurrentSituationFamily(){
        return currentSituation;
    }
}