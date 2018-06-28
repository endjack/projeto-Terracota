package com.example.ender.terracota;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static int ID_NOTIFICATION = 0x256587a4;

    private BottomNavigationView bottomNavigationView;
    private PendingIntent pendingIntent;
    private Notification boasVindasNotificacao;
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,new FragmentMain())
                .commit();

//      Notificação de Boas Vindas
        pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                ID_NOTIFICATION, getIntent(), PendingIntent.FLAG_UPDATE_CURRENT);

        boasVindasNotificacao = new Notification.Builder(getApplicationContext())
                .setContentTitle("Terracota Ópera")
                .setContentText("Bem-vindo(a)! Agora você poderá ver tudo sobre a Terracota Ópera")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pendingIntent).build();

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        boasVindasNotificacao.flags = Notification.FLAG_AUTO_CANCEL;
        chamarNotificacao(boasVindasNotificacao);

//      Menu de Navegação
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homeItem:
                        FragmentMain fragmentHome = new FragmentMain();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentHome)
                                .commit();
                        break;
                    case R.id.atosItem:
                        FragmentAtos fragmentAtos = new FragmentAtos();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentAtos)
                                .commit();
                        break;
                    case R.id.interacaoItem:
                        FragmentIter fragmentIter = new FragmentIter();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentIter)
                                .commit();
                        break;
                    case R.id.sobreItem:
                        FragmentSobre fragmentSobre = new FragmentSobre();
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout,fragmentSobre)
                                .commit();
                        break;
                }
                return true;
            }
        });

    }

    private void chamarNotificacao(Notification notification) {
        nm.notify(ID_NOTIFICATION, notification);
    }
}
