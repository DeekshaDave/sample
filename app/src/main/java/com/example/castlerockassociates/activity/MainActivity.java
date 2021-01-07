package com.example.castlerockassociates.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.castlerockassociates.R;
import com.example.castlerockassociates.adapter.SignsAdapter;
import com.example.castlerockassociates.apiClass.ApiService;
import com.example.castlerockassociates.apiClass.ServiceStarter;
import com.example.castlerockassociates.constants.AppConstants;
import com.example.castlerockassociates.constants.ServerConstants;
import com.example.castlerockassociates.model.SignsData;
import com.example.castlerockassociates.utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rv_list;
    private SignsAdapter adapter;
    private List<SignsData> signsDataList;
    private ProgressBar pbHeaderProgress;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signsDataList = new ArrayList<>();

        pbHeaderProgress = findViewById(R.id.pbHeaderProgress);
        rv_list = findViewById(R.id.rv_list);
        swipeLayout = findViewById(R.id.swipeLayout);

        adapter = new SignsAdapter(this, signsDataList, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_list.setLayoutManager(layoutManager);
        rv_list.setAdapter(adapter);
        rv_list.setNestedScrollingEnabled(false);

        pbHeaderProgress.setVisibility(View.VISIBLE);
        rv_list.setVisibility(View.GONE);
        callSignsApi();
        swipeLayout.setOnRefreshListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.txt_name :
                int pos = (int) view.getTag();
                if (signsDataList.get(pos).getStatus().equalsIgnoreCase(AppConstants.DISPLAYING_MESSAGE)){
                    Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(AppConstants.SHOW_MSG, signsDataList.get(pos).getDisplay());
                    i.putExtras(bundle);
                    startActivity(i);

                } else {
                    Utility.showToast(MainActivity.this, "No message to be displayed!");
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * call API and get data from server
     */
    private void callSignsApi() {
        if (Utility.checkConnection(this)) {
            ApiService service = ServiceStarter.getRetrofit().create(ApiService.class);
            Call<List<SignsData>> call = service.getSigns();
            call.enqueue(new Callback<List<SignsData>>() {
                @Override
                public void onResponse(Call<List<SignsData>> call, Response<List<SignsData>> response) {
                    pbHeaderProgress.setVisibility(View.GONE);
                    rv_list.setVisibility(View.VISIBLE);
                    swipeLayout.setRefreshing(false);

                    signsDataList.clear();
                    signsDataList.addAll(response.body());

                    Collections.sort(signsDataList, new Comparator<SignsData>() {
                        @Override
                        public int compare(SignsData t1, SignsData t2) {

                            return Utility.getDate(Long.parseLong(t2.getLastUpdated())).compareTo(Utility.getDate(Long.parseLong(t1.getLastUpdated())));

                        }
                    });

                    adapter.notifyDataSetChanged();
                    rv_list.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<SignsData>> call, Throwable t) {
                    swipeLayout.setRefreshing(false);
                    pbHeaderProgress.setVisibility(View.GONE);
                    rv_list.setVisibility(View.VISIBLE);

                }
            });
        }
    }

    /**
     * call API again to refresh data on pull down
     */
    @Override
    public void onRefresh() {
        rv_list.setVisibility(View.GONE);
        swipeLayout.setRefreshing(true);
        callSignsApi();
    }
}