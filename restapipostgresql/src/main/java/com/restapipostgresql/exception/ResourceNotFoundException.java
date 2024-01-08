package  com.restapipostgresql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restapipostgresql.model.ApiError;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private ApiError apiError;
	public ResourceNotFoundException(ApiError apiError) {
		super();
		this.apiError=apiError;
	}
}