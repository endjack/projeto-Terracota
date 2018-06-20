package api;

import java.util.List;

import models.Ato;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AtoService {

    @GET("ato")
    Call<List<Ato>> getAtos();

    @GET("ato/{id}")
    Call<Ato> getAtobyId(@Path("id") Integer id);
}
