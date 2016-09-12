package fr.sfeir.back.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.sfeir.back.Appli;
import fr.sfeir.back.DatabaseTest;
import fr.sfeir.back.entities.Point;
import fr.sfeir.back.entities.Quartier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Appli.class, DatabaseTest.class})
@Transactional
public class QuartierRepositoryTest {

	@Autowired
	private QuartierRepository repository;
	
	@Before
	public void init() {
		
		List<Point> list = new ArrayList<Point>();
		list.add(new Point()
			.setLatitude(1.234)
			.setLongitude(3.675)	
		);
		
		Quartier quartier = new Quartier()
				.setNom("test")
				.setPoints(list);
		repository.save(quartier);
	}
	
	@Test
	public void allQuartiers() {
		List<Quartier> all = repository.findAll();
		Assert.assertEquals(all.size(), 1);
	}
	
	@Test
	public void getQuartier() {
		Quartier quartier = repository.findByNom("test").get(0);
//		Hibernate.initialize(quartier.getPoints());
		System.out.println(quartier);
		Assert.assertNotNull(quartier);
		Assert.assertEquals(quartier.getNom(), "test");
	}
	
	@Test
	public void updateQuartier() {
		{
			Quartier quartier = repository.findByNom("test").get(0);
			quartier.setNom("taratata");
			repository.save(quartier);
		}
		{
			Quartier quartier = repository.findByNom("taratata").get(0);
			Assert.assertEquals(quartier.getNom(), "taratata");
		}
		{
			Quartier quartier = repository.findByNom("taratata").get(0);
			quartier.setNom("test");
			repository.save(quartier);
		}
	}
	
	@Test
	public void removeQuartier() {
		{
			Quartier quartier = new Quartier()
					.setNom("foo_test_remove");
			repository.save(quartier);
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
			repository.save(
					new Quartier()
						.setNom("create")
			);
		}
		{
			Quartier quartier = repository.findByNom("create").get(0);
			Assert.assertNotNull(quartier);
			repository.delete(quartier);
		}
	}
	
}
