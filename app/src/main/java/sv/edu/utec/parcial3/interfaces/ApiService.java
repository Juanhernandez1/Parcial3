package sv.edu.utec.parcial3.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import sv.edu.utec.parcial3.model.CommentsResponse;

public interface ApiService {

    @GET("parcial/comments")
    //Call<List<Part>> getParts();
    Call<CommentsResponse> getComments();
}
