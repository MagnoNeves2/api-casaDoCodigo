package br.com.magoos.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.magoos.casadocodigo.model.dto.ErroDTO;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroDTO> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(erro -> {
			String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			ErroDTO e = new ErroDTO(erro.getField(), mensagem);
			dto.add(e);
		});

		return dto;
	}

}
