package luizdasilva.backend.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import luizdasilva.backend.core.exception.InvalidUserTypeException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum UserTypeEnum {
    ADMIN,
    TEACHER,
    STUDENT;

    @JsonCreator
    public static UserTypeEnum fromString(String value) throws InvalidUserTypeException {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return UserTypeEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidUserTypeException("Invalid user type: " + value);
        }
    }
}
