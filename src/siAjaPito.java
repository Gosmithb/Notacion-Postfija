
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

        Stack<Character> pila1 = new Stack();
        Stack pila2 = new Stack();
        LinkedList cola = new LinkedList();
        String infija = "5+5*3/2-2";
        String salida = "";
        char operador;
        double num1, num2;

        // Notacion infija a Notacion Postfija
        for (int i = 0; i < infija.length(); i++) {

            if ((infija.charAt(i) >= 0) && (infija.charAt(i) <= 9)) {

                cola.offer(infija.charAt(i));

            } else {//if ((infija.charAt(i) >= '*') && (infija.charAt(i) <= '/')) {

                if (pila1.isEmpty()) {
                    pila1.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && ((pila1.peek() == '/') || (pila1.peek() == '*'))) {
                    while (!pila1.isEmpty()) {
                        cola.offer(pila1.pop());
                    }
                    pila1.push(infija.charAt(i));
                } else if (((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && ((pila1.peek() == '+') || (pila1.peek() == '-'))) {
                    pila1.push(infija.charAt(i));
                } else if ((((infija.charAt(i) == '/') || (infija.charAt(i) == '*')) && ((pila1.peek() == '/') || (pila1.peek() == '*'))) || (((infija.charAt(i) == '+') || (infija.charAt(i) == '-')) && ((pila1.peek() == '+') || (pila1.peek() == '-')))) {
                    cola.offer(pila1.pop());
                    pila1.push(infija.charAt(i));
                }
            }
        }
        cola.offer(pila1.pop());

        while (!cola.isEmpty()) {
            System.out.print(cola.poll());
        }
        while (!pila1.isEmpty()) {
            System.out.println(pila1.pop());
        }
        System.out.println("");

    }
}
