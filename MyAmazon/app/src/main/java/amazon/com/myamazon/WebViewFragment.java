package amazon.com.myamazon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by saurabh goyal on 5/29/2015.
 */
public class WebViewFragment extends Fragment {
    public static String url="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.webviewfragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WebView browser=(WebView)getActivity().findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setPluginState(WebSettings.PluginState.ON);
        browser.getSettings().setAllowFileAccess(true);
        browser.getSettings().setAllowContentAccess(true);
        browser.getSettings().setAllowFileAccessFromFileURLs(true);
        browser.getSettings().setAllowUniversalAccessFromFileURLs(true);

        if(url!=null && url!="")
        browser.loadUrl(url);
        browser.setWebViewClient(new MyAppWebviewclient());
    }
}
