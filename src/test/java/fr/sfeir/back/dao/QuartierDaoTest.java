package fr.sfeir.back.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.sfeir.back.DatabaseTest;
import fr.sfeir.back.entities.Quartier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DatabaseTest.class})
public class QuartierDaoTest {
		
	@Autowired
	private QuartierDao dao;
	
	@Test
	public void allQuartiers() {
		List<Quartier> all = dao.all();
		Assert.assertEquals(all.size(), 2);
	}
	
//	@Test
	public void getQuartier() {
		Quartier quartier = dao.fetch(1);
		Assert.assertNotNull(quartier);
		Assert.assertEquals(quartier.getNom(), "toto");
	}
	
//	@Test
	public void updateQuartier() {
		Quartier quartier = dao.fetch(1);
		quartier.setNom("taratata");
		dao.update(quartier);
		dao.fetch(1);
		Assert.assertEquals(quartier.getNom(), "taratata");
	}
	
//	@Test
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
	
//	@Test
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
