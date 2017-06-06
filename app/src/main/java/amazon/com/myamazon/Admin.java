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
public class Admin extends Fragment {
   public static String l;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number

        // Creating view correspoding to the fragment
        View v = inflater.inflate(R.layout.admin, container, false);
        TextView h=(TextView)v.findViewById(R.id.value);
        h.setText(RegisterST.dhdh);
        Button p=(Button)v.findViewById(R.id.accept);
        Button k=(Button)v.findViewById(R.id.reject);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
l=RegisterST.dhdh;
                Toast.makeText(getActivity(), "Event Approved", Toast.LENGTH_SHORT).show();
                Intent g=new Intent(getActivity(),Splash_Activity.class);
                startActivity(g);


            }
        });

k.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "Event Rejected", Toast.LENGTH_SHORT).show();
        l=" ";

        Intent g=new Intent(getActivity(),Splash_Activity.class);
        startActivity(g);
    }
});
        return v;
    }
}
