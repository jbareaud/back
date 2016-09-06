package fr.sfeir.back.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="quartier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quartier {
	
	@Id
	@Column(name="idQuartier")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nomQuartier")
	private String nom;
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="idQuartier", fetch=FetchType.EAGER)
//	private List<Point> points;

}
