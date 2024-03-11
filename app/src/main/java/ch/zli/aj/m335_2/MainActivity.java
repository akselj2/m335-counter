package ch.zli.aj.m335_2;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    //private TextView textView = findViewById(R.id.counter);

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int s1 = sh.getInt("counter", 0);

        TextView textView = findViewById(R.id.counter);

        textView.setText(String.valueOf(s1));

        this.count = s1;

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();

        editor.putInt("counter", count);

        editor.apply();
    }

    public void countUp(View view) {
        TextView textView = (TextView)findViewById(R.id.counter);

        count++;

        textView.setText("" + count);
    }

    public void countDown(View view) {
        TextView textView = (TextView)findViewById(R.id.counter);

        count--;

        textView.setText("" + count);
    }

    public void reset(View view) {
        TextView textView = (TextView)findViewById(R.id.counter);

        count = 0;

        textView.setText("" + count);
    }
}