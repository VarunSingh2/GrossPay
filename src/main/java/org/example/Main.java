package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
class BadNumberException extends RuntimeException {
    public BadNumberException(String payRate) {
        super(String.format("Invalid contact: %s", payRate));
    }

}

class BadNameException extends RuntimeException{
    public BadNameException(String payRate) {
        super(String.format("Invalid Name: %s", payRate));
    }
}

class InvalidPayRateException extends RuntimeException {
    public InvalidPayRateException(String payRate) {
       super(String.format("Invalid payRate: %s", payRate));
    }
}

class InvalidHoursWorkedException extends RuntimeException {
    public InvalidHoursWorkedException(String payRate) {
        super(String.format("Invalid Hours Worked: %s", payRate));
    }
}
class InvalidIdException extends RuntimeException {
    public InvalidIdException(String payRate) {
        super(String.format("Invalid Id: %s", payRate));
    }
}

class Employee {

    double numberOfHours;
    double payRate;
    int Id;
    String address;
    String Name;
    String contactNumber;
    public Employee() {

    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) throws BadNameException {
        try {
            if (contactNumber.length() != 10) {
                throw new BadNumberException("Enter the Phone Number in the Correct Format");
            }
            for (int z = 0; z < contactNumber.length(); z++) {
                if (!Character.isDigit(contactNumber.charAt(z))) {
                    throw new BadNumberException("Enter only Digits no Variables");
                }
            }
        }
        catch (Exception e){
            System.out.println("Exception"+e);
        }
        this.contactNumber = contactNumber;
    }

    public String getName() throws BadNameException {
        return Name;
    }
    public void setName(String name){
        try {
            for (int x = 0; x < name.length(); x++) {
                if (!Character.isAlphabetic(name.charAt(x)))
                    throw new BadNameException("Enter your Name in correct");
            }
        }
        catch (Exception e){
            System.out.println("Exception"+e);
        }
        Name = name;
    }

    public double getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(double numberOfHours)throws InvalidHoursWorkedException {
        try {
            if (numberOfHours < 0)
                throw new InvalidHoursWorkedException("Invalid number of hours worked provided for employee");
            else if (numberOfHours > 84) {
                throw new InvalidHoursWorkedException("Invalid number of hours worked provided for employee");
            }
        }
        catch (Exception e){
            System.out.println("Exception"+e);
        }
        this.numberOfHours = numberOfHours;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate)throws InvalidPayRateException {
        try {
            if (payRate < 0)
                throw new InvalidPayRateException("Invalid hourly pay rate provided for employee");
            else if (payRate > 25) {
                throw new InvalidPayRateException("Invalid hourly pay rate provided for employee");
            }
        }
        catch (Exception e){
            System.out.println("Exception"+e);
        }
        this.payRate=payRate;
    }

    public double grossPay() {
        return payRate * numberOfHours;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) throws InvalidIdException {
        try {

            if (id <= 0) {
                throw new InvalidIdException("Invalid ID number: " + id);
            }
        }
        catch (Exception e){
            System.out.println("Exception"+e);
        }
        this.Id = id;
    }


}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee obj1 = new Employee();
        System.out.println("Enter Id: ");
        int Id;
        double hours;
        double payRate;
        String Name;
        String Address;
        try {
            Id = sc.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Please input a number, not a letter or symbol.");
            return;
        }
        obj1.setId(Id);

        System.out.println("Enter name: ");
        sc.nextLine();
        Name = sc.nextLine();
        obj1.setName(Name);

        System.out.println("Enter Contact number: ");
        String Contact = sc.nextLine();
        obj1.setContactNumber(Contact);

        System.out.println("Enter address: ");
        Address = sc.nextLine();
        obj1.setAddress(Address);

        System.out.println("Enter number of hours: ");
        try {
            hours = sc.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Please input a number, not a letter or symbol.");
            return;
        }
        obj1.setNumberOfHours(hours);


        System.out.println("Enter pay rate in $: ");
        try {
            payRate = sc.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Please input a number, not a letter or symbol.");
            return;
        }
        obj1.setPayRate(payRate);


        double GrossPay = obj1.grossPay();
        System.out.println("Name: "+obj1.getName()+"\n"+"ContactNumber: "+obj1.getContactNumber()+"\n"+"Id: "+obj1.getId()+"\n"+"Address: "+obj1.getAddress()+"\n"+"Total pay: " + GrossPay + " $");

    }
}