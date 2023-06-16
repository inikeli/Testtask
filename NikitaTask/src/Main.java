import javax.naming.OperationNotSupportedException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println( calc(scanner.nextLine()));
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

    }
  public static String calc(String input) throws OperationNotSupportedException,IllegalArgumentException,ArithmeticException, InputMismatchException {
        if (input.length()>5){
            throw new InputMismatchException("The format of the mathematical operation does not satisfy the task - two operands and one operator");
        }
        if (input.length()<5){
            throw new InputMismatchException("String is not a mathematical operation");
        }
        boolean arabian1=false;
      boolean arabian2=false;
      int num1 = 0;
      int num2 = 0;
      String s = "";
      String array[] = input.split(" ");
      String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
      for (int i = 0; i < roman.length; i++) {
          if (array[0].equals(roman[i])) {
              num1 = i;
              arabian1=true;
          }
          if (array[2].equals(roman[i])) {
              num2 = i;
              arabian2 = true;
          }
      }
      if (!arabian1 && !arabian2){
          num1 = Integer.parseInt(array[0]);
          num2 = Integer.parseInt(array[2]);

      }

      String operation = array[1];
      if (!Objects.equals(operation, "-") && !Objects.equals(operation, "+") && !Objects.equals(operation, "*") && !Objects.equals(operation, "/")) {
          throw new OperationNotSupportedException("Math.operation " + operation + " not exist!");

      }
      if (arabian1!=arabian2) {
          throw new IllegalArgumentException("Used different number systems");

      }

      String result = " ";
      int resultRoman=0;
      if (!arabian1 && !arabian2) {


          switch (operation) {
              case "+" -> {
                  result = String.valueOf(num1 + num2);

              }
              case "-" -> {
                  result = String.valueOf(num1 - num2);

              }
              case "*" -> {
                  result = String.valueOf(num1 * num2);

              }
              case "/" -> {
                  result = String.valueOf(num1 / num2);

              }
          }


          return result;

      }
      else {
          switch (operation) {
              case "+" -> {
                  resultRoman = (num1 + num2);

              }
              case "-" -> {
                  resultRoman = (num1 - num2);

              }
              case "*" -> {
                  resultRoman = (num1 * num2);

              }
              case "/" -> {
                  resultRoman = (num1 / num2);
                  if (resultRoman==0){
                      resultRoman += 1;
                  }

              }
          }
          if (resultRoman <= 0){
              throw new ArithmeticException("There are no negative numbers in the Roman system");
          }
          while (resultRoman >= 100) {
              s += "C";
              resultRoman -= 100;
          }
          while (resultRoman >= 90) {
              s += "XC";
              resultRoman -= 90;
          }
          while (resultRoman >= 50) {
              s += "L";
              resultRoman -= 50;
          }
          while (resultRoman >= 40) {
              s += "XL";
              resultRoman-= 40;
          }
          while (resultRoman >= 10) {
              s += "X";
              resultRoman -= 10;
          }
          while (resultRoman >= 9) {
              s += "IX";
              resultRoman -= 9;
          }
          while (resultRoman >= 5) {
              s += "V";
              resultRoman -= 5;
          }
          while (resultRoman >= 4) {
              s += "IV";
              resultRoman -= 4;
          }
          while (resultRoman >= 1) {
              s += "I";
              resultRoman -= 1;
          }



      }return s;
  }


}