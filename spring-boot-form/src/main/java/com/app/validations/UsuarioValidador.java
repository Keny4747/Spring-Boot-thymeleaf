package com.app.validations;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.app.form.controller.models.domain.Usuario;
//Validación personalizada con la clase validator
@Component
public class UsuarioValidador  implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
			
		ValidationUtils.rejectIfEmpty(errors, "nombre", "message.validation.nombre");
	}

}
