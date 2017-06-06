package amazon.com.myamazon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by saurabh goyal on 11/23/2015.
 */
public class EventRegistration extends Fragment implements View.OnClickListener {
   public static EditText email;
    public  static EditText pass;
    public  static EditText cllg;
    Boolean flag;
  public static String ev;
    public static LoginEntity dhdh;
    public static EditText eventname;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number

        // Creating view correspoding to the fragment
        View v = inflater.inflate(R.layout.eventreg, container, false);
         email=(EditText)v.findViewById(R.id.name);
         pass=(EditText)v.findViewById(R.id.pass);
         cllg=(EditText)v.findViewById(R.id.cllg);
        eventname=(EditText)v.findViewById(R.id.event);



        Button sign=(Button)v.findViewById(R.id.signup);
        sign.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
         ev=email.getText().toString();
        String tit=email.getText().toString();
        String info= pass.getText().toString();
        String cll= cllg.getText().toString();



        String blankarray[]={tit,info,cll,ev};


        for(int i=0;i<blankarray.length;i++) {

            if ((blankarray[i] == null || blankarray[i].trim().equals(""))) {

                flag = false;
                break;
            }
            else {

                flag = true;

            }
        }
        if(flag==true){

            Toast.makeText(getActivity(), "Event Registered", Toast.LENGTH_SHORT).show();
            Intent p=new Intent(getActivity(),Splash_Activity.class);
            startActivity(p);


        }
        else {
            Toast.makeText(getActivity(), "Please enter all the details", Toast.LENGTH_SHORT).show();

        }
    }
}
