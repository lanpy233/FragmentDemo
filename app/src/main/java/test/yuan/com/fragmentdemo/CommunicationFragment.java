package test.yuan.com.fragmentdemo;


import android.content.Context;
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
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception

        if(context instanceof Callback){
            mCallback = (Callback) context;
        }else {
            throw new RuntimeException(context.toString()
                    + " must implement Callback");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_communication, container, false);
        mCommunicationTv = (TextView) view.findViewById(R.id.communicate_tv);
        mCommunicationTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.communicate_tv:
                if(mCallback != null){
                    mCallback.work();
                }
                break;
        }
    }

    //回调接口
    public interface Callback{
        public abstract void work();
    }

}
