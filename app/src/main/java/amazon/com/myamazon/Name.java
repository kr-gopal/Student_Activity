package amazon.com.myamazon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by saurabh goyal on 11/24/2015.
 */
public class Name extends Fragment {
   public static String l;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number

        // Creating view correspoding to the fragment
        View v = inflater.inflate(R.layout.name, container, false);
        Button j=(Button)v.findViewById(R.id.Logout);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Log Out", Toast.LENGTH_SHORT).show();
                Intent p=new Intent(getActivity(),Splash_Activity.class);
                startActivity(p);
            }
        });

        TextView h=(TextView)v.findViewById(R.id.value);
        h.setText(EventRegistration.ev);

        return v;
    }
}
