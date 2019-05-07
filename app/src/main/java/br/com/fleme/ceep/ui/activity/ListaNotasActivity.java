package br.com.fleme.ceep.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.fleme.ceep.R;
import br.com.fleme.ceep.dao.NotaDAO;
import br.com.fleme.ceep.model.Nota;
import br.com.fleme.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        //+ dependências - Ctrl + Shift + Alt + S (Project Structure)
        //find file - Ctrl + Shift + N
        //clean imports - Ctrl + Alt + O

        List<Nota> todasNotas = notasDeExemplo();
        configuraRecyclerView(todasNotas);

        TextView botaoInsereNotas = findViewById(R.id.lista_notas_insere_nota);
        botaoInsereNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaNotasActivity.this, FormularioNotaActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();
        for(int i = 1; i <= 2; i++) {
            dao.insere(new Nota("Título " + i, "Descrição " + i));
        }

        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {

        RecyclerView listaDeNotas = findViewById(R.id.lista_notas_recycler_view);

        //adapter do recycler view
        configuraAdapter(todasNotas, listaDeNotas);

        //setamos o layout manager direto no xml
        //app:layoutManager="android.support.v7.widget.LinearLayoutManager"
        //configuraLayoutManager(listaDeNotas);
    }

    //private void configuraLayoutManager(RecyclerView listaDeNotas) {
    //    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    //    listaDeNotas.setLayoutManager(layoutManager);
    //}

    private void configuraAdapter(List<Nota> todasNotas, RecyclerView listaDeNotas) {
        listaDeNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }

    @Override
    protected void onResume() {
        super.onResume();
        NotaDAO dao = new NotaDAO();
        configuraRecyclerView(dao.todos());
    }
}
