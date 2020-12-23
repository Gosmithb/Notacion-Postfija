
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

        Stack pila1 = new Stack();
        Stack pila2 = new Stack();
        LinkedList cola = new LinkedList();
        String infija = "5+5*3/2-2";
        String salida = "";
        char operador;
        double num1, num2, result;

        // Notacion infija a Notacion Postfija
        for (int i = 0; i < infija.length(); i++) {
            if ((infija.charAt(i) >= '0') && (infija.charAt(i) <= '9')) {
                cola.offer(infija.charAt(i));
            } else if ((infija.charAt(i) >= '*') && (infija.charAt(i) <= '/')) {
                if (pila1.isEmpty()) {
                    pila1.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && (((char) pila1.peek() == '/') || ((char) pila1.peek() == '*'))) {
                    while (!pila1.isEmpty()) {
                        cola.offer(pila1.pop());
                    }
                    pila1.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && (((char) pila1.peek() == '+') || ((char) pila1.peek() == '-'))) {
                    pila1.push(infija.charAt(i));
                } else if ((((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && (((char) pila1.peek() == '/') || ((char) pila1.peek() == '*'))) || (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && (((char) pila1.peek() == '+') || ((char) pila1.peek() == '-')))) {
                    cola.offer(pila1.pop());
                    pila1.push(infija.charAt(i));
                }
            }
        }
        cola.offer(pila1.pop());

        // Realizar operaciones
        while (!cola.isEmpty()) {
            if ((char) cola.peek() == '+') {
                cola.poll();
                num2 = (double) pila2.pop();
                num1 = (double) pila2.pop();
                result = (num1) + (num2);
                pila2.push(result);
            } else if ((char) cola.peek() == '-') {
                cola.poll();
                num2 = (double) pila2.pop();
                num1 = (double) pila2.pop();
                result = (num1) - (num2);
                pila2.push(result);
            } else if ((char) cola.peek() == '/') {
                cola.poll();
                num2 = (double) pila2.pop();
                num1 = (double) pila2.pop();
                result = (num1) / (num2);
                pila2.push(result);
            } else if ((char) cola.peek() == '*') {
                cola.poll();
                num2 = (double) pila2.pop();
                num1 = (double) pila2.pop();
                result = (num1) * (num2);
                pila2.push(result);
            } else {
                pila2.push(cola.poll());
            }
        }
        /*if ((char)pila2.peek() >= '*' && (char)pila2.peek() <= '/') {
                operador = (char)pila2.pop();
                num2 = (double)pila2.pop();
                num1 = (double)pila2.pop();
                result = (num1) + ((double)operador) + (num2);
                pila2.push(result);
            }*/
        while (!pila2.isEmpty()) {
            System.out.print(pila2.pop());
        }

        System.out.println("");

    }
}
