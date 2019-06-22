package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //System.out.println(User.Country.valueOf("RUSSIA"));
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Evgeniy");
            Date date = new Date(1983-1900,2,19);
            user.setBirthDate(date);
            user.setLastName("Bezdomnikov");
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush)?"Yes":"No");
            System.out.println(loadedObject.users.get(0).isMale()?"Yes":"No");
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isHaveUsers = users.size() == 0 ? "no" : "yes";
            printWriter.println(isHaveUsers);
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);

                String isHaveBirthDate = user.getBirthDate() == null?"No":"Yes";
                printWriter.println(isHaveBirthDate);
                if (isHaveBirthDate.equals("Yes")) {
                    printWriter.println(users.get(i).getBirthDate().getTime());
                }

                String isHaveCountry = user.getCountry() == null?"No":"Yes";
                printWriter.println(isHaveCountry);
                if (isHaveCountry.equals("Yes")) {
                    printWriter.println(users.get(i).getCountry().name());
                }

                String isHaveFirstName = user.getFirstName() == null?"No":"Yes";
                printWriter.println(isHaveFirstName);
                if (isHaveFirstName.equals("Yes")) {
                    printWriter.println(users.get(i).getFirstName());
                }

                String isHaveLastName = user.getLastName() == null?"No":"Yes";
                printWriter.println(isHaveLastName);
                if (isHaveLastName.equals("Yes")) {
                    printWriter.println(users.get(i).getLastName());
                }

                printWriter.println(users.get(i).isMale()?"Yes":"No");
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()) {
                String isHaveUsers = reader.readLine();
                if (isHaveUsers.equals("yes")) {
                    users.clear();
                    while (reader.ready()) {
                        User user = new User();

                        String isHaveBirthDate = reader.readLine();
                        if (isHaveBirthDate.equals("Yes")) {
                            Date birthDate = (new Date());
                            birthDate.setTime(Long.parseLong(reader.readLine()));
                            user.setBirthDate(birthDate);
                        }
                        String isHaveCountry = reader.readLine();
                        if (isHaveCountry.equals("Yes")) {
                            user.setCountry(User.Country.valueOf(reader.readLine()));
                        }
                        String isHaveFirstName = reader.readLine();
                        if (isHaveFirstName.equals("Yes")) {
                            user.setFirstName(reader.readLine());
                        }

                        String isHaveLastName = reader.readLine();
                        if (isHaveLastName.equals("Yes")) {
                            user.setLastName(reader.readLine());
                        }

                        user.setMale(reader.readLine().equals("Yes"));

                        users.add(user);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
