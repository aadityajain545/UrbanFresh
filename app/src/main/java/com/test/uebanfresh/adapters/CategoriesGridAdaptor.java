package com.test.uebanfresh.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.uebanfresh.R;
import com.test.uebanfresh.api.ApiClient;
import com.test.uebanfresh.model.CategoryDataModel;

import java.util.List;

public class CategoriesGridAdaptor extends RecyclerView.Adapter<CategoriesGridAdaptor.Viewholder>{

    private List<CategoryDataModel> categoryList;
    private Context context;
    RequestOptions requestOptions = new RequestOptions();

    public CategoriesGridAdaptor(List<CategoryDataModel> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context=context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_for_categories,parent,false);
        return new Viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String img=categoryList.get(position).getCategoryPicture();
        String title=categoryList.get(position).getCategoryName();
        holder.setData(img,title);

    }
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView imageItem;
        private TextView titleItem;
      CardView cardView;

        /*
         * Method is used to provide view
         */
        public Viewholder(View view)
        {
            super(view);
            imageItem=view.findViewById(R.id.img_ct_item);
            titleItem=view.findViewById(R.id.tv_ct_item_name);
        }

        /*
         * Method is used to set data on view
         */
        private void setData(String imgUrl,String txt)
        {
            requestOptions.placeholder(R.drawable.ic_launcher_background);
            requestOptions.error(R.drawable.ic_launcher_foreground);
            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(ApiClient.BASE_URL+imgUrl).into(imageItem);
            titleItem.setText(txt);

        }
}
}
