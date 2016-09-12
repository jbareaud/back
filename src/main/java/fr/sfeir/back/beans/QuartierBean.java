package fr.sfeir.back.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class QuartierBean {

	private String id;
	private List<PointBean> path;
	
	@JsonCreator
	public QuartierBean(@JsonProperty("id") String id, @JsonProperty("path") List<PointBean> path) {
		this.id = id;
		this.path = path;
	}

}
