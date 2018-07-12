package com.example.helderrocha.testerec.actvity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.helderrocha.testerec.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_sobre);
        String descricao = "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription( descricao )
                .addGroup("O que é Lorem Ipsum?")
                .addEmail("lorem@gmail.com", "Envie um e-mail")
                .addWebsite("http://google.com.br/", "Acess nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("google", "Facebook" )
                .addTwitter("google", "Twitter")
                .addYoutube("google", "Youtube")
                .addPlayStore("com.google.android.apps.plus", "Play Store")
                .addGitHub("google", "Github")
                .addInstagram("google", "Instagram")
                .create();

        setContentView( sobre );

    }
}

