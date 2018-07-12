package com.example.helderrocha.testerec.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helderrocha.testerec.R;
import com.example.helderrocha.testerec.adapter.PostagemAdapter;
import com.example.helderrocha.testerec.model.Postagem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesListFragment extends Fragment {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    public MoviesListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_movies_list, container, false);
        final FragmentActivity c = getActivity();
        final RecyclerView recyclerPostagem = (RecyclerView) view.findViewById(R.id.recyclerPostagem);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerPostagem.setLayoutManager(layoutManager);

        //Define layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //define adapter
        prepararPostagens();

        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter( adapter );

        return view;
    }

    public void prepararPostagens(){

        Postagem p;

        p = new Postagem("Helder Rocha", "#TBT viagem legal!", R.drawable.imagem1 );
        postagens.add(p);

        p = new Postagem("Hotel JM", "Viaje, aproveite nossos descontos!", R.drawable.imagem2 );
        postagens.add(p);

        p = new Postagem("Maria Luiza", "#Paris!!", R.drawable.imagem3);
        postagens.add(p);

        p = new Postagem("Marcos Paulo", "Que foto linda!", R.drawable.imagem4);
        postagens.add(p);

    }

}
