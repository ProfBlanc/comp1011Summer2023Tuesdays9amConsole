package wk3;

public class Lion extends Cat{

    double scariness;

    public Lion(String name, int paws, double scariness) {
        super(name, paws);
        this.setPaws(123);

        int a = 123;

        this.scariness = scariness;

    }
    public void setPaws(int paws){
        super.setPaws( paws * 2);
    }
    public void testMethod(){
        System.out.println("Hello");
    }
    @Override
    public String toString(){

        return "Lion" + super.toString().substring(3, super.toString().length() -1 ) + ", Scariness = " + scariness + "}";
    }

}
