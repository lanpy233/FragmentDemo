package test.yuan.com.fragmentdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CommunicationActivity extends AppCompatActivity implements CommunicationFragment.Callback{

    private CommunicationFragment mCommunicationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        addCommunicationFragment();
        mCommunicationFragment.setmCallback(this);

    }

    private void addCommunicationFragment(){
        mCommunicationFragment = new CommunicationFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,mCommunicationFragment).commit();
    }

    @Override
    public void work() {
        Toast.makeText(CommunicationActivity.this,"work excuted",Toast.LENGTH_LONG).show();
    }
}
