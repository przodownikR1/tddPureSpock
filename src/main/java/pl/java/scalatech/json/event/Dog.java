package pl.java.scalatech.json.event;

class Dog extends Animal {

    public double barkVolume;

    @Override
    public String toString() {
        return "Dog [name=" + name + ", barkVolume=" + barkVolume + "]";
    }
}