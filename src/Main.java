import java.util.Scanner;

public class Main {
    public static String before_or_after(String input){
        if (input.equals("before") || input.equals("after")) {
            return input;
        }
        else {
            throw new IllegalArgumentException("Must be before or after.");
        }
    }

        public static Float get_grade(String grade) {
        float gradeprice;
            if (grade.equals("Regular")) {
                return 2.50f;
            }
            if (grade.equals("Mid-grade")) {
                return 3.00f;
            }
            if (grade.equals("Premium")) {
                return 3.50f;
            }
            else {
                throw new IllegalArgumentException("Grade must be Regular, Mid-grade, or Premium");
            }
    }

        public static Float get_gallons(Float price, Float grade) {
        if (price >= 0 && grade >= 0) {
            float p = price/grade;
            return p;
        }
        else {
            throw new IllegalArgumentException("Please provide correct gallon.");
        }
    }



        public static Float calculate_total_cost(Float grade, Float gallons) {
           float calculate = grade * gallons;
           return calculate;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pay before or after?");

        while(true){
            System.out.println("> ");
            String userinput = scanner.nextLine();
            String pay = before_or_after(userinput);

            if (pay.equals("before")) {
                System.out.println("How much are you spending?");
                System.out.println(">");
                userinput = scanner.nextLine();

                Float gasmoney = Float.parseFloat(userinput);

                System.out.println("What grade?");
                System.out.println("- Regular $2.50/gal");
                System.out.println("- Mid-grade $3.00/gal");
                System.out.println("- Premium $3.50/gal");

                System.out.println(">");
                userinput = scanner.nextLine();
                Float gradeprice = get_grade(userinput);
                Float gallons = get_gallons(gasmoney, gradeprice);


                System.out.println("Thank you for your purchase!");
                System.out.println("payment: " + pay);
                System.out.println(String.format("Amount spent: $%.2f", gasmoney));
                System.out.println(String.format("Gallons purchased: %.1f", gallons));
                break;
            }

            else if (pay.equals("after")) {
                System.out.println("What grade?");
                System.out.println("- Regular $2.50/gal");
                System.out.println("- Mid-grade $3.00/gal");
                System.out.println("- Premium $3.50/gal");
                System.out.println(">");

                userinput = scanner.nextLine();
                Float gradeprice = get_grade(userinput);

                System.out.println("How many gallons of gas did you pump?");
                System.out.println(">");

                userinput = scanner.nextLine();
                Float gallons = Float.parseFloat(userinput);
                Float gasmoney = calculate_total_cost(gradeprice, gallons);

                System.out.println("Thank you for your purchase!");
                System.out.println("payment: " + pay);
                System.out.println(String.format("Amount spent: $%.2f", gasmoney));
                System.out.println(String.format("Gallons purchased: %.1f", gallons));
                break;
            }
            
        }

    }
}