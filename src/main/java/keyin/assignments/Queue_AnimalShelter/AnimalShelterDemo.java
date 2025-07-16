package keyin.assignments.Queue_AnimalShelter;


public class AnimalShelterDemo {
    public static void main(String[] args) {
        AnimalQueue shelter = new AnimalQueue();
        shelter.setCapacity(10);

        System.out.println("Current number of animals at shelter: " + shelter.getSize());

        // Enqueue 10 animals
        shelter.enqueue(new Animal("Buddy", Type.DOG));
        shelter.enqueue(new Animal("Rex", Type.DOG));
        shelter.enqueue(new Animal("Whiskers", Type.CAT));
        shelter.enqueue(new Animal("Luna", Type.CAT));
        shelter.enqueue(new Animal("Max", Type.DOG));
        shelter.enqueue(new Animal("Mittens", Type.CAT));
        shelter.enqueue(new Animal("Charlie", Type.DOG));
        shelter.enqueue(new Animal("Cleo", Type.CAT));
        shelter.enqueue(new Animal("Rocky", Type.DOG));
        shelter.enqueue(new Animal("Daisy", Type.CAT));
        shelter.enqueue(new Animal("Felix", Type.CAT));

        System.out.println("Current number of animals at shelter: " + shelter.getSize());

        // Print initial queue head
        System.out.println("First animal in queue: " + shelter.peek());

        // Dequeue any animal
        Animal adopted1 = shelter.dequeueAny();
        System.out.println("Adopted (any): " + adopted1);

        // Dequeue first cat
        Animal adopted2 = shelter.dequeueAnimal(Type.CAT);
        System.out.println("Adopted (first cat): " + adopted2);

        // Check new front of queue
        System.out.println("New front of queue: " + shelter.peek());
    }
}

