package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        ArrayList<Person> myPeople = new ArrayList<>();
        //MAKE 10 PEOPLE
        myPeople.add(new Person("Charlie ", "Harmon", 45));
        myPeople.add(new Person("Gabriela ", "Gould", 34));
        myPeople.add(new Person("Margaret ", "Rose", 80));
        myPeople.add(new Person("Blanca", "Bailey", 32));
        myPeople.add(new Person("Everette", "Barber", 38));
        myPeople.add(new Person("Tracy", "Kane", 29));
        myPeople.add(new Person("Jared", "Deleon", 27));
        myPeople.add(new Person("Jaziel", "French", 24));
        myPeople.add(new Person("Tonia", "Logan", 22));
        myPeople.add(new Person("Aida", "Hutchinson", 29));


        Scanner myScanner = new Scanner(System.in);
        ArrayList<Person> searchResults = new ArrayList<>();
        String userInput;
        float totalAge = 0;



        //Initilize the youngest and oldest with the first person on the list to compare
        Person oldestPerson = myPeople.get(0);
        Person youngest = myPeople.get(0);


        System.out.print("Enter the first or last name you would like to search: ");
        userInput = myScanner.nextLine().toLowerCase();

        for (Person item : myPeople) {
            if (item.firstName.toLowerCase().equals(userInput) || item.lastName.toLowerCase().equals(userInput)) {
                searchResults.add(item);
            }
            if (item.age < youngest.age) {
                youngest = item;
            }
            if (item.age > oldestPerson.age) {
                oldestPerson = item;
            }
            totalAge += item.age;
        }

        System.out.println("############### Search Results ################");
        if (searchResults.size() == 0) {
            System.out.println("Nothing was found in search results");
        }
        else {
            for(Person item : searchResults) {
                System.out.println(item.display());
            }
        }

        System.out.printf("""
                ################## People Analytics ###################
                The oldest person is: %s with an age of %d
                
                The youngest Person is %s with an age of %d
                
                The average age is: %.0f
                """, (oldestPerson.firstName + " " + oldestPerson.lastName), oldestPerson.age,  (youngest.firstName + " " + youngest.lastName), youngest.age, (totalAge / myPeople.size()));

    }
}
