package appl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReceipeNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ReceipeNotFoundException(Long id) {
        super(id.toString());
    }
}
