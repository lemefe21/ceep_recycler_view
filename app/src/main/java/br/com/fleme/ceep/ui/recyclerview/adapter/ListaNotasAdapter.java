package br.com.fleme.ceep.ui.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.fleme.ceep.R;
import br.com.fleme.ceep.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter<ListaNotasAdapter.NotaViewHolder> {

    private final List<Nota> notas;
    private final Context context;
    public static final String RECYCLER_VIEW_ADAPTER = "RecyclerView Adapter";
    private static int quantidadeViewCriada = 0;
    private static int quantidadeBindView = 0;

    public ListaNotasAdapter(Context context, List<Nota>notas) {
        this.context = context;
        this.notas = notas;
    }

    @NonNull
    @Override
    public ListaNotasAdapter.NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        quantidadeViewCriada++;
        Log.i(RECYCLER_VIEW_ADAPTER, "ViewHolder Criada: " + quantidadeViewCriada);

        //cria as ViewHolder suficientes para que o Adapter seja capaz de reutilizá-las conforme a ação de scroll é realizada.

        View viewCriada = criaView(parent);

        return new NotaViewHolder(viewCriada);
    }

    private View criaView(@NonNull ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_nota, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaNotasAdapter.NotaViewHolder notaViewHolder, int position) {

        //pega as ViewHolder criadas e faz o processo de bind das informações
        //chamado no momento do scroll da tela para realizar o bind dos demais ViewHolder que serão mostrados

        //internamente o RecyclerView ao acabar as ViewHolder criados pelo onCreateViewHolder durante o scroll
        //ele pega a primeira ou última view que não está mais visivel e faz um processo de reciclagem sendo retirada da memória para
        //realizar novamente o bind com novas informações do próximo item que irá aparecer

        //o parâmetro de posição possibilita a reutilização das views de acordo com o objeto que precisa ser apresentado conforme o movimento de scroll

        //evitar processos que não precisem ser executados mais de uma vez dentro do onBindViewHolder !!!
        //nesse caso delegamos essa parte para o NotaViewHolder (buscar as views agora fica dentro do seu construtor)

        //resumindo...
        //onBindViewHolder fica responsável em apenas pegar o objeto a partir da posição e enviar para o ViewHolder se responsabilizar
        //em computar as informações na view.

        Nota nota = notas.get(position);
        //TextView titulo = viewHolder.itemView.findViewById(R.id.item_nota_titulo);
        //TextView descricao = viewHolder.itemView.findViewById(R.id.item_nota_descricao);

        //podemos evitar o cast usando um Adapter do RecylcerView que recebe um generics para utilziarmos o nosso view holder
        //NotaViewHolder notaViewHolder = (NotaViewHolder) viewHolder;

        //titulo.setText(nota.getTitulo());
        ///descricao.setText(nota.getDescricao());
        notaViewHolder.vincula(nota);

        //cópia de linha - Ctrl +

        quantidadeBindView++;
        Log.i(RECYCLER_VIEW_ADAPTER, "Bind ViewHolder: Posição " + position + " - Quantidade " + quantidadeBindView);

    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {

        //a busca das views não precisa ser feita todas as vezes igual no onBindViewHolder anteriormente
        //e a responsabilidade de setar as informações na view tb passar para o nosso ViewHolder
        private final TextView titulo;
        private final TextView descricao;

        public NotaViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.item_nota_titulo);
            descricao = itemView.findViewById(R.id.item_nota_descricao);

        }

        public void vincula(Nota nota) {
            preencheCampos(nota);
        }

        private void preencheCampos(Nota nota) {
            titulo.setText(nota.getTitulo());
            descricao.setText(nota.getDescricao());
        }

    }

}
