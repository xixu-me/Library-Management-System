package me.xixu.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import me.xixu.Book;
import me.xixu.Static.Information;

public class TableOperate {

    // ���ݿ��ѯ����ģ��
    public TableOperate() {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ⣡");

            String sql = "select * from temp"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            System.out.println("���" + "\t" + "����" + "\t" + "����");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �Ƿ���ڸ��û�
    public static boolean isExist_Customer(String user, String password) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from Customer"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            System.out.println("�û���" + "\t" + "\t" + "\t" + "����");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // �Ƿ���ڸù���Ա
    public static boolean isExist_Manager(String user, String password) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Manager");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Manager");

            String sql = "select * from Manager"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            System.out.println("�û���" + "\t" + "\t" + "\t" + "����");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ע�����û�
    public static void regist_Customer(String user, String password) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");

            String sql = "insert into Customer values('" + user + "','" + password + "');"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ע���¹���Ա
    public static void regist_Manager(String user, String password) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Manager");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Manager");

            String sql = "insert into Manager values('" + user + "','" + password + "');"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �ı��û�������
    public static void changePassword_Customer(String user, String password, String newPassword) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "update Customer set customer_password = '" + newPassword + "' where customer_user = '" + user
                    + "';"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �ı����Ա������
    public static void changePassword_Manager(String user, String password, String newPassword) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "update Manager set manager_password = '" + newPassword + "' where manager_user = '" + user
                    + "';"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �Ƿ���ڸ��û���
    public static boolean isExist_Customer_user(String user, String password) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from Customer"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            System.out.println("�û���" + "\t" + "\t" + "\t" + "����");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // �Ƿ���ڸù���Ա����
    public static boolean isExist_Manager_user(String user, String password) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Manager");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Manager");

            String sql = "select * from Manager"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            System.out.println("�û���" + "\t" + "\t" + "\t" + "����");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if (rs.getString(1).equals(user)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ��������
    public static void insertBook(String number, String classnumber, String name, String classname, String price,
            String state, String total) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-insertBook");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-insertBook");

            String sql = "insert into " + classname + "Book" + " values('" + number + "','" + classnumber + "','" + name
                    + "','" + classname + "','" + price + "','" + state + "','" + total + "','null','null','null');"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �½����
    public static void newClass(String classnumber, String classname) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-newClass");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-newClass");

            String sql = "CREATE TABLE " + classname
                    + "Book(number VARCHAR(255) primary key,classnumber VARCHAR(255),name VARCHAR(255),classname VARCHAR(255),price VARCHAR(255),state VARCHAR(255),total VARCHAR(255),current VARCHAR(255),dateon VARCHAR(255),dateoff VARCHAR(255));"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ɾ���鼮��Ϣ
    public static void deleteBook(String number, String classname) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-deleteBook");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-deleteBook");

            String sql = "delete from " + classname + "Book where number = '" + number + "';"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ��ѯĳ��ͼ����Ϣ
    public static void search_classname(String classname) {
        Information.bookarray.clear();
        try {

            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-search_classname");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-search_classname");

            String sql = "select * from " + classname + "Book;"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            while (rs.next()) {
                Book book = new Book();
                book.number = rs.getString(1);
                book.classnumber = rs.getString(2);
                book.name = rs.getString(3);
                book.classname = rs.getString(4);
                book.price = rs.getString(5);
                book.state = rs.getString(6);
                book.total = rs.getString(7);
                book.current = rs.getString(8);
                book.dateon = rs.getString(9);
                book.dateoff = rs.getString(10);
                Information.bookarray.add(book);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ���������Ϣ
    public static void borrowBook_Update(String classname, String number, String user, String dateoff) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-borrowBook_Customer");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-borrowBook_Customer");

            String sql = "update " + classname + "Book set state = 'out' where number = '" + number + "';\n"; // Ҫִ�е�SQL
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();
            stmts_state.close();

            sql = "update " + classname + "Book set current = '" + user + "' where number = '" + number + "';\n";
            PreparedStatement stmts_current = conn.prepareStatement(sql);
            stmts_current.executeUpdate();
            stmts_current.close();

            sql = "update " + classname + "Book set dateoff = '" + dateoff + "' where number = '" + number + "';\n";
            PreparedStatement stmts_dateoff = conn.prepareStatement(sql);
            stmts_dateoff.executeUpdate();
            stmts_dateoff.close();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �����û����ݿ�
    public static void newCustomer(String user) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-newCustomer");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-newCustomer");

            String sql = "CREATE TABLE " + user
                    + "Customer (number VARCHAR(255) primary key,classname VARCHAR(255),name VARCHAR(255),dateoff VARCHAR(255));"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ����ע�䵽�û���Ϣ
    public static void borrowBook_Insert(String classname, String number, String user, String dateoff) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-borrowBook_Insert");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-borrowBook_Insert");

            String sql = "insert into " + user + "Customer values('" + number + "','" + classname + "','"
                    + search_bookname(classname, number) + "','" + dateoff + "');"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ��������鼮���ݿ���Ϣ
    public static void returnBook_Update(String classname, String number, String user, String dateoff) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-returnBook_Update");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-returnBook_Update");

            String sql = "update " + classname + "Book set state = 'in' where number = '" + number + "';\n"; // Ҫִ�е�SQL
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();
            stmts_state.close();

            sql = "update " + classname + "Book set current = 'null' where number = '" + number + "';\n";
            PreparedStatement stmts_current = conn.prepareStatement(sql);
            stmts_current.executeUpdate();
            stmts_current.close();

            sql = "update " + classname + "Book set dateoff = 'null' where number = '" + number + "';\n";
            PreparedStatement stmts_dateoff = conn.prepareStatement(sql);
            stmts_dateoff.executeUpdate();
            stmts_dateoff.close();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ��������û������ݿ���Ϣ
    public static void returnBook_Delete(String number, String user) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-returnBook_Delete");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-returnBook_Delete");

            String sql = "delete from " + user + "Customer where number = '" + number + "';"; // Ҫִ�е�SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ��������������ݿ���Ϣ
    public static void prolongBook_Update(String classname, String number, String dateoff, String user) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-prolongBook_Update");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-prolongBook_Update");

            String sql = "update " + classname + "Book set dateoff = '" + dateoff + "' where number = '" + number
                    + "';\n"; // Ҫִ�е�SQL
            PreparedStatement stmts_state = conn.prepareStatement(sql);
            stmts_state.executeUpdate();
            stmts_state.close();

            sql = "update " + user + "Customer set dateoff = '" + dateoff + "' where number = '" + number + "';\n";
            PreparedStatement stmts_current = conn.prepareStatement(sql);
            stmts_current.executeUpdate();
            stmts_current.close();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ��ѯ����ͼ����Ϣ
    public static void search_personal(String user) {
        Information.bookarray.clear();
        try {

            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-search_personal");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-search_personal");

            String sql = "select * from " + user + "Customer;"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            while (rs.next()) {
                Book book = new Book();
                book.number = rs.getString(1);
                book.classname = rs.getString(2);
                book.name = rs.getString(3);
                book.dateoff = rs.getString(4);
                Information.bookarray.add(book);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // �Ƿ���ڸ�Table��
    public static boolean isExist_Table(String table) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Table");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Table");

            String sql = "show tables"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            while (rs.next()) {
                if (table.equals(rs.getString(1))) {
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ��������
    public static String search_bookname(String classname, String number) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-search_bookname");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-search_bookname");

            String sql = "select * from " + classname + "book where number='" + number + "';"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            while (rs.next()) {
                return rs.getString(3);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    // �����鼮״̬
    public static String search_bookstate(String classname, String number) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-search_bookstate");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-search_bookstate");

            String sql = "select * from " + classname + "book where number='" + number + "';"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            while (rs.next()) {
                return rs.getString(6);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    // �����鼮��������
    public static int search_bookdateoff(String classname, String number) {
        try {
            // ����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-search_bookdateoff");

            String url = Information.JDBC_URL; // JDBC��URL
            Connection conn;

            conn = DriverManager.getConnection(url, Information.username, Information.password);
            Statement stmt = conn.createStatement(); // ����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-search_bookdateoff");

            String sql = "select * from " + classname + "book where number='" + number + "';"; // Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);// �������ݶ���
            while (rs.next()) {
                return Integer.parseInt(rs.getString(10));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
