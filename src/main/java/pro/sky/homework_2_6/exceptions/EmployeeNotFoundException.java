package pro.sky.homework_2_6.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    private final String message;

    public EmployeeNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmployeeNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }

}