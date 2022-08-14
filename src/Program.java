import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        List<Product> productsList = new ArrayList<>();

        String strPath = "C:\\temp\\products2.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){

            splitCsvAddProduct(br, productsList);

            System.out.println("Most expensive product: " + CalculationService.max(productsList));
            System.out.println("Cheapest product: " + CalculationService.min(productsList));
        }
        catch(IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void splitCsvAddProduct(BufferedReader br, List<Product> list) throws Exception{
        String lineReader = br.readLine();

        while(lineReader != null){
            String[] lines = lineReader.split("\n");

            for (String line : lines) {
                String[] line2 = line.split(",");
                addProduct(line2[0], Double.parseDouble(line2[1]), list);

            }
            lineReader = br.readLine();
        }
    }

    public static void addProduct(String name, Double value, List<Product> list){
        Product prod = new Product(name, value);
        list.add(prod);
    }
}