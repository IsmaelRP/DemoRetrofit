package com.practica.ismael.retrofitdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.practica.ismael.retrofitdemo.R;
import com.practica.ismael.retrofitdemo.data.models.YandexResponse;
import com.practica.ismael.retrofitdemo.data.remote.Api;
import com.practica.ismael.retrofitdemo.data.remote.ApiService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {


    private final String KEY = "trnsl.1.1.20190215T130053Z.2b6202b90183cf39.657c0c2130d0282368b7f8d495f0459c1dbc49ce";

    private TextView textView;
    private EditText editText;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, parent, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        textView = requireView().findViewById(R.id.textView);
        editText = requireView().findViewById(R.id.editText);
        button = requireView().findViewById(R.id.button);
        button.setOnClickListener(v -> traducir());
    }

    private void traducir() {
        Api api = ApiService.newInstance().getApi();
        Call<YandexResponse> response = api.getTranslation(KEY,editText.getText().toString(),"en-es");

        response.enqueue(new Callback<YandexResponse>() {
            @Override
            public void onResponse(Call<YandexResponse> call, Response<YandexResponse> response) {
                if(response.body() != null && response.isSuccessful())
                    textView.setText(response.body().getText().get(0));
            }

            @Override
            public void onFailure(Call<YandexResponse> call, Throwable t) {
                textView.setText(t.toString());
            }
        });
    }
}
