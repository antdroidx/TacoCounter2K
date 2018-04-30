package antdroid.tacocounter2k;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int tacos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tacos = 0;

        final ImageButton tacoCounter = findViewById(R.id.tacoButton);
        final Button resetCounter = findViewById(R.id.resetButton);
        final Button tutorial = findViewById(R.id.helpButton);
        final TextView counter = findViewById(R.id.counter);

        resetCounter.setText("Reset Taco Counter");

        counter.setText(Integer.toString(tacos));

        tacoCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tacos++;
                counter.setText(Integer.toString(tacos));
            }
        });

        resetCounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tacos = 0;
                counter.setText(Integer.toString(tacos));
            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Welcome to Taco Counter 2K!\n\nWhen you eat a taco, click the taco. Once you're finished eating tacos, look at how many tacos you ate! Then press the Reset button to start over!")
                        .setTitle("Taco Counter Help")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                TextView textView = dialog.findViewById(android.R.id.message);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

            }
        });

    }

}
