package fr.sfeir.back.batch;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sfeir.back.beans.QuartierBean;
import fr.sfeir.back.entities.Point;
import fr.sfeir.back.entities.Quartier;

//@Component
//@Transactional
//@PropertySource(value={"classpath:application.yaml"})
@Deprecated // classe one-shot
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

	private List<QuartierBean> read() throws Exception {
		Resource resource = resourceLoader.getResource(jsonDataFile);
		File file = resource.getFile();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<List<QuartierBean>>(){});
	}
	
	private List<Quartier> map(List<QuartierBean> quartiers) {
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
}
