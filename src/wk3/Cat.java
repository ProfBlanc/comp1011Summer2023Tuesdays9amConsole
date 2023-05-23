package wk3;

public class Cat {

    private int paws;
    public String name;

    public Cat(int paws, String name) {
        this.paws = paws;
        this.name = name;
    }

    public Cat(String name, int paws) {
        this(paws, name);
    }

    public int getPaws() {
        return paws;
    }

    public void setPaws(int paws) {
        this.paws = paws;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "paws=" + paws +
                ", name='" + name + '\'' +
                '}';
    }
}