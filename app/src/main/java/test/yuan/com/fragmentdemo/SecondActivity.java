package test.yuan.com.fragmentdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class SecondActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        addFragment();

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               replaceFragment();
            }
        });
    }

    /**
     * 添加一个fragment到一个容器时，必须确保当前容器是空的；
     */
    public void addFragment(){
        MainFragment1 mainFragment1 = new MainFragment1();
        //FragmentTransaction是独立的，一旦commit，无法再复用当前FragmentTransaction；
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,mainFragment1).commit();
    }

    /**
     * 替换一个fragment到一个容器时，当前容器可以不为空；
     * 如果替换后返回栈，需要显示替换前的fragment：fragmentTransaction1.addToBackStack(null);
     */
    public void replaceFragment(){
        final MainFragment2 mainFragment2 = new MainFragment2();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame_layout,mainFragment2);
        fragmentTransaction1.addToBackStack(null);       //回退栈的时候会返回替换前的fragment;
        fragmentTransaction1.commit();
    }
}
