
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryan
 */
public class siAjaPito {

    public static BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Stack pila = new Stack();
        LinkedList cola = new LinkedList();
        String infija;
        String salida;
        
        System.out.println("Ingrese operaciones sin parentesis:");
        infija = kb.readLine();
        
        // Notacion infija a postfija
        cola = notacionInfijaAPostFija(infija, cola, pila);  

        // Realizar Operaciones Correspondientes
        salida = Operaciones(cola, pila);

        System.out.println(salida);
        System.out.println("");

    }

    private static LinkedList notacionInfijaAPostFija(String infija, LinkedList cola, Stack pila) {
        for (int i = 0; i < infija.length(); i++) {
            if ((infija.charAt(i) >= '0') && (infija.charAt(i) <= '9')) {
                cola.offer(infija.charAt(i));
            } else if ((infija.charAt(i) >= '*') && (infija.charAt(i) <= '/')) {
                if (pila.isEmpty()) {
                    pila.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && (((char) pila.peek() == '/') || ((char) pila.peek() == '*'))) {
                    while (!pila.isEmpty()) {
                        cola.offer(pila.pop());
                    }
                    pila.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && (((char) pila.peek() == '+') || ((char) pila.peek() == '-'))) {
                    pila.push(infija.charAt(i));
                } else if ((((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && (((char) pila.peek() == '/') || ((char) pila.peek() == '*'))) || (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && (((char) pila.peek() == '+') || ((char) pila.peek() == '-')))) {
                    cola.offer(pila.pop());
                    pila.push(infija.charAt(i));
                }
            }
        }
        cola.offer(pila.pop());
        return cola;
    }

    private static String Operaciones(LinkedList cola, Stack pila) {
        double num1, num2, result;
        while (!cola.isEmpty()) {
            switch ((char) cola.peek()) {
                case '+':
                    cola.poll();
                    num2 = Double.parseDouble(pila.pop().toString());
                    num1 = Double.parseDouble(pila.pop().toString());
                    result = (num1) + (num2);
                    pila.push(result);
                    break;
                case '-':
                    cola.poll();
                    num2 = Double.parseDouble(pila.pop().toString());
                    num1 = Double.parseDouble(pila.pop().toString());
                    result = (num1) - (num2);
                    pila.push(result);
                    break;
                case '/':
                    cola.poll();
                    num2 = Double.parseDouble(pila.pop().toString());
                    num1 = Double.parseDouble(pila.pop().toString());
                    result = (num1) / (num2);
                    pila.push(result);
                    break;
                case '*':
                    cola.poll();
                    num2 = Double.parseDouble(pila.pop().toString());
                    num1 = Double.parseDouble(pila.pop().toString());
                    result = (num1) * (num2);
                    pila.push(result);
                    break;
                default:
                    pila.push(cola.poll());
                    break;
            }
        }
        return pila.pop().toString();
    }
}
