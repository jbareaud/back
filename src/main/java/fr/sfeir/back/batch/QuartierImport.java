package fr.sfeir.back.batch;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sfeir.back.entities.Point;
import fr.sfeir.back.entities.Quartier;
import lombok.Data;
import lombok.ToString;

//@Component
//@Transactional
//@PropertySource(value={"classpath:application.yaml"})
public class QuartierImport 
implements CommandLineRunner 
{

//	private final Log logger = LogFactory.getLog(getClass());

    private final static String jsonDataFile = "classpath:data/data_quartiers.json";

	@Autowired
	private  ResourceLoader resourceLoader;
	
	@Override
	public void run(String... args) throws Exception {

		displaySql(map(read()));
		
	}
	
	private void displaySql(List<Quartier> list) {

		list.forEach(q -> {
			
			String quartierId = q.getNom();
			
			{
				StringBuilder sb = new  StringBuilder();
				sb
					.append("insert into quartier(id_quartier, nom_quartier) values (")
					.append(quartierId)
					.append(",")
					.append("'" + quartierId + "'")
					.append(");");
				System.out.println(sb.toString());
			}
			
			{
				q.getPoints().stream().forEach(p -> {
					StringBuilder sb = new  StringBuilder();
					sb
						.append("insert into point(id_point, lng, lat, id_quartier) values (")
						.append(KeyProvider.getNextKey()) 
						.append(",")
						.append(p.getLongitude())
						.append(",")
						.append(p.getLatitude())
						.append(",")
						.append(quartierId)
						.append(");");
					System.out.println(sb.toString());
				});
			}
			
		});
		
	}

	private List<JsonQuartier> read() throws Exception {
		Resource resource = resourceLoader.getResource(jsonDataFile);
		File file = resource.getFile();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<List<JsonQuartier>>(){});
	}
	
	private List<Quartier> map(List<JsonQuartier> quartiers) {
		return quartiers
			.stream()
			.map(q ->  {
				Quartier quartier = new Quartier();
				quartier
						.setNom(q.getId())
						.setPoints(q
								.getPath()
								.stream()
								.map(p -> 
									new Point()
										.setLatitude(Double.parseDouble(p.getLatitude()))
										.setLongitude(Double.parseDouble(p.getLongitude()))
										.setQuartier(quartier)
								)
								.collect(Collectors.toList())
						);
				return quartier;
			})
			.collect(Collectors.toList());
	}

	static class KeyProvider {
		static long i = 0;
		static long getNextKey() {
			return i++;
		}
	}
	
	@Data
	@ToString 
	public static class JsonQuartier {
		private String id;
		private List<JsonPoint> path;
		
		@JsonCreator
		public JsonQuartier(@JsonProperty("id") String id, @JsonProperty("path") List<JsonPoint> path) {
			this.id = id;
			this.path = path;
		}
	}
	
	@Data
	public static class JsonPoint {
		private String  latitude;
	    private String  longitude;	

		@JsonCreator
		public JsonPoint(@JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude ) {
			this.latitude = latitude;
			this.longitude = longitude;
		}
	}
	
}
