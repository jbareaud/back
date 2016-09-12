package fr.sfeir.back.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="id_point", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="lng")
	private Double longitude;

	@NotNull
	@Column(name="lat")
	private Double latitude;
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn(name = "id_quartier", nullable = false, updatable = false, insertable =  true)
	private Quartier quartier;
	
}
