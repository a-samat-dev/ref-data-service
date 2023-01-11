package kz.samat.refdataservice.exception;

import kz.samat.refdataservice.model.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

/**
 * Exception handling logic
 * <p>
 * Created by Samat Abibulla on 2022-11-15
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Exception handling logic for {@link CustomException}
     *
     * @param ex exception thrown
     * @return http response entity
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomException(CustomException ex) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .dateTime(OffsetDateTime.now())
                .status(ex.getStatus())
                .code(ex.getStatus().value())
                .error(ex.getError())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponseDTO, ex.getStatus());
    }
}
