package software.daos;

import software.dtos.News;
import software.dtos.Student;
import software.dtos.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Jdbc {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public Jdbc() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "nargeslayeghi", "myjava123");
        } catch (Exception ex) {
            System.out.println("Oops" + ex.getMessage());
        }
    }


    public void insertstudent(Student st) {
        try {


            preparedStatement = connection.prepareStatement("insert into stduser(id,firstname,lastname,major) VALUES (?,?,?,?)");
            preparedStatement.setLong(1, st.getId());
            preparedStatement.setString(2, st.getFirstname());
            preparedStatement.setString(3, st.getLastname());
            preparedStatement.setString(4, st.getMajor());

            preparedStatement.executeUpdate();
        }catch(Exception insertex)
        {
            System.out.println("error in insert student!!"+insertex.getMessage());
        }

    }

    public void insertuser(User user) {
        try {


            preparedStatement = connection.prepareStatement("insert into ordinaryuser(username,password) VALUES (?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setLong(2,user.getPassword());

            preparedStatement.executeUpdate();
        }catch(Exception insertex2)
        {
            System.out.println("error in insert user!!"+insertex2.getMessage());
        }

    }

    public void insertnews(News news) {
        try {


            preparedStatement = connection.prepareStatement("insert into news(id,title , body , departman) VALUES (?,?,?,?)");
            preparedStatement.setLong(1, news.getNewsId());
            preparedStatement.setString(2, news.getTitle());
            preparedStatement.setString(3, news.getBody());
            preparedStatement.setString(4, news.getDepartman());

            preparedStatement.executeUpdate();
        }catch(Exception insertex)
        {
            System.out.println("error in insert news!!"+insertex.getMessage());
        }

    }
    public ArrayList<Student> getAllStudents()  {
        ArrayList<Student> stlist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from stduser");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Student st = new Student();
                st.setId(rs.getLong("id"));
                st.setFirstname(rs.getString("firstName"));
                st.setLastname(rs.getString("lastName"));
                st.setMajor(rs.getString("major"));
                stlist.add(st);
            }
        }catch(Exception selectex){

            System.out.println("error in select students!!"+selectex.getMessage());
        }
        return stlist;
    }

    public ArrayList<User> getAllUsers()  {
        ArrayList<User> uslist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from ordinaryuser");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getLong("password"));

                uslist.add(user);
            }
        }catch(Exception selectexuser){

            System.out.println("error in select users!!"+selectexuser.getMessage());
        }
        return uslist;
    }


    public ArrayList<Student> getFanniStudents()  {
        ArrayList<Student> stflist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from stduser where major='fanni'");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Student st = new Student();
                st.setId(rs.getLong("id"));
                st.setFirstname(rs.getString("firstName"));
                st.setLastname(rs.getString("lastName"));
                st.setMajor(rs.getString("major"));
                stflist.add(st);
            }
        }catch(Exception selectex){

            System.out.println("error in select students!!"+selectex.getMessage());
        }
        return stflist;
    }

    public ArrayList<News> getFanniNews()  {
        ArrayList<News> newslist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from news where departman='fanni'or departman='total' order by id");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

               News news=new News();
                news.setNewsId(rs.getLong("id"));
                news.setTitle(rs.getString("title"));
                news.setBody(rs.getString("body"));
                news.setDepartman(rs.getString("departman"));
                newslist.add(news);
            }
        }catch(Exception selectex){

            System.out.println("error in select fanni news!!"+selectex.getMessage());
        }
        return newslist;
    }
    public ArrayList<News> getensaniNews()  {
        ArrayList<News> newslist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from news where departman='ensani' or departman='total' order by id");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                News news=new News();
                news.setNewsId(rs.getLong("id"));
                news.setTitle(rs.getString("title"));
                news.setBody(rs.getString("body"));
                news.setDepartman(rs.getString("departman"));
                newslist.add(news);
            }
        }catch(Exception selectex){

            System.out.println("error in select ensani news!!"+selectex.getMessage());
        }
        return newslist;
    }
    public ArrayList<News> getTotalNews()  {
        ArrayList<News> newslist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from news where departman='total' order by id");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                News news=new News();
                news.setNewsId(rs.getLong("id"));
                news.setTitle(rs.getString("title"));
                news.setBody(rs.getString("body"));
                news.setDepartman(rs.getString("departman"));
                newslist.add(news);
            }
        }catch(Exception selectex){

            System.out.println("error in select total news!!"+selectex.getMessage());
        }
        return newslist;
    }
    public ArrayList<Student> getEnsaniStudents()  {
        ArrayList<Student> stelist = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from stduser where major='ensani'");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Student st = new Student();
                st.setId(rs.getLong("id"));
                st.setFirstname(rs.getString("firstName"));
                st.setLastname(rs.getString("lastName"));
                st.setMajor(rs.getString("major"));
                stelist.add(st);
            }
        }catch(Exception selectex){

            System.out.println("error in select students!!"+selectex.getMessage());
        }
        return stelist;




    }


    public void delete(Student st){

        try {
            preparedStatement = connection.prepareStatement("delete stdluser where id=? , firstname=? , lastname=?");
            preparedStatement.setLong(1,st.getId());
            preparedStatement.setString(2,st.getFirstname());
            preparedStatement.setString(3,st.getLastname());
            preparedStatement.executeUpdate();
        }catch(Exception dl){
            System.out.println("error in delete student"+dl.getMessage());

        }

    }
    public void deleteuser(User user){

        try {
            preparedStatement = connection.prepareStatement("delete ordinaryuser where password=? ");
            preparedStatement.setLong(1,user.getPassword());
            preparedStatement.executeUpdate();
        }catch(Exception dl){
            System.out.println("error in delete user"+dl.getMessage());

        }

    }
}
