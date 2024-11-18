package fun.adun.hw_random_colors;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;
    private Button changeColorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);
        changeColorButton = findViewById(R.id.change_color_button);

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackgroundColor();
            }
        });
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        int color = Color.rgb(
                random.nextInt(256), // Генерация случайного значения для красного
                random.nextInt(256), // Генерация случайного значения для зеленого
                random.nextInt(256)  // Генерация случайного значения для синего
        );
        mainLayout.setBackgroundColor(color);
    }
}
