package dio.springboot.angular.saladereuniao.saladereuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoungException extends Exception {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoungException(String message){
        super(message);
    }

}
