package io.naztech.prescription.conv;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2019-01-16
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime val) {
		return val == null ? null : Timestamp.valueOf(val);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp data) {
		return data == null ? null : data.toLocalDateTime();
	}
}