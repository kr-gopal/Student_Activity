package amazon.com.myamazon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import amazon.com.myamazon.tabs.TabLayout;

/**
 * Created by saurabh goyal on 11/24/2015.
 */
public class RegisterST extends Fragment implements View.OnClickListener {
    EditText email;
    EditText price;
    static String ev;
    static String ek;
    boolean flag;

    public static String dhdh;
    public static ArrayList<String>p=new ArrayList<String>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number

        // Creating view correspoding to the fragment
        View v = inflater.inflate(R.layout.restk, container, false);
        email=(EditText)v.findViewById(R.id.name);
        price=(EditText)v.findViewById(R.id.pr);


        Button submit=(Button)v.findViewById(R.id.signup);
        submit.setOnClickListener(this);




        return v;
    }


    @Override
    public void onClick(View view) {


        ek = price.getText().toString();
        ev = email.getText().toString();


        String blankarray[] = {ek, ev};


        for (int i = 0; i < blankarray.length; i++) {

            if ((blankarray[i] == null || blankarray[i].trim().equals(""))) {

                flag = false;
                break;
            } else {

                flag = true;

            }
        }
        if (flag == true) {

            if (ev != null) {
                dhdh = ev;

            } else {
                dhdh = "No events";
            }

            Toast.makeText(getActivity(), "Event Detail Submitted", Toast.LENGTH_SHORT).show();

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            Intent k = new Intent(getActivity(), Splash_Activity.class);
            startActivity(k);
        } else {
            Toast.makeText(getActivity(), "Please enter all the details", Toast.LENGTH_SHORT).show();

        }
    }


}
