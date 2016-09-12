package fr.sfeir.back.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PointBean {
	private String  latitude;
    private String  longitude;	

	@JsonCreator
	public PointBean(@JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude ) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
