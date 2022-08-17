
import java.io.*;
        import java.text.*;
        import java.util.*;
public class StudentList {
    public static void main(String[] args) {
        if( args[0].length() <=1){
            System.out.println(Constant.WrongInput);

        }
        else if (args[0].equals(Constant.ShowAll)) {
            System.out.println(Constant.LoadDataMessage);
            try {
                String[] names = getStrings();
                for (String name : names) {
                    System.out.println(name);
                }
            }
            catch (Exception e) {
                System.out.println(Constant.FailureMessage);
            }
            System.out.println(Constant.DataLoadMessage);
        }
        else if (args[0].equals(Constant.ShowRandom)) {
            System.out.println(Constant.LoadDataMessage);
            try {
                String[] names = getStrings();
                Random random = new Random();
                System.out.println(names[random.nextInt(names.length)]);
            }
            catch (Exception e) {
                System.out.println(Constant.FailureMessage);
            }
            System.out.println(Constant.DataLoadMessage);
        }
        else if (args[0].contains(Constant.AddStudent)) {
            System.out.println(Constant.LoadDataMessage);

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
                System.out.println(Constant.FailureMessage);
            }

            System.out.println(Constant.DataLoadMessage);
        }
        else if (args[0].contains(Constant.FindEntry)) {
            System.out.println(Constant.LoadDataMessage);
            try {
                int index;
                String[] names = getStrings();
                String substring = args[0].substring(1);
                for (index = 0; index < names.length ; index++) {
                    if (names[index].equals(substring)) {
                        System.out.println(Constant.SuccessMessage);
                        break;
                    }
                }
            }
            catch (Exception e) {
                System.out.println(Constant.FailureMessage);
            }
            System.out.println(Constant.DataLoadMessage);
        }
        else if (args[0].contains(Constant.StudentCount)) {
            System.out.println(Constant.LoadDataMessage);
            try {
                String[] names = getStrings();
                int count = 0;
                for (String word : names) {
                    count++;
                }
                System.out.println(count + Constant.CountMessage);
            }
            catch (Exception e) {
                System.out.println(Constant.FailureMessage);
            }
            System.out.println(Constant.DataLoadMessage);
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
