package nl.paulzijlmans.transactions.exception;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

  @Serial
  private static final long serialVersionUID = -6164868802430583771L;

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
