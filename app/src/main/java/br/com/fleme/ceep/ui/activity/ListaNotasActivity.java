package br.com.fleme.ceep.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.nio.file.Files;
import java.util.List;

import br.com.fleme.ceep.R;
import br.com.fleme.ceep.dao.NotaDAO;
import br.com.fleme.ceep.model.Nota;
import br.com.fleme.ceep.ui.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaDeNotas = findViewById(R.id.listView);

        NotaDAO dao = new NotaDAO();

        for(int i = 1; i <= 10000; i++) {
            dao.insere(new Nota("Título " + i, "Descrição " + i));
        }

        List<Nota> todasNotas = dao.todos();

        listaDeNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));

    }
}
