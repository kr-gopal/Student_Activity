package amazon.com.myamazon;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

public class Tab2PagerAdapter extends FragmentPagerAdapter {
   int[] icons;
    String[] tabs;
    Context context;

    public Tab2PagerAdapter(FragmentManager fm, String[] tabs, FragmentActivity activity) {
        super(fm);
this.tabs=tabs;
        this.icons=icons;
        this.context=activity;
    }
    Fragment fragment;

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                fragment= new EventList();

                break;
            case 1:
                fragment= new RegisterST();

                //     fragment=new EventRegistration();
                break;

       //     fragment=new SignUpActivity();

        case 2:
        fragment= new Student();

        //     fragment=new EventRegistration();
        break;

        //     fragment=new SignUpActivity();

    case 3:
    fragment= new Name();

    //     fragment=new EventRegistration();
    break;
            case 4:
                fragment= new Sponsors();

                //     fragment=new EventRegistration();
                break;
    //     fragment=new SignUpActivity();
}

return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //for images
//        Drawable drawable=context.getResources().getDrawable(icons[position]);
//        drawable.setBounds(0,0,36,36);
//        ImageSpan imageSpan=new ImageSpan(drawable);
//        SpannableString spannableString=new SpannableString(" ");
//        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return spannableString;

        return tabs[position];
    }

    @Override
    public int getCount() {
        return 5;
    }
}