public class Apple extends Food {
    private String size;

    public Apple(String size) {

        super("Яблоко");

        this.size = size;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public int calculateCalories(){
        if(this.size.equals("большое")){
            return 50;
        }
        else if(this.size.equals("среднее")){
            return 40;
        }
        else if(this.size.equals("малое")){
            return 30;
        }
        else return 0;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}