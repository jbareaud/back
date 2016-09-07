package fr.sfeir.back.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.ImmutableList;

import fr.sfeir.back.Appli;
import fr.sfeir.back.DatabaseTest;
import fr.sfeir.back.entities.Point;
import fr.sfeir.back.entities.Quartier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Appli.class, DatabaseTest.class})
public class QuartierRepositoryTest {
		
	@Autowired
	private QuartierRepository repository;
	
	@Before
	public void init() {
		Quartier quartier = new Quartier()
				.setId(1)
				.setNom("test")
				.setPoints(ImmutableList.of(
						new Point()
							.setId(1)
							.setIdQuartier(1)
							.setLatitude(0.123)
							.setLongitude(0.987)
						));
		repository.save(quartier);
	}
	
	@Test
	public void allQuartiers() {
		List<Quartier> all = repository.findAll();
		Assert.assertEquals(all.size(), 1);
	}
	
	@Test
	public void getQuartier() {
		Quartier quartier = repository.findOne(1l);
		Assert.assertNotNull(quartier);
		Assert.assertEquals(quartier.getNom(), "test");
	}
	
	@Test
	public void updateQuartier() {
		{
			Quartier quartier = repository.findOne(1l);
			quartier.setNom("taratata");
			repository.save(quartier);
		}
		{
			Quartier quartier = repository.findOne(1l);
			Assert.assertEquals(quartier.getNom(), "taratata");
		}
	}
	
	@Test
	public void removeQuartier() {
		{
			Quartier quartier = new Quartier()
					.setNom("foo_test_remove");
			repository.save(quartier);
			repository.flush();
		}
		{
			Quartier quartier = repository.findByNom("foo_test_remove").get(0);
			Assert.assertNotNull(quartier);
			repository.delete(quartier);
		}
		{
			List<Quartier> findByNom = repository.findByNom("foo_test_remove");
			Assert.assertEquals(0, findByNom.size());
		}
	}
	
	@Test
	public void createQuartier() {
		{
			Quartier quartier = repository.findOne(2l);
			Assert.assertNull(quartier);
		}
		{
			repository.save(
					new Quartier()
						.setId(2)
						.setNom("foo foo")
			);
		}
		{
			Quartier quartier = repository.findOne(2l);
			Assert.assertNotNull(quartier);
			repository.delete(quartier);
		}
	}
	
}
