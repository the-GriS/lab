//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Sliva extends Food {
    public Sliva() {
        super("Слива");
    }

    public void consume() {
        System.out.println(this + " съедена");
    }

    public int calculateCalories() {
        return 15;
    }
}

