package drinkprime.com.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PurifierActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purifier);

        Button butn = (Button)findViewById(R.id.button3);
        butn.setHeight(30);
        butn.setWidth(70);
    }
}
