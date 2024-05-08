package io.github.jdevlibs.faces.convertor;


import io.github.jdevlibs.faces.FacesUtils;
import io.github.jdevlibs.utils.DateFormats;
import io.github.jdevlibs.utils.Validators;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.DateTimeConverter;
import jakarta.faces.convert.FacesConverter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author supot.jdev
 * @version 1.0
 */
@Slf4j
@FacesConverter("customDateTimeFullConverter")
public class CustomDateTimeFullConverter extends DateTimeConverter {
    public CustomDateTimeFullConverter() {
        setPattern("dd MMMM yyyy HH:mm:ss");
        setLocale(FacesUtils.getLocale());
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
        try {
            if (Validators.isNull(value)) {
                return "";
            }

            if (value instanceof String) {
                return (String) value;
            }

            if (value instanceof Date) {
                return DateFormats.format((Date) value, getPattern(), FacesUtils.getLocale());
            } else if (value instanceof LocalDate) {
                return DateFormats.format((LocalDate) value, getPattern(), FacesUtils.getLocale());
            } else if (value instanceof LocalDateTime) {
                return DateFormats.format((LocalDateTime) value, getPattern(), FacesUtils.getLocale());
            }

            return value.toString();
        } catch (ConverterException ex) {
            log.error("customDateTimeConverter[Error]", ex);
        }

        return null;
    }
}