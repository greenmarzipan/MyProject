package space.myapp.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfterChooseFamily extends AppCompatActivity {
    public int currentSituation = 0;
    MainActivity m = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_choose_family);
        final Button goButton = (Button) findViewById(R.id.FamilyGoButton);
        final TextView nameText = (TextView) findViewById(R.id.FamilyTNameTextview);
        final TextView text = (TextView) findViewById(R.id.FamilyTextview);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.FamilyLinearLayout);
        final LinearLayout characterLayout = (LinearLayout) findViewById(R.id.FamilyCharacter);
        Table t = new Table();
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSituation == t.familyImageFirst.length){
                    try{
                        Intent intent = new Intent(AfterChooseFamily.this, CharputChoose.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        System.out.println("ошибка при переходе из первоо эпизода в актвность выбора");
                        e.printStackTrace();
                    }
                }
                if (m.getCurrentEpisode() == 1) {
                    if (currentSituation < t.familyImageFirst.length) {
                        if (t.familyImageFirst[currentSituation] == 0) {
                            characterLayout.setBackgroundResource(R.drawable.empty0);
                        } else if (t.familyImageFirst[currentSituation] == 2) {
                            characterLayout.setBackgroundResource(R.drawable.mothertravel2);
                        } else if (t.familyImageFirst[currentSituation] == 3) {
                            characterLayout.setBackgroundResource(R.drawable.fathertravel3);
                        } else if (t.familyImageFirst[currentSituation] == 4) {
                            characterLayout.setBackgroundResource(R.drawable.laura4);
                        }
                        text.setText(t.familyTextFirst[currentSituation]);
                        nameText.setText(t.familyNameFirst[currentSituation]);
                        currentSituation++;
                        if (currentSituation == 2) {
                            linearLayout.setBackgroundResource(R.drawable.kitchen);
                        } else if (currentSituation == 4) {
                            linearLayout.setBackgroundResource(R.drawable.laurascar);
                        } else if (currentSituation == 7) {
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