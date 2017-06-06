package amazon.com.myamazon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by saurabh goyal on 9/17/2015.
 */
public class Login extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number

        // Creating view correspoding to the fragment
        View v = inflater.inflate(R.layout.login, container, false);
        return v;
    }


}
