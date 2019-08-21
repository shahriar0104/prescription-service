package io.naztech.prescription.conv;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2019-01-16
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate val) {
		return val == null ? null : Date.valueOf(val);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date data) {
		return data == null ? null : data.toLocalDate();
	}
}