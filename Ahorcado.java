import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Hola! Bienvenido a mi primer juego en Java, espero te guste! Mucha suerte!");
        // Principalmente comienzo con una clase scanner para que los usuarios pueda interactuar
        Scanner scanner = new Scanner(System.in);

        // Declaración y Asignación de Variables
        String palabraSecreta = "parenlamano"; 
        int intentosMaximos = 10; 
        int intentos = 0; 
        boolean palabraAdivinada = false; 

        // Arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        
        // Estructura de Control: Iterativa (Bucle for)
        // Bucle for para poder imprimir la cantidad de caracteres que se necesitan para completar la palabra
        for (int i = 0; i < letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_'; // Con esto imprimimos la cantidad de letras con guiones
        }

        while (!palabraAdivinada && intentos < intentosMaximos){ 

            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra, por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0)); // Con este método solicitamos al usuario una letra y consola solo nos devolverá la primera letra que el usuario coloque
                        // Con el TLC pasamamos cualquier letra a minúscula

            boolean letraCorrecta = false; 
            for (int i = 0; i < palabraSecreta.length(); i++) {
                
                if (palabraSecreta.charAt(i) == letra) { // Estructura Control Condicional
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                    
                }
            }

            if (!letraCorrecta) { // Condición: En caso de que la letra sea incorrecta
                intentos ++; // Se incrementa un intento
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabras secreta: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("¡Qué pena te haz quedado sin intentos!");
            System.out.println("GAME OVER");
        }

        scanner.close(); // Cerranos el scanner
    }
}
