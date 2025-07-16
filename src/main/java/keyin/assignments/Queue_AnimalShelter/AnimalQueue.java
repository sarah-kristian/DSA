package keyin.assignments.Queue_AnimalShelter;

public class AnimalQueue {
    private Animal frontOfQueue;
    private Animal backOfQueue;
    private int nItems;
    private int capacity;


    public AnimalQueue(){
        frontOfQueue = backOfQueue = null;
        nItems = 0;
        capacity = 10;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return nItems;
    }
    public void setSize(int size) {
        this.nItems = size;
    }
    public Animal getFrontOfQueue() {
        return frontOfQueue;
    }
    public void setFrontOfQueue(Animal frontOfQueue) {
        this.frontOfQueue = frontOfQueue;
    }
    public Animal getBackOfQueue() {
        return backOfQueue;
    }

    private void createQueue(String name, Type type){
        Animal animal = new Animal(name, type);
        animal.next = null;
        frontOfQueue = backOfQueue = animal;
        nItems = 1;
    }


    public boolean isFull(){
        return nItems == capacity;
    }

    public boolean isEmpty (){
        return (nItems == 0);
    }


    //accept (enqueue) animal to shelter
    public void enqueue(Animal animal){
        if (isFull()){
            System.out.println("The shelter is full; no more animals can be accepted.");
        } else if (isEmpty()){
            createQueue(animal.getName(), animal.getType());

        } else {
            backOfQueue.next = animal;
            backOfQueue = animal;
            nItems++;
        }
    }

    //Peek
    public String peek(){
        if (isEmpty()){
            return "queue is empty";
        } else {
            return frontOfQueue.toString();
        }
    }

    //Adopt (dequeue) any animal
    public Animal dequeueAny(){
        if (isEmpty()){
            System.out.println("The shelter is not currently adopting animals");
            return null;
        } else {
            Animal result = frontOfQueue;
            frontOfQueue = frontOfQueue.next;
            if (nItems == 0) {
                backOfQueue = null;
            }
            nItems--;
            return result;
        }
    }

    //Adopt (dequeue) specific animal
    public Animal dequeueAnimal(Type type){
        if (isEmpty()){
            System.out.println("The shelter is not currently adopting animals");
            return null;
        }

        if (type == frontOfQueue.type ){
            Animal result = frontOfQueue;
            frontOfQueue = frontOfQueue.next;
            nItems--;

            if (nItems == 0) {
                backOfQueue = null;
            }
            return result;
        } else {
            Animal temp = frontOfQueue;
            while (temp.next != null && temp.next.type != type){
                temp = temp.next;}
            if (temp.next == null) {
                System.out.println("The shelter is not currently adopting animals");
                return null;
            }
            Animal result = temp.next;
            temp.next = result.next;
            if (temp.next == null){
                backOfQueue = temp;}
            nItems--;
            return result;
        }
    }

}
