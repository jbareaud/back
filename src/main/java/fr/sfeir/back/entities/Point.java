package fr.sfeir.back.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name="point")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Point {

	@Id
	@Column(name="id_point")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="long")
	private double lng;

	@Column(name="lat")
	private double lat;
	
	@Column(name="id_quartier")
	private long idQuartier;
	
}
