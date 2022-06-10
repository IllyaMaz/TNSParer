import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import Object.Adress;

public class main {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Новая папка\\TNSParse\\TNSNAMES.ORA");
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        Pattern pattern = Pattern.compile("\\(+ADDRESS\\s.+");
        Pattern pattern1 = Pattern.compile("\\(SERVICE_NAME.+");
        Adress adress = new Adress();
        while (line!=null){
            String st = line.strip();
            if (pattern.matcher(st).find()){
                String[] w = st.replace("(","")
                        .replace(")"," ")
                        .replace("=","")
                        .replace("  "," ")
                        .replace("  "," ")
                        .split(" ");
                adress.setProtocol(w[2]);
                adress.setHost(w[4]);
                adress.setPort(w[6]);
            }
            if (pattern1.matcher(st).find()){
                String[] w = st.replace("(","")
                        .replace(")","")
                        .replace("= ","")
                        .split(" ");
                adress.setServiceName(w[1]);
            }
            line=reader.readLine();
        }

        System.out.println(adress);
    }
}
