package network;

import data.Tarea;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface tareaInterface {

    @GET("api/Tareas")
    Call<List<Tarea>> getTodasTareas();
}
