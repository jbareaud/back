package back;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import fr.sfeir.back.dao.QuartierDao;
import fr.sfeir.back.entities.Quartier;

//@test
public class QuartierDaoTest {
	
	@Autowired
	private QuartierDao dao;
	
	public void allQuartiers() {
		List<Quartier> all = dao.all();
		Assert.assertEquals(all.size(), 20);
	}
	
	public void getQuartier() {
		Quartier quartier = dao.fetch(1);
		Assert.assertNotNull(quartier);
		Assert.assertEquals(quartier.getNom(), "toto");
	}
	
	public void updateQuartier() {
		Quartier quartier = dao.fetch(1);
		quartier.setNom("taratata");
		dao.update(quartier);
		dao.fetch(1);
		Assert.assertEquals(quartier.getNom(), "taratata");
	}
	
	public void removeQuartier() {
		{
			Quartier quartier = dao.fetch(1);
			Assert.assertNotNull(quartier);
			dao.delete(1);
		}
		{
			Quartier quartier = dao.fetch(1);
			Assert.assertNull(quartier);
		}
	}
	
	public void createQuartier() {
		{
			Quartier quartier = dao.fetch(10);
			Assert.assertNull(quartier);
			dao.create(new Quartier());
		}
		{
			Quartier quartier = dao.fetch(10);
			Assert.assertNotNull(quartier);
		}
	}
	
}
