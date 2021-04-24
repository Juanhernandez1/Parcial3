package sv.edu.utec.parcial3.interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://server-parcial-etps3.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService service =
            retrofit.create(ApiService.class);
}
