package school.it.ru.canvas_1practice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button faster, slower, direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faster = (Button) findViewById(R.id.faster);
        slower = (Button) findViewById(R.id.slower);
        direction = (Button) findViewById(R.id.direction);
        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDraw m = (MyDraw) findViewById(R.id.ViewMyDraw);
                switch (v.getId()) {
                    case R.id.faster:
                        m.speed += 5;
                        break;
                    case R.id.slower:
                        m.speed -= 5;
                        break;
                    case R.id.direction:
                        m.speed = -m.speed;
                        break;
                }
            }
        };
        faster.setOnClickListener(btn);
        slower.setOnClickListener(btn);
        direction.setOnClickListener(btn);

    }
}
