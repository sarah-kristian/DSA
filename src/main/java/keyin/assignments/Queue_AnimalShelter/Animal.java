package keyin.assignments.Queue_AnimalShelter;


public class Animal {
    public String name;
    public Type type;
    public Animal next;


    public Animal() {}

    public Animal(Type type) {
        this.type = type;
    }

    public Animal(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Animal getNext() {
        return next;
    }
    public void setNext(Animal next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "value=" + name +
                ", type=" + type +
                '}';
    }
}
