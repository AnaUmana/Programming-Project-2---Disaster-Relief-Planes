/*
 * DisasterRelief Plan
 *
 * This code will be used to create a program that will be used to help distribute supploes to affected disaster areas
 * Anita Umana
 * 02/11/2024
 * CMSC 255, Section 901
*/

import java.util.Scanner;

public class DisasterRelief {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    //First you will need to print the first question to the user
    System.out.println("Would you like to randomly generate a population (1) or enter it yourself (2)?");
    
    //This next line will interpret the use choice the user input to then use to come up either a random population or a manual population
    int choice = input.nextInt();
    int population;
    if (choice == 1) {
      population = (int) (Math.random() * (8000000 - 5000 + 1) + 5000);
      System.out.println(population);
    }
    else if (choice == 2) {
      System.out.println("Enter a population between 5000 and 8000000");
      population = input.nextInt();
      // This next line will be used to display incorrect input if the value is not between 5000 and 8000000
      while (population < 5000 || population > 8000000) {
        System.out.println("Incorrect Input");
        population = input.nextInt();
      }
      }
    // This next line will be used to display incorrect input if it is not choice 1 or 2
      else {
    System.out.println("Incorrect Input");
      return;
    }
// Before figuring out the amount of planes we need to store the original population
    int originalPopulation = population;

    //We need to determine the capacity each cargo plane can hold
    final int smallCapacity = 5000;
    final int mediumCapacity = 3 * smallCapacity;
    final int largeCapacity = 5 * mediumCapacity;
    final int industrialCapacity = 9 * largeCapacity;
      
    //Next we need to determine the int of cargo planes needed
    int industrialCargoPlanes = population / industrialCapacity;
    population %= industrialCapacity;

    int largeCargoPlanes = population / largeCapacity;
      population %= largeCapacity;

    int mediumCargoPlanes = population / mediumCapacity;
      population %= mediumCapacity;

    int smallCargoPlanes = (population + smallCapacity - 1) / smallCapacity;

    //Finally we need to display the number of cargo planes needed for the disaster
    System.out.println("To supply a population of " + originalPopulation + " people with supplies you must send out: ");
    if (industrialCargoPlanes > 0) {
      System.out.println(industrialCargoPlanes + " industrial cargo planes" + (industrialCargoPlanes == 0 ? "" : "(s)"));
    }
    if (largeCargoPlanes > 0) {
      System.out.println(largeCargoPlanes + " large cargo planes" + (largeCargoPlanes == 0 ? "" : "(s)"));
    }
    if (mediumCargoPlanes > 0) {
      System.out.println(mediumCargoPlanes + " medium cargo planes" + (mediumCargoPlanes == 0 ? "" : "(s)"));
  }
    if (smallCargoPlanes > 0) {
    System.out.println(smallCargoPlanes + " small cargo planes"+ (smallCargoPlanes == 0 ? "" : "(s)"));
    }  
  }
}