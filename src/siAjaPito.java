
import java.io.BufferedReader;
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

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        Stack pila = new Stack();
        LinkedList cola = new LinkedList();
        String infija = "5+5*3/2-2";
        double num1, num2, result;

        // Notacion infija a Notacion Postfija
        for (int i = 0; i < infija.length(); i++) {
            if ((infija.charAt(i) >= '0') && (infija.charAt(i) <= '9')) {
                cola.offer(Character.toString(infija.charAt(i)));
            } else if ((infija.charAt(i) >= '*') && (infija.charAt(i) <= '/')) {
                if (pila.isEmpty()) {
                    pila.push(Character.toString(infija.charAt(i)));
                } else if (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && (((Character) pila.peek() == '/') || ((Character) pila.peek() == '*'))) {
                    while (!pila.isEmpty()) {
                        cola.offer(Character.toString((Character) pila.pop()));
                    }
                    pila.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && (((Character) pila.peek() == '+') || ((Character) pila.peek() == '-'))) {
                    pila.push(Character.toString(infija.charAt(i)));
                } else if ((((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && (((Character) pila.peek() == '/') || ((Character) pila.peek() == '*'))) || (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && (((Character) pila.peek() == '+') || ((Character) pila.peek() == '-')))) {
                    cola.offer(Character.toString((Character)pila.pop()));
                    pila.push(Character.toString(infija.charAt(i)));
                }
            }
        }
        cola.offer(pila.pop());

        // Realizar operaciones
        /*while (!cola.isEmpty()) {
            switch ((char) cola.peek()) {
                case '+':
                    cola.poll();
                    num2 = Integer.parseInt(Character.toString((char)pila.pop()));
                    num1 = Integer.parseInt(Character.toString((char)pila.pop()));
                    result = (num1) + (num2);
                    pila.push(result);
                    break;
                case '-':
                    cola.poll();
                    num2 = Double.parseDouble(Character.toString((char)pila.pop()));
                    num1 = Double.parseDouble(Character.toString((char)pila.pop()));
                    result = (num1) - (num2);
                    pila.push(result);
                    break;
                case '/':
                    cola.poll();
                    num2 = Double.parseDouble(Character.toString(pila.pop()));
                    num1 = Double.parseDouble(Character.toString((char)pila.pop()));
                    result = (num1) / (num2);
                    pila.push(result);
                    break;
                case '*':
                    cola.poll();
                    num2 = Double.parseDouble(Character.toString((char)pila.pop()));
                    num1 = Double.parseDouble(Character.toString((char)pila.pop()));
                    result = (num1) * (num2);
                    pila.push(result);
                    break;
                default:
                    pila.push(cola.poll());
                    break;
            }
        }*/
        /*if ((char)pila2.peek() >= '*' && (char)pila2.peek() <= '/') {
                operador = (char)pila2.pop();
                num2 = (double)pila2.pop();
                num1 = (double)pila2.pop();
                result = (num1) + ((double)operador) + (num2);
                pila2.push(result);
            }*/
        while (!cola.isEmpty()) {
            System.out.print(cola.pop());
        }

        System.out.println("");

    }
}
