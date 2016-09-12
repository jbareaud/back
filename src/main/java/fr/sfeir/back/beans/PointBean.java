package fr.sfeir.back.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PointBean {
	private String  latitude;
    private String  longitude;	

	@JsonCreator
	public PointBean(@JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude ) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
