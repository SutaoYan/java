package com;

import java.io.*;
import java.util.*;

public class Main2 {
    private static class Person {
        public int id;
        public boolean seen;
        public ArrayList<Person> shorter;
        public ArrayList<Person> taller;

        public Person(int id) {
            this.id = id;
            this.seen = false;
            shorter = new ArrayList<>();
            taller = new ArrayList<>();
        }
    }

    // DFS
    public static boolean searchForShorter(Person source, Person target) {
        Queue<Person> peopleToCheck = new LinkedList<>();
        peopleToCheck.addAll(source.shorter);
        while(!peopleToCheck.isEmpty()) {
            Person nextPerson = peopleToCheck.remove();
            if(!nextPerson.seen) {
                nextPerson.seen = true;
                if(nextPerson.id == target.id) {
                    return true;
                }

                for(Person friend : nextPerson.shorter) {
                    if(!friend.seen){
                        peopleToCheck.add(friend);
                    }
                }
            }
        }
        return false;
    }

    public static boolean searchForTaller(Person source, Person target) {
        Queue<Person> peopleToCheck = new LinkedList<>();
        peopleToCheck.addAll(source.taller);
        while(!peopleToCheck.isEmpty()) {
            Person nextPerson = peopleToCheck.remove();
            if(!nextPerson.seen) {
                nextPerson.seen = true;
                if(nextPerson.id == target.id) {
                    return true;
                }

                for(Person friend : nextPerson.taller) {
                    if(!friend.seen){
                        peopleToCheck.add(friend);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try{

            // Scanner in = new Scanner(System.in);
            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int noOfPeople = Integer.parseInt(st.nextToken());

            Map<Integer, Person> people = new HashMap<>();
            for(int i = 1; i <= noOfPeople; i++) {
                people.put(i, new Person(i));
            }

            int noOfComparisons = Integer.parseInt(st.nextToken());
            for(int i = 0; i < noOfComparisons; i++) {
                st = new StringTokenizer(in.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                Person firstPerson = people.get(first);
                Person secondPerson = people.get(second);

                firstPerson.shorter.add(secondPerson);
                secondPerson.taller.add(firstPerson);
            }

            st = new StringTokenizer(in.readLine());
            int taller = Integer.parseInt(st.nextToken());
            int shorter = Integer.parseInt(st.nextToken());
            Person tallerPerson = people.get(taller);
            Person shorterPerson = people.get(shorter);

            if(tallerPerson == null || shorterPerson == null) {
                System.out.println("unknown");
                return;
            }

            if(searchForShorter(tallerPerson, shorterPerson)) {
                System.out.println("yes");

                for (Person person: people.values()) {
                    person.seen = false;
                }

            } else if(searchForTaller(tallerPerson, shorterPerson)) {
                System.out.println("no");
            } else {
                System.out.println("unknown");
            }

        }

        catch(IOException e){
            System.out.println("IO: General");
        }

    }
}