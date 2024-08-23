
package parcial1g2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        Scanner guaji = new Scanner(System.in);
        int numVehiculos = 0;
 
        // solicitar el número de vehículos con manejo de excepciones
        while (true) {
            try {
                System.out.print("¿Cuántos vehículos desea calcular? ");
                numVehiculos = guaji.nextInt();
 
                if (numVehiculos <= 0) {
                    System.out.println("El número de vehículos debe ser mayor que 0.");
                    continue;
                }
                break; 
 
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                guaji.next(); 
            }
        }
 
        // procesar cada vehículo
        for (int i = 1; i <= numVehiculos; i++) {
            int decada = 0;
            double avaluo = 0.0;
 
            // solicitar la década del modelo con manejo de excepciones
            while (true) {
                try {
                    System.out.print("\nVehículo " + i + ": Ingrese la década del modelo del vehículo (90, 00, 10, 20): ");
                    decada = guaji.nextInt();
 
                    if (decada != 90 && decada != 00 && decada != 10 && decada != 20) {
                        System.out.println("Década inválida. Debe ser 90, 00, 10 o 20.");
                        continue;
                    }
                    break; 
 
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    guaji.next(); 
                }
            }
 
            // solicitar el avalúo del vehículo con manejo de excepciones
            while (true) {
                try {
                    System.out.print("Ingrese el avalúo del vehículo: ");
                    avaluo = guaji.nextDouble();
 
                    if (avaluo <= 0) {
                        System.out.println("El avalúo debe ser un número positivo.");
                        continue;
                    }
                    break; 
 
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                    guaji.next(); 
                }
            }
 
            // calcular los impuestos
            double tasaRodamiento = obtenerTasaRodamiento(decada);
            double tasaSeguro = obtenerTasaSeguro(decada);
            double impuestoRodamiento = avaluo * tasaRodamiento;
            double seguro = avaluo * tasaSeguro;
            double totalAPagar = impuestoRodamiento + seguro;
 
            // mostrar los resultados
            System.out.println("Avalúo: $" + avaluo);
            System.out.println("Década del vehículo: " + decada);
            System.out.println("Total a pagar: $" + totalAPagar);
        }
 
           guaji.close();
    }
 
    //  obtener las tasas correspondientes según la década
    public static double obtenerTasaRodamiento(int decada) {
        switch (decada) {
            case 90:
                return 0.0409;
            case 00:
                return 0.0434;
            case 10:
                return 0.0493;
            case 20:
                return 0.0568;
            default:
                return 0.0; 
        }
    }
 
    public static double obtenerTasaSeguro(int decada) {
        switch (decada) {
            case 90:
                return 0.00816;
            case 00:
                return 0.00798;
            case 10:
                return 0.00712;
            case 20:
                return 0.00699;
            default:
                return 0.0; 
        }
    }
}
    

