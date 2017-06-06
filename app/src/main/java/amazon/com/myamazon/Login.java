package amazon.com.myamazon;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import amazon.com.myamazon.tabs.TabLayout;

/**
 * Created by saurabh goyal on 9/17/2015.
 */
public class Login extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
public static EditText username;
    public  static EditText password;
    public static Spinner methods;
    public  static Button sign;
    Boolean flag;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the currently selected item number

        // Creating view correspoding to the fragment
        View v = inflater.inflate(R.layout.login, container, false);
        username=(EditText)v.findViewById(R.id.username);
        password=(EditText)v.findViewById(R.id.password);
         methods=(Spinner)v.findViewById(R.id.spinner);
         sign=(Button)v.findViewById(R.id.signup);

        String[] mmethod = getResources().getStringArray(R.array.method);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, mmethod);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        methods.setAdapter(adapter);
        methods.setOnItemSelectedListener(this);
         sign.setOnClickListener(this);



        return v;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
//        String log="logi";
//LoginEntity login=new LoginEntity();
//        login.setUsername(username.getText().toString());
//        login.setPassword(password.getText().toString());
//        login.setMethod((String) methods.getSelectedItem().toString());
//        writeToSharedPref(getActivity(),log,login);
        String tit=username.getText().toString();
        String info= password.getText().toString();
        String blankarray[]={tit,info};


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

            Toast.makeText(getActivity(), "LoginSuccessfull", Toast.LENGTH_SHORT).show();
            String K=((String) methods.getSelectedItem().toString());

           if( K.equals("STUDENT")){
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               TabLayout3 rFragment = new TabLayout3();
               FragmentTransaction ft = fragmentManager.beginTransaction();
               ft.replace(R.id.content_frame, rFragment);
               ft.commit();

            }
            if(K.equals("EMC")){
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Tab2Layout rFragment = new Tab2Layout();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.content_frame, rFragment);
                ft.commit();
            }
           if( K.equals("ADMINITRATION")){
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
              Admin rFragment = new Admin();
               FragmentTransaction ft = fragmentManager.beginTransaction();
               ft.replace(R.id.content_frame, rFragment);
               ft.commit();
            }

        }
        else {
            Toast.makeText(getActivity(), "Please enter all the details", Toast.LENGTH_SHORT).show();

        }

    }

    public static void writeToSharedPref(Context context,String key,LoginEntity value){
        SharedPreferences data=context.getSharedPreferences("cashSavvy", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=data.edit();
        edit.putString(key, String.valueOf(value));
        edit.apply();//apply faster asyhccronous edit.commit() is slower and shynchronous

    }
}
