package fr.sfeir.back.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name="long")
	private double longitude;

	@NotNull
	@Column(name="lat")
	private double latitude;
	
	@Column(name="id_quartier")
	private long idQuartier;
	
//	@ManyToOne
//	@JoinColumn(name = "id_quartier")
//	private Quartier quartier;
	
}
