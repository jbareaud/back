package fr.sfeir.back.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.sfeir.back.db.entities.Point;
import fr.sfeir.back.webservices.beans.PointBean;

@Component
public class PointConverter implements Converter<Point, PointBean> {

	@Override
	public PointBean convert(Point source) {
		return new PointBean()
				.setLatitude(source.getLatitude().toString())
				.setLongitude(source.getLongitude().toString());
	}


}
