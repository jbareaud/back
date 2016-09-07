package fr.sfeir.back.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Entity
@Table(name="quartier")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Quartier {
	
	@Id
	@Column(name="id_quartier")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nom_quartier")
	private String nom;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="idQuartier", fetch=FetchType.EAGER)
	private List<Point> points;

}
