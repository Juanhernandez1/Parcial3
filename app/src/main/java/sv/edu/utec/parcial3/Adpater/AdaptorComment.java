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

public class AdaptorComment extends RecyclerView.Adapter<AdaptorComment.CommentViewHolder>  {


    List<Comment> CommentList;


    public AdaptorComment(List<Comment> Comment) {
        this.CommentList = Comment;
    }

    @NonNull
    @Override
    public AdaptorComment.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new AdaptorComment.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptorComment.CommentViewHolder holder, int position) {
        holder.bindData(CommentList.get(position));
    }

    @Override
    public int getItemCount() {
        return CommentList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, cuerpo;


        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.RespuestaName);
            cuerpo = itemView.findViewById(R.id.RespuestaBody);


        }

        public void bindData(Comment comment) {
            nombre.setText(comment.getName());
            cuerpo.setText(comment.getBody());

        }
    }
}
