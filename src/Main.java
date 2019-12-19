import java.util.Arrays;
import java.util.Comparator;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        Food[] breakfast = new Food[20];
        int i = 0;
        boolean calories = false, sort = false;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Tea")) {
                breakfast[i] = new Tea(parts[1]);
            } else if (parts[0].equals("Apple")) {
                breakfast[i] = new Apple(parts[1]);
            } else if (parts[0].equals("Cheese")) {
                breakfast[i] = new Cheese();
            } else if (parts[0].equals("Sliva")) {
                breakfast[i] = new Sliva();
            }

            i++;

            switch (parts[0]){
                case ("-calories"):
                    calories = true;
                    break;
                case ("-sort"):
                    sort = true;
                    break;
            }

        }
        for (Food item: breakfast)
            if (item!=null)
                item.consume();
            else
                break;

        if(calories){
            int sum = 0;
            for (Food item: breakfast)
                if (item!=null)
                    sum += item.calculateCalories();
                else
                    break;
                System.out.println("Калорийность завтрака: " + sum);
        }

        if (sort){
            System.out.println("");
            System.out.println("Отсортированый завтрак: ");
            Arrays.sort(breakfast, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1 instanceof Tea && o2 instanceof Tea) {
                        return -(((Tea) o1).getName().compareTo(((Tea) o2).getName()));
                    }
                    else if (o1 instanceof Tea && o2 instanceof Apple) {
                        return -(((Tea) o1).getName().compareTo(((Apple) o2).getName()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Tea) {
                        return -(((Apple) o1).getName().compareTo(((Tea) o2).getName()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Apple) {
                        return -(((Apple) o1).getName().compareTo(((Apple) o2).getName()));
                    }
                    else if (o1 instanceof Cheese && (o2 instanceof Apple || o2 instanceof Tea)) {
                        return -1;
                    }
                    else if ((o1 instanceof Apple || o1 instanceof Tea) && o2 instanceof Cheese) {
                        return 1;
                    }
                    else if (o1 == null) {
                        return 1;
                    }
                    else if (o2 == null) {
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });
            for (Food item : breakfast) {
                if (item != null) {
                    item.consume();
                } else break;
            }
        }

        System.out.println("");
        int amount = 0;
        Tea check = new Tea("зелёный");
        for (Food item: breakfast){
            if (item != null){
                if (item.equals(check)){
                    amount++;
                }
            }
        }
        System.out.println("Количество " + "'" + check + "'" + ": " + amount);
        amount = 0;
        for (Food item: breakfast){
            if (item != null){
                if (item.equals_type(check)){
                    amount++;
                }
            }
        }
        System.out.println("Количество " + "'" + check.getName() + "'" + ": " + amount);


        System.out.println("");
        System.out.println("всё");

    }
}
