package pro.sky.homework_2_6.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {

    private final String message;

    public EmployeeAlreadyAddedException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmployeeAlreadyAddedException{" +
                "message='" + message + '\'' +
                '}';
    }

}