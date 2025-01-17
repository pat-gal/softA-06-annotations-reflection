package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter<Joke> {

	@Override
	public void write(JsonWriter out, Joke value) throws IOException {

	}

	@Override
	public Joke read(JsonReader in) throws IOException {
		var gson = new Gson();
		return gson.fromJson(in, Joke.class);

	}
}
