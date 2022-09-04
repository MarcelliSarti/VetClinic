package model;

public class Main {
    public static void main(String args[])
    {
        // Client c1 = new Client(1, "Marcelli", "46323526832", "rua formosa 145, parque flamingo", "17996577942", "15803222", "marcellisarti@hotmail.com");;
        
        // Animal a1 = new Animal(1, "Jink WInk", 4, 'F');
        // Animal a2 = new Animal(1, "Penelope", 13, 'F');

        // c1.addAnimal(a1);
        // c1.addAnimal(a2);

        Animal a1 = AnimalDAO.getInstance().createAnimal("Jink WInk", "4", "F");
        // Animal a1 = AnimalDAO.getInstance().retrieveById(1);;
        
        System.out.println(a1);
    }
    
}
