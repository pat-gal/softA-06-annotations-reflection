package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;

import java.io.IOException;
import java.util.*;

public class JokeArrayAdapter extends TypeAdapter<Joke[]> {
	@Override
	public void write(JsonWriter out, Joke[] value) throws IOException {

	}

	@Override
	public Joke[] read(JsonReader in) throws IOException {
		var json = JsonParser.parseReader(in).getAsJsonObject();
		var array = json.get("result").getAsJsonArray();

		var jokeList = new ArrayList<Joke>();
		for (JsonElement joke: array){
			var gson = new Gson();
			jokeList.add(gson.fromJson(joke, Joke.class));
		}
		return jokeList.toArray(new Joke[0]);
	}
}
