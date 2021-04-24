package sv.edu.utec.parcial3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.edu.utec.parcial3.Adpater.AdaptorComment;
import sv.edu.utec.parcial3.interfaces.RetrofitService;
import sv.edu.utec.parcial3.model.CommentsResponse;

public class MainActivity extends AppCompatActivity {

    private AdaptorComment adaptorComment;
    private RecyclerView RecyclerViewComment;
    private Button Consultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<CommentsResponse> call = RetrofitService.service.getComments();

        RecyclerViewComment = findViewById(R.id.rcnombres);
        Consultar = findViewById(R.id.button);
        Consultar.setOnClickListener(v -> {
            call.enqueue(new Callback<CommentsResponse>() {
                @Override
                public void onResponse(Call<CommentsResponse> call, Response<CommentsResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.i("MainActivity", "onResponse: " + response.body().getComments().get(0).getName());
                        adaptorComment = new AdaptorComment(response.body().getComments());
                        RecyclerViewComment.setAdapter(adaptorComment);
                    } else {
                        Log.i("MainActivity", "onResponse: Failed");
                    }
                }

                @Override
                public void onFailure(Call<CommentsResponse> call, Throwable t) {
                    Log.e("MainActivity", "Call failed", t);
                }
            });
        });


    }
}