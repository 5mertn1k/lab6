package validate;
import human.ValidateException;
public interface Validator<T> {
    void validate(T object)
            throws ValidateException;
}