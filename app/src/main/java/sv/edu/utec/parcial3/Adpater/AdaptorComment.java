package sv.edu.utec.parcial3.Adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sv.edu.utec.parcial3.R;
import sv.edu.utec.parcial3.model.Comment;

public class AdaptadorComment extends RecyclerView.Adapter<AdaptadorComment.CommenViewHolder>  {


    List<Comment> CommentList;


    public AdaptadorComment(List<Comment> Comment) {
        this.CommentList = Comment;
    }

    @NonNull
    @Override
    public AdaptadorComment.CommenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new AdaptadorComment.CommenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorComment.CommenViewHolder holder, int position) {
        holder.bindData(CommentList.get(position));
    }

    @Override
    public int getItemCount() {
        return CommentList.size();
    }

    public class CommenViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, cuerpo;
        private CardView carditems;

        public CommenViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.RespuestaName);
            cuerpo = itemView.findViewById(R.id.RespuestaBody);


        }

        public void bindData(Comment comment) {
            nombre.setText(comment.getName());
            cuerpo.setText(comment.getBody());

        }
    }

    public void setNewList(List<Comment> Comment) {
        this.CommentList = Comment;
        notifyDataSetChanged();
    }
}
