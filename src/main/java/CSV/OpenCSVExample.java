package CSV;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class OpenCSVExample {
    public static void main(String[] args) {
        CSVReader csvReader = null;
        try{
            csvReader = new CSVReader(new FileReader("plants.csv"));
            String [] nextLine;
            while ((nextLine = csvReader.readNext()) != null){
                for(String token : nextLine){
                    System.out.println(token);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                assert csvReader != null;
                csvReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
