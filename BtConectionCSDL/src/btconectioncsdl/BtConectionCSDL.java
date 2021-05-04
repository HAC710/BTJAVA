
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BtConectionCSDL{
    JTable jTable;
    public static void main(String[] args) {
       BtConectionCSDL bt = new BtConectionCSDL();
       bt.go();
    }
    public void go(){
        JFrame jFrame = new JFrame();
        
        JPanel jPanel = new JPanel(new FlowLayout());
        String[] col = {"ID" ,"Name", "Address", "Total"};
        Vector vctHeader = new Vector();
        Vector vctData = new Vector();
        
        
        vctHeader.add("ID");
        vctHeader.add("Name");
        vctHeader.add("Address");
        vctHeader.add("Total");
        
//        DefaultTableModel tableModel1 = new DefaultTableModel(col, 0);
//        
//        jTable = new JTable(tableModel1);
        
        try {
            ResultSet rs = excute("select * from Table1");
            while(rs.next()){
//                Object[] objs = {Integer.parseInt(rs.getString("ID")),rs.getString("Name"),
//                rs.getString("Address"), Integer.parseInt(rs.getString("Total"))};
//                tableModel1.addRow(objs);
            Vector vectorRow = new Vector();
            vectorRow.add(Integer.parseInt(rs.getString("ID")));
            vectorRow.add(rs.getString("Name"));
            vectorRow.add(rs.getString("Address"));
            vectorRow.add(Integer.parseInt(rs.getString("Total")));
            vctData.add(vectorRow);
            }
        } catch (Exception e) {
        }
        jTable = new JTable(new DefaultTableModel(vctData, vctHeader));
        JScrollPane scrollPane = new JScrollPane(jTable);
       
        
        jTable.setFillsViewportHeight(true);
        JButton jButtonShow = new JButton("Show");
        
        JButton jButtonExit = new JButton("Exit");
        
        JButton jButtonReset = new JButton("Reset");
        
        
        
        jPanel.add(scrollPane);
        jPanel.add(jButtonShow);
        jPanel.add(jButtonReset);
        jPanel.add(jButtonExit);
        jFrame.add(jPanel);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
    }
    public ResultSet excute(String query){
        try {
            String connectionURL = "jdbc:ucanaccess://Database3.accdb";
            Connection connection = DriverManager.getConnection(connectionURL);
            Statement st = connection.createStatement();
            
            return st.executeQuery(query);
            
        } catch (Exception e) {
            return  null;
        }
    }
    
    class ListenerShow implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
}
