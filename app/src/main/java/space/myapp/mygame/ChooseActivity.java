package space.myapp.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    MainActivity m = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        final Button chooseOne = (Button) findViewById(R.id.ChooseOneButton);
        final Button chooseTwo = (Button) findViewById(R.id.ChooseTwoButton);
        final Button chooseThree = (Button) findViewById(R.id.ChooseThreeButton);
        final TextView text = (TextView) findViewById(R.id.ChooseTextview);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.chooseLinearLayout);

         int currentEpisode = m.getCurrentEpisode();
         if (currentEpisode == 1){
             text.setText("/Чем бы мне заняться?/");
             chooseOne.setText("Наверно спущусь к маме с папой. Я бы хотела провести время с ними.");
             chooseTwo.setText("Может проуляться и зайти к соседям познакомиться?");
             chooseThree.setText("Родители снизу, может посмотреть у них в комнате, " +
                     "что за документы подписывал папа?");
             linearLayout.setBackgroundResource(R.drawable.laurasbedroom);
         }


        chooseOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.changeStateFamily(1);
                String toastText = "Новый уровень семейных отношений: " + m.getStateFamily();
                showToast(toastText);
                try{
                    Intent intent = new Intent(ChooseActivity.this, AfterChooseFamily.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    System.out.println("ошибка при переходе из выбора в эпизод");
                    e.printStackTrace();
                }
            }
        });
        chooseTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.changeStateFriends(1);
                String toastText = "Новый уровень коммуникабельности: " + m.getStateFriends();
                showToast(toastText);
                try{
                    Intent intent = new Intent(ChooseActivity.this, AfterChooseFriends.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    System.out.println("ошибка при переходе из выбора в эпизод");
                    e.printStackTrace();
                }
            }
        });
        chooseThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.changeStateKnow(1);
                String toastText = "Новый уровень знаний: " + m.getStateKnow();
                showToast(toastText);
                try{
                    Intent intent = new Intent(ChooseActivity.this, AfterChooseKnow.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    System.out.println("ошибка при переходе из выбора в эпизод");
                    e.printStackTrace();
                }
            }
        });


    }
    public void showToast(String toastText){
        Toast toast = Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_SHORT);
        toast.show();

    }
}
