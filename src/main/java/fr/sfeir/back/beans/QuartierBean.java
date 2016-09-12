package fr.sfeir.back.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString 
public class QuartierBean {

	private String id;
	private List<PointBean> path;
	
	@JsonCreator
	public QuartierBean(@JsonProperty("id") String id, @JsonProperty("path") List<PointBean> path) {
		this.id = id;
		this.path = path;
	}

}
