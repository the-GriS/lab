public class Tea extends Food {
    private String color;

    public Tea(String color) {
        super("Чай");
        this.color = color;
    }

    public void consume() {
        System.out.println(this + " выпит");
    }

    public int calculateCalories(){
        if(this.color.equals("зелёный")){
            return 1;
        }
        else if(this.color.equals("чёрный")){
            return 2;
        }
        else return 0;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Tea)) return false;
            return color.equals(((Tea)arg0).color);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " цвета '" + color.toUpperCase() + "'";
    }


}
