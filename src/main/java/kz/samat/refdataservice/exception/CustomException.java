package kz.samat.refdataservice.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Custom exception that is caught by exception handler
 *
 * Created by Samat Abibulla on 2022-11-15
 */
@Data
@Builder
public class CustomException extends RuntimeException {

    private HttpStatus status;
    private String error;
    private String message;
}
