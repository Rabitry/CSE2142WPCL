
import java.io.*;
        import java.text.*;
        import java.util.*;
public class StudentList {
    public static void main(String[] args) {
        if(args.length==0 || args.length!=1){
            System.out.println(Constant.WrongInput);

        }
        else if (args[0].equals(Constant.ShowAll)) {
            System.out.println(Constant.AddData);
            try {
                String[] names = getStrings();
                for (String name : names) {
                    System.out.println(name);
                }
            }
            catch (Exception e) {
            }
            System.out.println(Constant.LoadData);
        }
        else if (args[0].equals(Constant.ShowRandom)) {
            System.out.println(Constant.AddData);
            try {
                String[] names = getStrings();
                //int length = names.length;
                Random random = new Random();
               // int nextInt = random.nextInt(length);
                System.out.println(names[random.nextInt(names.length)]);
            }
            catch (Exception e) {
            }
            System.out.println(Constant.LoadData);
        }
        else if (args[0].contains(Constant.AddEntry)) {
            System.out.println(Constant.AddData);

            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(Constant.StudentList, true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String DateFormat = Constant.DateFormat;
                DateFormat dateFormat = new SimpleDateFormat(DateFormat);
                writer.write(Constant.AddEntryDelimiter+ substring + Constant.FormatMessage + dateFormat.format(date));
                writer.close();
            }
            catch (Exception e) {
            }

            System.out.println(Constant.LoadData);
        }
        else if (args[0].contains(Constant.FindEntry)) {
            System.out.println(Constant.AddData);
            try {
                String[] names = getStrings();
                String substring = args[0].substring(1);
                for (int idx = 0; idx < names.length ; idx++) {
                    if (names[idx].equals(substring)) {
                        System.out.println(Constant.SuccessMessage);
                        break;
                    }
                }
            }
            catch (Exception e) {
            }
            System.out.println(Constant.LoadData);
        }
        else if (args[0].contains(Constant.ShowCount)) {
            System.out.println(Constant.AddData);
            try {
                String[] names = getStrings();
                int count = 0;
                for (String word : names) {
                    count++;
                }
                System.out.println(count + Constant.CountMessage);
            }
            catch (Exception e) {
            }
            System.out.println(Constant.LoadData);
        }
        else{
            System.out.println(Constant.WrongInput);
        }

    }

    private static String[] getStrings() throws IOException {
        BufferedReader bufferReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constant.StudentList)));
        String StudentName = bufferReader.readLine();
        return StudentName.split(Constant.AddEntryDelimiter);
    }
}
