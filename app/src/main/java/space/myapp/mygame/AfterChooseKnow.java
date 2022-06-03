package space.myapp.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterChooseKnow extends AppCompatActivity {
    public int currentSituation = 0;
    MainActivity m = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_choose_know);
        final Button goButton = (Button) findViewById(R.id.KnowGoButton);
        final TextView nameText = (TextView) findViewById(R.id.KnowTNameTextview);
        final TextView text = (TextView) findViewById(R.id.KnowTextview);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.KnowLinearLayout);
        final LinearLayout characterLayout = (LinearLayout) findViewById(R.id.KnowCharacter);
        Table t = new Table();
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSituation == t.knowImageFirst.length){
                    try{
                        Intent intent = new Intent(AfterChooseKnow.this, CharputChoose.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        System.out.println("ошибка при переходе из первоо эпизода в актвность выбора");
                        e.printStackTrace();
                    }
                }
                if (m.getCurrentEpisode() == 1) {
                    if (currentSituation < t.knowImageFirst.length) {
                        if (t.knowImageFirst[currentSituation] == 0) {
                            characterLayout.setBackgroundResource(R.drawable.empty0);
                        } else if (t.knowImageFirst[currentSituation] == 2) {
                            characterLayout.setBackgroundResource(R.drawable.mothertravel2);
                        } else if (t.knowImageFirst[currentSituation] == 4) {
                            characterLayout.setBackgroundResource(R.drawable.laura4);
                        }
                        text.setText(t.knowTextFirst[currentSituation]);
                        nameText.setText(t.knowNameFirst[currentSituation]);
                        currentSituation++;
                        if (currentSituation == 2) {
                            linearLayout.setBackgroundResource(R.drawable.secondfloor);
                        } else if (currentSituation == 5) {
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