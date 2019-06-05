package come.example.qiaowenhao.practicesapt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import come.example.qiaowenhao.annotationlib.Test;

@Test(path = "main")
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
