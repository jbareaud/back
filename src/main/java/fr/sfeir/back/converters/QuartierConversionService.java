package fr.sfeir.back.converters;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import fr.sfeir.back.beans.QuartierBean;
import fr.sfeir.back.entities.Quartier;

//@Service
//@Qualifier("convertQuartiers")
@Deprecated
public class QuartierConversionService implements ConversionService {

	@Override
	public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
		if (Quartier.class.equals(sourceType) && QuartierBean.class.equals(targetType)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
		throw new RuntimeException("not implemented");
	}

	@Override
	public <T> T convert(Object source, Class<T> targetType) {
//		if (Quartier.class.equals(source.getClass()) && QuartierBean.class.equals(targetType)) {
//			Quartier quartier = (Quartier) source;
//			return (T) new QuartierBean()
//				.setId(quartier.getId().toString())
//				.setPath(quartier
//					.getPoints()
//					.stream()
//					.map(p -> new PointBean(p.getLatitude().toString(), p.getLongitude().toString()))
//					.collect(Collectors.toList())
//					)
//				;
//		}
		return null;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		throw new RuntimeException("not implemented");
	}

}
