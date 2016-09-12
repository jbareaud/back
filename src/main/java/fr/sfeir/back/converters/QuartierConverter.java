package fr.sfeir.back.converters;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.sfeir.back.db.entities.Quartier;
import fr.sfeir.back.webservices.beans.PointBean;
import fr.sfeir.back.webservices.beans.QuartierBean;

@Component
public class QuartierConverter implements Converter<Quartier, QuartierBean>{

	@Autowired
	@Lazy
	private ConversionService conversionService;
	
	@Override
	public QuartierBean convert(Quartier source) {
		return new QuartierBean()
			.setId(source.getId().toString())
			.setPath(
				source
				.getPoints()
				.stream()
				.map(p -> conversionService.convert(p, PointBean.class))
				.collect(Collectors.toList())
			)
			;
	}
	
}
