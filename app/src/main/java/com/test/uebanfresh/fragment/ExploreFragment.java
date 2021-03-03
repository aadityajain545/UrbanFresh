package com.test.uebanfresh.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.test.uebanfresh.R;
import com.test.uebanfresh.adapters.CategoriesGridAdaptor;
import com.test.uebanfresh.api.ApiClient;
import com.test.uebanfresh.api.ApiInterface;
import com.test.uebanfresh.model.AdsBannerModel;
import com.test.uebanfresh.model.CategoryDataModel;
import com.test.uebanfresh.model.HomeScreenApiModel;
import com.test.uebanfresh.model.StaticBannerModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreFragment extends Fragment implements View.OnClickListener {

    ImageSlider sBanner,aBanner;
    List<SlideModel> staticBanner,adsBanner;
    RecyclerView cRecyclerView;
    ApiInterface api;
    TextView viewAll;
    GridLayoutManager layoutManager;
    Boolean viewAllList=false;
    ViewGroup.LayoutParams params;
    ProgressDialog progress;
    public ExploreFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_explore, container, false);
        initializeViews(view);
        apiCalling();
        showProgressBar();
        return view;
    }
    /**
     * Method is used to show progress bar when api is loading
     */
    private void showProgressBar() {
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false);
        progress.show();
    }
    /**
     * Method is use for Api calling
     */
    private void apiCalling() {
        Call<HomeScreenApiModel> call = api.getHomeApiData();
        call.enqueue(new Callback<HomeScreenApiModel>() {
            @Override
            public void onResponse(Call<HomeScreenApiModel> call, Response<HomeScreenApiModel> response) {
                if(response.body().isSuccess())
                {
                    //for static banner
                    List<StaticBannerModel> sb = response.body().getComponents().get(0).getStaticBanner();
                    for(int i = 0; i<sb.size(); i++)
                    {
                        staticBanner.add(new SlideModel(ApiClient.BASE_URL+sb.get(i).getBannerImage()));
                    }
                    sBanner.setImageList(staticBanner,true);

                    //for ads banner
                    List<AdsBannerModel> ab = response.body().getComponents().get(2).getAdsBanner();
                    for(int i = 0; i<ab.size(); i++)
                    {
                        adsBanner.add(new SlideModel(ApiClient.BASE_URL+ab.get(i).getBannerImage()));
                    }
                    aBanner.setImageList(adsBanner,true);

                    //for category data
                    List<CategoryDataModel> cdata=response.body().getComponents().get(1).getCategorydata();
                    cRecyclerView.setLayoutManager(layoutManager);
                    CategoriesGridAdaptor adaptorforGrid=new CategoriesGridAdaptor(cdata,getContext());
                    cRecyclerView.setAdapter(adaptorforGrid);

                    progress.dismiss();
                }
                else
                {
                    progress.show();
                }
            }
            @Override
            public void onFailure(Call<HomeScreenApiModel> call, Throwable t) {
                progress.show();
            }
        });

    }

    private void initializeViews(View view) {
        sBanner=view.findViewById(R.id.img_slider_static_banner);
        aBanner=view.findViewById(R.id.img_slider_ads_banner);
        api = ApiClient.getRetrofit().create(ApiInterface.class);
        cRecyclerView=view.findViewById(R.id.rv_categories);
        viewAll=view.findViewById(R.id.tv_view_all);
        viewAll.setOnClickListener(this);
        params = cRecyclerView.getLayoutParams();
        layoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        staticBanner=new ArrayList<>();
        adsBanner=new ArrayList<>();
        progress = new ProgressDialog(getContext());
    }

    /**
     * click events
     */
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_view_all:
                if(viewAllList)
                {
                    params.height=ViewGroup.LayoutParams.WRAP_CONTENT;
                    cRecyclerView.setLayoutParams(params);
                    viewAll.setText("View Less");
                    viewAllList=false;
                }
                else {
                    params.height=600;
                    cRecyclerView.setLayoutParams(params);
                    viewAll.setText("View All");
                    viewAllList=true;
                }

                break;

        }
    }
}