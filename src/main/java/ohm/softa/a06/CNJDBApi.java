package ohm.softa.a06;


import ohm.softa.a06.model.Joke;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface CNJDBApi {
	@GET("jokes/random")
	@Headers({
		"Accept: application/json"
	})
	public Call<Joke> getRandomJoke();
	@GET("jokes/random")
	@Headers({
		"Accept: application/json"
	})
	public Call<Joke> getRandomJoke(@Query("categories") String[] categories);
	@GET("jokes/search")
	@Headers({
		"Accept: application/json"
	})
	public Call<Joke[]> getJokesBySearch(@Query("query") String query);
	@GET("jokes/{id}")
	@Headers({
		"Accept: application/json"
	})
	public Call<Joke> getJoke(@Path("id") String id);

}
