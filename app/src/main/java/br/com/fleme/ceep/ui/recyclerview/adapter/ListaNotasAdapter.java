package br.com.fleme.ceep.ui.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.fleme.ceep.R;
import br.com.fleme.ceep.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter {

    private List<Nota> notas;
    private Context context;

    public ListaNotasAdapter(Context context, List<Nota>notas) {
        this.context = context;
        this.notas = notas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //cria as ViewHolder suficientes para que o Adapter seja capaz de reutilizá-las conforme a ação de scroll é realizada.

        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_nota, parent, false);

        return new NotaViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        //pega as ViewHolder criadas e faz o processo de bind das informações
        //chamado no momento do scroll da tela para realizar o bind dos demais ViewHolder que serão mostrados

        //internamente o RecyclerView ao acabar as ViewHolder criados pelo onCreateViewHolder durante o scroll
        //ele pega a primeira ou última view que não está mais visivel e faz um processo de reciclagem sendo retirada da memória para
        //realizar novamente o bind com novas informações do próximo item que irá aparecer

        //o parâmetro de posição possibilita a reutilização das views de acordo com o objeto que precisa ser apresentado conforme o movimento de scroll

        Nota nota = notas.get(position);
        TextView titulo = viewHolder.itemView.findViewById(R.id.item_nota_titulo);
        titulo.setText(nota.getTitulo());
        TextView descricao = viewHolder.itemView.findViewById(R.id.item_nota_descricao);
        descricao.setText(nota.getDescricao());

        //cópia de linha - Ctrl + D


    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {

        public NotaViewHolder(View itemView) {
            super(itemView);
        }

    }

}
