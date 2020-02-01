package software;

import software.daos.Jdbc;
import software.dtos.News;
import software.dtos.Student;
import software.dtos.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Swing {

    public static void main(String[] args) {
        JMenuBar menubar1=new JMenuBar();

        JFrame firstframe=new JFrame("Uneversity page");
        firstframe.setBounds(200 , 100, 400 , 400);
        JPanel firstpanel=new JPanel();

        JFrame stregisterframe=new JFrame("Student Registration");
        stregisterframe.setBounds(500 , 100, 900,900);
        JPanel stregisterpanel=new JPanel();

        JFrame usregisterframe=new JFrame("User Registration");
        usregisterframe.setBounds(500 , 100, 900,900);
        JPanel usregisterpanel=new JPanel();

        JFrame stloginframe=new JFrame("Student Login");
        stloginframe.setBounds(500,100,900,900);
        JPanel stloginpanel=new JPanel();

        JFrame usloginframe=new JFrame("User Login");
        usloginframe.setBounds(500,100,900,900);
        JPanel usloginpanel=new JPanel();

        JFrame mgloginframe=new JFrame("ManagerGroup Login");
        mgloginframe.setBounds(500 , 100, 900,900);
        JPanel mgloginpanel=new JPanel();

        JFrame adloginframe=new JFrame("Admin Login");
        adloginframe.setBounds(500 , 100, 900,900);
        JPanel adloginpanel=new JPanel();

        JFrame subnewsframe=new JFrame("submit news");
        subnewsframe.setBounds(500 , 100, 900,900);
        JPanel subnewspanel=new JPanel();

        JFrame fanniframe=new JFrame("user(fanni) page");
        fanniframe.setBounds(500 , 100, 900,900);
        JPanel fannipanel=new JPanel();

        JFrame ensaniframe=new JFrame("user(ensani) page");
        ensaniframe.setBounds(500 , 100, 900,900);
        JPanel ensanipanel=new JPanel();

        JFrame userframe=new JFrame("user page");
        userframe.setBounds(500 , 100, 900,900);
        JPanel userpanel=new JPanel();



        //////////////////manager login ///////////////////////

        JLabel namemanagerlablelogin=new JLabel("first name:");
        JTextField namemanagerlogin=new JTextField(15);
        JLabel familymanagerlablelogin=new JLabel("last name:");
        JTextField familymanagerlogin=new JTextField(15);
        JLabel idmanagerlablelogin=new JLabel("id:");
        JTextField idmanagerlogin=new JTextField(15);
        JButton managerloginbutton=new JButton("login");
        managerloginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (namemanagerlogin.getText().equals("azade") && familymanagerlogin.getText().equals("zamanifar") && idmanagerlogin.getText().equals("myjava123")) {
                     subnewsframe.setVisible(true);
                    mgloginframe.setVisible(false);
                } else if (namemanagerlogin.getText().equals("ali") && familymanagerlogin.getText().equals("asadi") && idmanagerlogin.getText().equals("myjava123")) {
                     subnewsframe.setVisible(true);
                    mgloginframe.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect login or password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
        JButton back5=new JButton("back");
        back5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                mgloginframe.dispose();
            }
        });
        mgloginpanel.add(namemanagerlablelogin);
        mgloginpanel.add(namemanagerlogin);
        mgloginpanel.add(familymanagerlablelogin);
        mgloginpanel.add(familymanagerlogin);
        mgloginpanel.add(idmanagerlablelogin);
        mgloginpanel.add(idmanagerlogin);
        mgloginpanel.add(managerloginbutton);
        mgloginpanel.add(back5);
        mgloginframe.add(mgloginpanel);

        ///////////////////////login admin////////////////////////////
        JLabel nameadminlablelogin=new JLabel("first name:");
        JTextField nameadminlogin=new JTextField(15);
        JLabel familyadminlablelogin=new JLabel("last name:");
        JTextField familyadminlogin=new JTextField(15);
        JLabel idadminlablelogin=new JLabel("id:");
        JTextField idadminlogin=new JTextField(15);
        JButton adminloginbutton=new JButton("login");
        adminloginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (nameadminlogin.getText().equals("narges") && familyadminlogin.getText().equals("layeghi") && idadminlogin.getText().equals("myjava123")) {
                    subnewsframe.setVisible(true);
                    adloginframe.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect login or password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
        JButton back6=new JButton("back");
        back6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                adloginframe.dispose();
            }
        });
        adloginpanel.add(nameadminlablelogin);
        adloginpanel.add(nameadminlogin);
        adloginpanel.add(familyadminlablelogin);
        adloginpanel.add(familyadminlogin);
        adloginpanel.add(idadminlablelogin);
        adloginpanel.add(idadminlogin);
        adloginpanel.add(adminloginbutton);
        adloginpanel.add(back6);
        adloginframe.add(adloginpanel);
/////////////////////////submit news///////////////////////////
        JLabel idnewslable=new JLabel("degree:");
        JTextField idnews= new JTextField(1);
        JLabel titlelable=new JLabel(" title:");
        JTextField titlenews=new JTextField(25);
        JLabel bodylable=new JLabel("body:");
        JTextField bodynews=new JTextField(50);
        JLabel departmanlable=new JLabel("departman:");
        JComboBox departmannews=new JComboBox();
        departmannews.addItem("fanni");
        departmannews.addItem("ensani");
        departmannews.addItem("total");

        JButton submitbutton=new JButton("submit");
        submitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jdbc jdbc = new Jdbc();
                News news=new News();
                news.setNewsId(Long.parseLong(idnews.getText()));
                news.setTitle(titlenews.getText());
                news.setBody(bodynews.getText());
                news.setDepartman((String)departmannews.getSelectedItem());





                if(idnews!=null && titlenews!=null && bodynews!=null && departmannews!=null ) {

                    jdbc.insertnews(news);
                    JOptionPane.showMessageDialog(null, "submit news successfully!");

                }else {
                    JOptionPane.showMessageDialog(null, "please fill in the blank!");

                }


            }
        });

        JButton backnews=new JButton("back");
        backnews.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                subnewsframe.dispose();
            }
        });


        subnewspanel.add(idnewslable);
        subnewspanel.add(idnews);
        subnewspanel.add(titlelable);
        subnewspanel.add(titlenews);
        subnewspanel.add(bodylable);
        subnewspanel.add(bodynews);
        subnewspanel.add(departmannews);
        subnewspanel.add(submitbutton);
        subnewspanel.add(backnews);
        subnewsframe.add(subnewspanel);

        /////////////////////login student//////////////////////

        JLabel idloginlable=new JLabel("Id");
        JTextField idlogin=new JTextField(10);


        JButton stdlogin=new JButton("login");
        stdlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Student st=new Student();
                Jdbc jdbc=new Jdbc();
                ArrayList<Student>stlist=jdbc.getAllStudents();

                st.setId(Long.parseLong(idlogin.getText()));


                boolean j=false;

                for(int i=0 ; i<stlist.size();i++) {

                    if ((st.getId() == stlist.get(i).getId())) {
                        j = true;
                        stloginframe.setVisible(false);


                        if (st.getId() >= 3060) {
                            ensaniframe.setVisible(true);
                            break;
                        }
                        if (st.getId() < 3060) {
                            fanniframe.setVisible(true);
                            break;
                        }


                        break;

                    }
                }

                if(j!=true){

                    JOptionPane.showMessageDialog(null, "incorrect Id !");

                }

            }

        });

        JButton back3=new JButton("back");
        back3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                stloginframe.dispose();
            }
        });

        stloginpanel.add(idloginlable);
        stloginpanel.add(idlogin);
        stloginpanel.add(stdlogin);
        stloginpanel.add(back3);
        stloginframe.add(stloginpanel);

/////////////////////user login////////////////////////

        JLabel passloginlable=new JLabel("Password");
        JTextField passlogin=new JTextField(10);

        JButton userlogin=new JButton("login");
        userlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User user=new User();
                Jdbc jdbc=new Jdbc();
                ArrayList<User>uslist=jdbc.getAllUsers();

                user.setPassword(Long.parseLong(passlogin.getText()));
                boolean b=false;
                for(int i=0 ; i<uslist.size();i++){

                    if((user.getPassword()==uslist.get(i).getPassword())){
                        b=true;
                        usloginframe.setVisible(false);
                        userframe.setVisible(true);

                        break;
                    }

                }

                if(b!=true){

                    JOptionPane.showMessageDialog(null, "incorrect password !");

                }

            }
        });

        JButton back4=new JButton("back");
        back4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                usloginframe.dispose();
            }
        });

        usloginpanel.add(passloginlable);
        usloginpanel.add(passlogin);
        usloginpanel.add(userlogin);
        usloginpanel.add(back4);
        usloginframe.add(usloginpanel);

        ////////////////////user( fanni student) page//////////////
        Jdbc jdbc = new Jdbc();

        String[] columns= new String[]
                {
                        "title","body","id","departman"

                };
        ArrayList<News> showlist=jdbc.getFanniNews();
        Object[][] data=new Object[showlist.size()][4];

        for( int i=0  ; i<showlist.size() ;i++)
        {


            data[i][0]=showlist.get(i).getTitle();
            data[i][1]=showlist.get(i).getBody();
            data[i][2]=showlist.get(i).getNewsId();
            data[i][3]=showlist.get(i).getDepartman();



        }

        JTable showtable=new JTable(data ,columns);

        JButton back9= new JButton("back");
        back9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stloginframe.setVisible(true);
                fanniframe.setVisible(false);
            }
        });



        fannipanel.add(new JScrollPane(showtable));
        fannipanel.add(back9);
        fanniframe.add(fannipanel);

////////////////////user (ensani student) page///////////////
        Jdbc jdbc1 = new Jdbc();

        String[] columns1= new String[]
                {
                        "title","body","id","departman"

                };
        ArrayList<News> showlist1=jdbc1.getensaniNews();
        Object[][] data1=new Object[showlist1.size()][4];

        for( int i=0 ; i<showlist1.size() ;i++)
        {


            data1[i][0]=showlist1.get(i).getTitle();
            data1[i][1]=showlist1.get(i).getBody();
            data1[i][2]=showlist1.get(i).getNewsId();
            data1[i][3]=showlist1.get(i).getDepartman();



        }

        JTable showtable1=new JTable(data1 ,columns1);

        JButton back10= new JButton("back");
        back10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stloginframe.setVisible(true);
                ensaniframe.setVisible(false);
            }
        });



        ensanipanel.add(new JScrollPane(showtable1));
        ensanipanel.add(back10);
        ensaniframe.add(ensanipanel);
///////////////////////USER PAGE///////////////////
        Jdbc jdbc2 = new Jdbc();

        String[] columns2= new String[]
                {
                        "title","body","newsId","departman"

                };
        ArrayList<News> showlist2=jdbc2.getTotalNews();
        Object[][] data2=new Object[showlist2.size()][4];

        for( int i=0 ; i<showlist2.size() ;i++)
        {


            data2[i][0]=showlist2.get(i).getTitle();
            data2[i][1]=showlist2.get(i).getBody();
            data2[i][2]=showlist2.get(i).getNewsId();
            data2[i][3]=showlist2.get(i).getDepartman();



        }

        JTable showtable2=new JTable(data2 ,columns2);

        JButton back11= new JButton("back");
        back11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stloginframe.setVisible(true);
                userframe.setVisible(false);
            }
        });



        userpanel.add(new JScrollPane(showtable2));
        userpanel.add(back11);
        userframe.add(userpanel);


////////////login menu/////////////////////////////////////////
        JMenuBar menuBarlogin=new JMenuBar();
        JMenu login=new JMenu("Login");
        JMenuItem studentlogin=new JMenuItem("Student");
        studentlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stloginframe.setVisible(true);
                firstframe.setVisible(false);
            }
        });
        JMenuItem userslogin=new JMenuItem("User");
        userslogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usloginframe.setVisible(true);
                firstframe.setVisible(false);
            }
        });
        JMenuItem managerlogin=new JMenuItem("managergroup");
        managerlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mgloginframe.setVisible(true);
                firstframe.setVisible(false);
            }
        });
        JMenuItem adminlogin=new JMenuItem("admin");
        adminlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adloginframe.setVisible(true);
                firstframe.setVisible(false);
            }
        });
        login.add(studentlogin);
        login.add(userslogin);
        login.add(managerlogin);
        login.add(adminlogin);
        menuBarlogin.add(login);
///////////////register menu////////////////
        JMenuBar menuBarregister=new JMenuBar();
        JMenu register= new JMenu("Register");
        JMenuItem registerstudent=new JMenuItem("Student Registration");
        registerstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 stregisterframe.setVisible(true);

                firstframe.setVisible(false);
            }
        });
        JMenuItem registeruser=new JMenuItem("User Registration");
        registeruser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                usregisterframe.setVisible(true);

                firstframe.setVisible(false);
            }
        });

        register.add(registerstudent);
        register.add(registeruser);
        menuBarregister.add(register);

        ///////////////////register student frame//////////////////


        JLabel firstnamelable=new JLabel("first name:");
        JTextField firstname=new JTextField(10);
        JLabel lastnamelable=new JLabel("last name:");
        JTextField lastname=new JTextField(10);
        JLabel idlable=new JLabel("id:");
        JTextField id=new JTextField(10);

        ButtonGroup major=new ButtonGroup();
        JRadioButton fanni=new JRadioButton("fanni");
        JRadioButton ensani=new JRadioButton("ensani");
        major.add(fanni);
        major.add(ensani);
        JButton registerbutton=new JButton("Register");
        registerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jdbc jdbc = new Jdbc();
                Student st = new Student();
                st.setFirstname(firstname.getText());
                st.setLastname(lastname.getText());
                st.setId(Long.parseLong(id.getText()));


                if (fanni.isSelected())
                    st.setMajor(fanni.getText());
                if (ensani.isSelected())
                    st.setMajor(ensani.getText());





                ArrayList<Student>checklist=jdbc.getAllStudents();
                int i;
                boolean f=true;


                for( i=0;i < checklist.size();i++) {

                    if ((st.getId() == checklist.get(i).getId())) {

                        JOptionPane.showMessageDialog(null, "incorrect id");
                        jdbc.delete(st);
                        f=false;
                        break;

                    }


                }
                if(f!=false ) {

                    jdbc.insertstudent(st);
                    JOptionPane.showMessageDialog(null, "Registered successfully!");

                }


            }
        });

        JButton backregister=new JButton("back");
        backregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                stregisterframe.dispose();
            }
        });


        stregisterpanel.add(firstnamelable);
        stregisterpanel.add(firstname);
        stregisterpanel.add(lastnamelable);
        stregisterpanel.add(lastname);
        stregisterpanel.add(idlable);
        stregisterpanel.add(id);
        stregisterpanel.add(fanni);
        stregisterpanel.add(ensani);
        stregisterpanel.add(registerbutton);
        stregisterpanel.add(backregister);
        stregisterframe.add(stregisterpanel);


        ///////////////////register user frame//////////////////


        JLabel usernamelable=new JLabel("username:");
        JTextField username=new JTextField(10);
        JLabel passlable=new JLabel("password:");
        JTextField password=new JTextField(10);

        JButton registerbutton2=new JButton("Register");
        registerbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jdbc jdbc = new Jdbc();
                User user=new User();
                user.setUsername(username.getText());
                user.setPassword(Long.parseLong(password.getText()));


                ArrayList<User>checklist=jdbc.getAllUsers();
                int i;
                boolean f=true;


                for( i=0;i < checklist.size();i++) {

                    if ((user.getPassword() == checklist.get(i).getPassword())) {

                        JOptionPane.showMessageDialog(null, "incorrect id");
                        jdbc.deleteuser(user);
                        f=false;
                        break;

                    }


                }
                if(f!=false ) {

                    jdbc.insertuser(user);
                    JOptionPane.showMessageDialog(null, "Registered successfully!");

                }
            }
        });

        JButton backregister2=new JButton("back");
        backregister2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstframe.setVisible(true);
                usregisterframe.dispose();
            }
        });


        usregisterpanel.add(usernamelable);
        usregisterpanel.add(username);
        usregisterpanel.add(passlable);
        usregisterpanel.add(password);
        usregisterpanel.add(registerbutton2);
        usregisterpanel.add(backregister2);

        usregisterframe.add(usregisterpanel);



        ///////////////////////close first page////////////
        JMenuItem close=new JMenuItem("close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                firstframe.dispose();
            }
        });



        menubar1.add(register);
        menubar1.add(login);
        menubar1.add(close);

        firstframe.setJMenuBar(menubar1);
        firstframe.setVisible(true);
        firstframe.add(firstpanel);
    }
}
