//package array_con_hilo;

import java.util.Scanner;

class Main {
	private static Scanner cin;

	public static void main(String args[]) {
		int tam, cantidad_hilos = 0;

		int numberToFind;
		cin = new Scanner(System.in);

		System.out.print("Tamaño del arreglo: ");
		tam = cin.nextInt();

		int arreglo[] = new int[tam];

		for (int i = 0; i < tam; i++) {
			arreglo[i] = (int) (Math.random() * (0 - 99) + 99);

			if (i != 0) {
				for (int j = 0; j < i; j++) {
					if (arreglo[j] == arreglo[i]) {
						i = i - 1;
						break;
					}
				}
			}
		}

		for (int i = 0; i < tam; i++) {
			System.out.print(arreglo[i] + " ");
		}

		System.out.print("\nCantidad de Hilos: ");
		cantidad_hilos = cin.nextInt();
		System.out.print("\nNumero a encotrar: ");
		numberToFind = cin.nextInt();

		int indice = tam / cantidad_hilos;
		int aux = 0, num = 0;

		int index[] = new int[cantidad_hilos];

		for (int k = 0; k < cantidad_hilos; k++) {
			num = (aux + indice) - indice;
			index[k] = num;
			aux = aux + indice;

		}

		Search[] obj = new Search[cantidad_hilos];
		Thread[] hilo = new Thread[cantidad_hilos];

		for (int a = 0; a < cantidad_hilos; a++) {
			obj[a] = new Search(numberToFind, arreglo, index[a], indice, a + 1);
			hilo[a] = new Thread(obj[a]);
			hilo[a].start();
		}

	}

}

public class Search implements Runnable {
	private int arreglo[];
	private int index, vueltas, numero, numeroDeHilo;

	public Search(int numero, int arreglo[], int index, int vueltas, int numeroDeHilo) {
		this.arreglo = arreglo;
		this.index = index;
		this.vueltas = vueltas;
		this.numero = numero;
		this.numeroDeHilo = numeroDeHilo;
	}

	public void run() {
		boolean noFind = false;

		for (int i = 0; i < vueltas; i++) {
			if (arreglo[index] == numero) {

				System.out.println("Hilo " + numeroDeHilo + ": numero encontrado!, en el indice " + index);
				noFind = true;
				break;
			}
			index++;
		}
		if (noFind == false) {
			System.out.println("Hilo " + numeroDeHilo + ": numero no encontrado!");
		}
	}// RUN

}
