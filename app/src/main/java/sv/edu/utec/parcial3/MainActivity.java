package sv.edu.utec.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.edu.utec.parcial3.interfaces.RetrofitService;
import sv.edu.utec.parcial3.model.CommentsResponse;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<CommentsResponse> call = RetrofitService.service.getComments();
        call.enqueue(new Callback<CommentsResponse>() {
            @Override
            public void onResponse(Call<CommentsResponse> call, Response<CommentsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.i("MainActivity", "onResponse: " + response.body().getComments().size());
                } else {
                    Log.i("MainActivity", "onResponse: Failed");
                }
            }

            @Override
            public void onFailure(Call<CommentsResponse> call, Throwable t) {
                Log.e("MainActivity", "Call failed", t);
            }
        });
    }
}