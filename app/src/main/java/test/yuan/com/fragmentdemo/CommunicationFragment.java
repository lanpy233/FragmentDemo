package test.yuan.com.fragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunicationFragment extends Fragment implements View.OnClickListener{

    private Callback mCallback;
    private TextView mCommunicationTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_communication, container, false);
        mCommunicationTv = (TextView) view.findViewById(R.id.communicate_tv);
        mCommunicationTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.communicate_tv:
                mCallback.work();
                break;
        }
    }

    //注册回调
    public void setmCallback(Callback callback){
        this.mCallback = callback;
    }

    //回调接口
    public interface Callback{
        public abstract void work();
    }

}
