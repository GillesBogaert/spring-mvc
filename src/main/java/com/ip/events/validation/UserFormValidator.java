package com.ip.events.validation;

import com.ip.events.model.Event;
import com.ip.events.service.EventService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    @Autowired
    @Qualifier("dateValidator")
    DateValidator dateValidator;


    @Override
    public boolean supports(Class<?> type) {
        return Event.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "valid.startDate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "valid.endDate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
        Event event = (Event) o;
        if (!errors.hasFieldErrors("endDate")) {
            if (!dateValidator.isValidFormat("dd/MM/yyyy HH:mm", event.getEndDate())) {
                errors.rejectValue("endDate", "valid.endDate.format");
            }
        }
        if (!errors.hasFieldErrors("startDate")) {
            if (!dateValidator.isValidFormat("dd/MM/yyyy HH:mm", event.getStartDate())) {
                errors.rejectValue("startDate", "valid.startDate.format");
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime startDate = LocalDateTime.parse(event.getStartDate(), formatter);
                LocalDateTime endDate = LocalDateTime.parse(event.getEndDate(), formatter);

                if (startDate.isAfter(endDate) || startDate.isEqual(endDate)) {
                    errors.rejectValue("startDate", "valid.dates");
                    errors.rejectValue("endDate", "valid.dates");
                }
            }
        }
    }
}