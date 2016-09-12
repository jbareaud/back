package fr.sfeir.back.webservices.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PointBean {

	private Double  latitude;
    private Double  longitude;	

	@JsonCreator
	public PointBean(@JsonProperty("latitude") Double latitude, @JsonProperty("longitude") Double longitude ) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
