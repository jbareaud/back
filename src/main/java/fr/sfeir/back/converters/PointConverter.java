package fr.sfeir.back.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.sfeir.back.beans.PointBean;
import fr.sfeir.back.entities.Point;

@Component
public class PointConverter implements Converter<Point, PointBean> {

	@Override
	public PointBean convert(Point source) {
		return new PointBean()
				.setLatitude(source.getLatitude().toString())
				.setLongitude(source.getLongitude().toString());
	}


}
