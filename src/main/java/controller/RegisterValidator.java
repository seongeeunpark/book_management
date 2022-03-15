package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		
		ValidationUtils.rejectIfEmpty(errors, "isbn", "required");
		ValidationUtils.rejectIfEmpty(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "author", "required");
		ValidationUtils.rejectIfEmpty(errors, "publisher","required");
		ValidationUtils.rejectIfEmpty(errors, "price", "required");
		ValidationUtils.rejectIfEmpty(errors, "image", "required");
		ValidationUtils.rejectIfEmpty(errors, "introduction","required");
	}

}
