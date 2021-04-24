package sv.edu.utec.parcial3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentsResponse {

    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}