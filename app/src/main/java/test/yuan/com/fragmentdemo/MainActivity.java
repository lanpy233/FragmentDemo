package test.yuan.com.fragmentdemo;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.linearlayout1,new MainFragment1());
        transaction.commit();

        FragmentTransaction transaction2 =  getSupportFragmentManager().beginTransaction();
        transaction2.add(R.id.linearlayout2,new MainFragment2());
        transaction2.commit();

        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
