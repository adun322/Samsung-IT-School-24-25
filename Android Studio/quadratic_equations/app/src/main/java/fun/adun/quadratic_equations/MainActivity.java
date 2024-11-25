package fun.adun.quadratic_equations;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editA;
    private EditText editB;
    private EditText editC;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editA = findViewById(R.id.editTextA);
        editB = findViewById(R.id.editTextB);
        editC = findViewById(R.id.editTextC);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSolve();
            }
        });
    }

    public void doSolve() {
        String str_a = editA.getText().toString();
        String str_b = editB.getText().toString();
        String str_c = editC.getText().toString();
        String abc = "0123456789";
        double a = Double.parseDouble(str_a);
        if (a == 0) {
            Toast.makeText(MainActivity.this, "Error: Division by 0", Toast.LENGTH_SHORT).show();
            return;
        }
        double b = Double.parseDouble(str_b);
        double c = Double.parseDouble(str_c);
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            tv.setText(String.format("x1 = %.2f, x2 = %.2f", x1, x2));
        } else if (D == 0) {
            double x = (-b) / (2 * a);
            tv.setText("x = " + x);
        } else {
            tv.setText(R.string.complex_plane);
        }

    }
}