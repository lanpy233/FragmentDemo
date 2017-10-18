package test.yuan.com.fragmentdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
    }
}
