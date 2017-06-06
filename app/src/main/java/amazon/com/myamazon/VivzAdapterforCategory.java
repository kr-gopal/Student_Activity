package amazon.com.myamazon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurabh goyal on 9/19/2015.
 */
public class VivzAdapterforCategory extends RecyclerView.Adapter<VivzAdapterforCategory.MyViewHolder> {
    private ClickListener clickListener;
    private  LayoutInflater inflater;
    private Context context;
    public static View view;
    public  static ArrayList<String>data=new ArrayList<String>();

    public VivzAdapterforCategory(Context context, ArrayList<String> data){
        this.context=context;

        this.data=data;


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //called only once
    view=LayoutInflater.from(context).inflate(R.layout.customlistrow, viewGroup, false);

        Log.d("Vivz","on create view holder is called");
        MyViewHolder holder=new MyViewHolder(view);



        return holder;
    }



    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        Log.d("Vivz","on bind view holder is called"+i);

        viewHolder.title.setText(data.get(i));
//viewHolder.delete.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//
//        viewHolder.deletek(i);
//    }
//});
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon;
        TextView title;
        ImageView delete;
        public MyViewHolder(final View itemView) {
            super(itemView);
title= (TextView) itemView.findViewById(R.id.movieTitle);
            icon= (ImageView) itemView.findViewById(R.id.movieThumbnail);
        //    delete=(ImageView)itemView.findViewById(R.id.delete);
itemView.setOnClickListener(this);


        }
        public void deletek(int position){

data.remove(position);
            notifyItemRemoved(position);



        }

        @Override
        public void onClick(View v) {
//delete(getPosition());

    //
            if(clickListener!=null){
                clickListener.itemclicked(v,getPosition());
            }

        }


    }
    public interface ClickListener{

        public void itemclicked(View view, int position);



    }
}
