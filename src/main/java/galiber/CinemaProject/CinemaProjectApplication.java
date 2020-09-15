package galiber.CinemaProject;


import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import galiber.CinemaProject.OkHttp.OkHttpTool;
import galiber.CinemaProject.models.TMDb.TMDbMovie;
import galiber.CinemaProject.utils.ConfigVars;


@SpringBootApplication
public class CinemaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaProjectApplication.class, args);
		OkHttpTool oht=new OkHttpTool();
		Gson gson=new Gson();
		TMDbMovie movie;
		try {
			movie = gson.fromJson(oht.getJsonResponseBody(ConfigVars.url+"movie/384018?api_key="+ConfigVars.apiKey), TMDbMovie.class);
			System.out.println();
			movie.getGenres().stream().forEach(g->System.out.println(g.getName()));
			System.out.println(movie.getId());
		} catch (JsonSyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
