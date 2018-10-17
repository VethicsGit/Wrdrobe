package com.pro.wardrobe.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pro.wardrobe.Activity.New;
import com.pro.wardrobe.ApiResponse.DesignerCategoryResponse.ProductTypeList;
import com.pro.wardrobe.Fragment.Fragment_Designers;
import com.pro.wardrobe.R;

import java.util.List;

public class horizontalScrollAdapter extends RecyclerView.Adapter<horizontalScrollAdapter.ViewHolder>{

    String[] categories;
    Context context;
    List<ProductTypeList> productTypeLists;

    private AdapterView.OnItemClickListener listener;






/*
    public horizontalScrollAdapter(List<ProductTypeList> productTypeLists, Context context,
                                   AdapterView.OnItemClickListener onItemClickListener) {
        this.context=context;
        this.productTypeLists=productTypeLists;
        this.listener=onItemClickListener;

    }*/

    public horizontalScrollAdapter(List<ProductTypeList> productTypeLists, Context context) {
        this.context=context;
        this.productTypeLists=productTypeLists;

    }






    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_category_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
       final ProductTypeList productTypeList = productTypeLists.get(i);

        viewHolder.home_cate_txt.setText(productTypeList.getProductType());
        viewHolder.product_type.setText(productTypeList.getProductTypeId());

        if (i == 0) {
                viewHolder.home_cate_txt.setVisibility(View.GONE);
                viewHolder.home_search.setVisibility(View.GONE);
            } else {

//                viewHolder.home_cate_txt.setText(categories[i]);
            }
        viewHolder.home_cate_txt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                notifyDataSetChanged();
                viewHolder.home_cate_txt.setTextColor(Color.parseColor("#ffffff"));
                viewHolder.home_cate_layout.setBackgroundResource(R.drawable.purple_selected_background);

////                String product_type_id = productTypeList.getProductTypeId().toString();
////                Intent intent = new Intent("custom");
////                intent.putExtra("product_type_id",productTypeList.getProductTypeId());
////                LocalBroadcastManager.getInstance(context).sendBroadcast(intent );
             /*   Intent intent =new Intent(context,Fragment_Designers.class);
                intent.putExtra("product_type_id",viewHolder.product_type.getText().toString());
                context.startActivity(intent);
*/
                Bundle bundle = new Bundle();
                bundle.putString("product_type_id",viewHolder.product_type.getText().toString());
                Fragment_Designers designers=new Fragment_Designers();
                designers.setArguments(bundle);

            }
        });





    }

    @Override
    public int getItemCount() {
        return productTypeLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView home_search;
        TextView home_cate_txt;
        LinearLayout home_cate_layout;
        TextView product_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_cate_txt=itemView.findViewById(R.id.home_cate_txt);
            home_search=itemView.findViewById(R.id.home_search);
            home_cate_layout=itemView.findViewById(R.id.home_cate_layout);
            product_type=itemView.findViewById(R.id.product_type);
//            home_cate_txt.setOnClickListener(new View.OnClickListener() {


//                @Override
//                public void onClick(View view) {
//                    home_cate_txt.setTextColor(Color.parseColor("#ffffff"));
//              home_cate_layout.setBackgroundResource(R.drawable.purple_selected_background);
//
//                    Intent intent =new Intent(context,New.class);
//                    intent.putExtra("product_type_id",product_type.getText().toString());
//
//
//                }
//            });

        }









    }
}
