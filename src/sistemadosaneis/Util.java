package sistemadosaneis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	public String convertNumber(int num, String type) {
        switch (type.toLowerCase()) {
            case "binary":
                return Integer.toBinaryString(num);
            case "octal":
                return Integer.toOctalString(num);
            case "hex":
                return Integer.toHexString(num);
            default:
                return "Formato inválido. Use: binario, octal ou hexadecimal.";
        }
    }
	
	public int randomInt(int max) {
        return (int) (Math.random() * max) + 1;
    }
	
	public boolean convertEvent(Scanner input, String type, int maxNumber, String successMessage, String failureMessage) {
		int randomInt = this.randomInt(maxNumber);
        String numToConvert = this.convertNumber(randomInt, type);
        System.out.printf("Converta o número '%s' decimal.\n", numToConvert);
        
        int attempts = 3;
        boolean success = false;
        int choice;
        do {
        	try {
        		choice = input.nextInt();
        	} catch (InputMismatchException e) {
				input.next();
				choice = -1;
        	}
            
            if (choice == randomInt) {
				System.out.println(successMessage);
				success = true;
			} else {
				attempts--;
				if (attempts > 0) {
					System.out.println("Conversão incorreta. Tente novamente. Tentativas restantes: " + attempts);
				} else {
					System.out.println(failureMessage + " O número correto era: " + randomInt);
				}
			}
        } while (attempts > 0 && !success);
        return success;
	}
}
