package lesson15.appExample.core.validation;

import lesson15.appExample.DTO.ToDoDtoRequest;

public class ToDoDescriptionMaxLengthValidation {

    public void validation(ToDoDtoRequest request){
        if (request.getDescription().length() > 30) {
            throw new IllegalStateException("ToDo description length more than 30 ...");
        }
    }
}
