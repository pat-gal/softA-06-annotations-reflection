package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ohm.softa.a06.model.Joke;
import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App{

	public static void main(String[] args) {
		Gson gson = new GsonBuilder()
			.registerTypeAdapter(Joke[].class, new JokeArrayAdapter())
			.create();

		Retrofit httpClient = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io/")
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build();

		CNJDBApi cnjdbApi = httpClient.create(CNJDBApi.class);

		try{
			var joke = cnjdbApi.getRandomJoke().execute().body();
			System.out.println(joke.getContent());
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try{
			String[] cat = {"dev", "science"};
			var joke = cnjdbApi.getRandomJoke(cat).execute().body();
			System.out.println(joke.getContent());
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try{
			var jokes = cnjdbApi.getJokesBySearch("animal").execute().body();
			for (Joke joke: jokes) {
				System.out.println(joke.getContent());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}


		try{
			var joke = cnjdbApi.getJoke("3sRjGpBKT1iVCHnyecgVmw").execute().body();
			System.out.println(joke.getContent());
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
