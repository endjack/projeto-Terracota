package com.example.ender.terracota;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapters.AtosAdapter;
import api.AtoService;
import api.RetrofitConfig;
import models.Ato;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentAtos extends Fragment {

    public final String TAG = "TERRACOTA-LOG";

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private AtosAdapter atosAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.atos_fragment,container,false);

        retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        inicializarObjetos(view);
        carregarAtos();

        return view;
    }

    /**
     *  Ininializa as views do fragment
     * @param view View inflada no OnCreate
     */
    private void inicializarObjetos(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_atos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }
    private void carregarAtos() {
        AtoService atoService = retrofit.create(AtoService.class);
        final Call<List<Ato>> call = atoService.getAtos();


        final Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {

            List<Ato> listaAtos = new ArrayList<>();

            @Override
            public void run() {
                try {
                    listaAtos = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        atosAdapter = new AtosAdapter(getActivity(), listaAtos);
                        recyclerView.setAdapter(atosAdapter);

                        for(Ato a: listaAtos){
                            Log.i(TAG, a.toString());
                        }
                    }
                });
            }
        }).start();

    }

}
