package neustadt.presidents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PresidentsService {
    @GET("/hitch17/sample-data/master/presidents.json")
    Call<List<President>> listPresidents();
}
