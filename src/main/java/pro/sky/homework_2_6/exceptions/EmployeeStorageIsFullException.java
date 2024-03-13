package pro.sky.homework_2_6.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {

    private final String message;

    public EmployeeStorageIsFullException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmployeeStorageIsFullException{" +
                "message='" + message + '\'' +
                '}';
    }

}