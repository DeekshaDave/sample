package com.example.castlerockassociates.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.castlerockassociates.R;
import com.example.castlerockassociates.constants.AppConstants;
import com.example.castlerockassociates.model.DisplayModel;
import com.example.castlerockassociates.model.PagesModel;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private TextView txt_page_name;
    private DisplayModel displayModel = new DisplayModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txt_page_name = findViewById(R.id.txt_page_name);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        if (bundle != null) {

            displayModel = bundle.getParcelable(AppConstants.SHOW_MSG);
            String str = "";

            if (displayModel != null && displayModel.getPages()!= null) {
                int len = displayModel.getPages().size();

                for (int i = 0; i < len; i++) {
                    PagesModel model = new PagesModel();
                    model = displayModel.getPages().get(i);

                    int len1 = model.getLines().size();
                    List<String> strData = new ArrayList<>();
                    strData = model.getLines();

                    for (int j = 0; j < len1; j++) {
                        str = str + strData.get(j) + " ";
                    }

                }
            }
            txt_page_name.setText(str);
        }

    }
}
