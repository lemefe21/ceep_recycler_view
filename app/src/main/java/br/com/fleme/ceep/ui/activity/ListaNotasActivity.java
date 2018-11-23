package br.com.fleme.ceep.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

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

        RecyclerView listaDeNotas = findViewById(R.id.lista_notas_recycler_view);

        NotaDAO dao = new NotaDAO();
        for(int i = 1; i <= 10000; i++) {
            dao.insere(new Nota("Título " + i, "Descrição " + i));
        }

        List<Nota> todasNotas = dao.todos();

        //adapter do list view
        //listaDeNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));

        //adapter do recycler view
        listaDeNotas.setAdapter(new ListaNotasAdapter());

    }
}
