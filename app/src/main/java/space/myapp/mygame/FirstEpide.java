package space.myapp.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstEpide extends AppCompatActivity {
    public int currentSituation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_episode);
        final Button goButton = (Button) findViewById(R.id.FirstGoButton);
        final TextView nameText = (TextView) findViewById(R.id.FirstNameTextview);
        final TextView text = (TextView) findViewById(R.id.FirstTextview);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.firstLinearLayout);
        final LinearLayout characterLayout = (LinearLayout) findViewById(R.id.firstCharacter);
        Table t = new Table();
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSituation == t.firstScenario.length){
                    try{
                        Intent intent = new Intent(FirstEpide.this, ChooseActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        System.out.println("ошибка при переходе из первоо эпизода в актвность выбора");
                        e.printStackTrace();
                    }
                }
                if (currentSituation < t.firstScenario.length) {
                    if (t.firstImage[currentSituation] == 0) {
                        characterLayout.setBackgroundResource(R.drawable.empty0);
                    } else if (t.firstImage[currentSituation] == 1) {
                        characterLayout.setBackgroundResource(R.drawable.lauratravel1);
                    } else if (t.firstImage[currentSituation] == 2) {
                        characterLayout.setBackgroundResource(R.drawable.mothertravel2);
                    } else if (t.firstImage[currentSituation] == 3) {
                        characterLayout.setBackgroundResource(R.drawable.fathertravel3);
                    }
                    text.setText(t.firstScenario[currentSituation]);
                    nameText.setText(t.firstName[currentSituation]);
                    currentSituation++;
                    if (currentSituation == 12) {
                        linearLayout.setBackgroundResource(R.drawable.dangerroad);
                    } else if (currentSituation == 14) {
                        linearLayout.setBackgroundResource(R.drawable.strangebuilding);
                    }else if (currentSituation == 22) {
                        linearLayout.setBackgroundResource(R.drawable.roadwithbanner);
                    }else if (currentSituation == 24) {
                        linearLayout.setBackgroundResource(R.drawable.roadwithfarhoses);
                    }
                    else if (currentSituation == 27) {
                        linearLayout.setBackgroundResource(R.drawable.laurashouse);
                    }else if (currentSituation == 36) {
                        linearLayout.setBackgroundResource(R.drawable.hall);
                    }else if (currentSituation == 37) {
                        linearLayout.setBackgroundResource(R.drawable.kitchen);
                    }else if (currentSituation == 40) {
                        linearLayout.setBackgroundResource(R.drawable.secondfloor);
                    }else if (currentSituation == 42) {
                        linearLayout.setBackgroundResource(R.drawable.parentsbedroom);
                    }else if (currentSituation == 44) {
                        linearLayout.setBackgroundResource(R.drawable.laurasbedroom);
                    }

                }

            }
        });

    }
    public int getCurrentSituationOne(){
        return currentSituation;
    }
}