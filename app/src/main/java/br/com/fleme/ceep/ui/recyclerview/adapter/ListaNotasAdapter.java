package br.com.fleme.ceep.ui.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import br.com.fleme.ceep.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter {

    private List<Nota> notas;

    public ListaNotasAdapter(List<Nota>notas) {
        this.notas = notas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //cria as ViewHolder suficientes para que o Adapter seja capaz de reutilizá-las conforme a ação de scroll é realizada.

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //pega as ViewHolder criadas e faz o processo de bind das informações
        //chamado no momento do scroll da tela para realizar o bind dos demais ViewHolder que serão mostrados

        //internamente o RecyclerView ao acabar as ViewHolder criados pelo onCreateViewHolder durante o scroll
        //ele pega a primeira ou última view que não está mais visivel e faz um processo de reciclagem sendo retirada da memória para
        //realizar novamente o bind com novas informações do próximo item que irá aparecer

        //o parâmetro de posição possibilita a reutilização das views de acordo com o objeto que precisa ser apresentado conforme o movimento de scroll

    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

}
