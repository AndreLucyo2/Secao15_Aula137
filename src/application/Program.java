package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

// Problema exemplo
// Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto, data
// de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua dura��o em
// dias. Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar
// novamente a reserva com os dados atualizados. O programa n�o deve aceitar dados
// inv�lidos para a reserva, conforme as seguintes regras:
// - Altera��es de reserva s� podem ocorrer para datas futuras
// - A data de sa�da deve ser maior que a data de entrada
public class Program
{

	// � Solu��o 2 (ruim): m�todo retornando string
	// � A sem�ntica da opera��o � prejudicada
	// � Retornar string n�o tem nada a ver com atualiza��o de reserva
	// � E se a opera��o tivesse que retornar um string?
	// � Ainda n�o � poss�vel tratar exce��es em construtores
	// � Ainda n�o h� aux�lio do compilador: o programador deve "lembrar" de
	// verificar se houve erro
	// � A l�gica fica estruturada em condicionais aninhadas

	public static void main(String[] args) throws ParseException
	{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		
		if (!checkOut.after(checkIn))// Valida se a data de checkOut � posterior ao checkIn
		{
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else
		{
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			//que indica se retornou erro ou n�o: o metodo retornar o string se der erro:
			String error = reservation.updateDates(checkIn, checkOut);
			
			//Testa se retornou algum erro:
			if (error != null)
			{
				System.out.println("Error in reservation: " + error);
			}
			else
			{
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}
}
