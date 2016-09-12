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
import javax.validation.constraints.NotNull;

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
	@Column(name="id_quartier", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="nom_quartier")
	private String nom;
	
	@OneToMany( mappedBy="quartier", fetch=FetchType.EAGER, cascade = CascadeType.ALL )
	private List<Point> points;

}
