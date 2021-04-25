package com.javaHE.base;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javaHE.function.Bean;
import com.javaHE.function.DbAction;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;

public class Oneday_test {

	private JFrame frame;
	private JTable Inner_Table;
	
	private JComboBox cbSelection;

	
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); //**********

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oneday_test window = new Oneday_test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Oneday_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
			}
		});
		frame.setBounds(100, 100, 450, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 45, 399, 282);
		frame.getContentPane().add(scrollPane);
		
		Inner_Table = new JTable();
		Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Inner_Table.setModel(Outer_Table);// ******** 설정 꼭 해주기!
		scrollPane.setViewportView(Inner_Table);
		
		JComboBox cbSelection = new JComboBox();
		cbSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComboxClick();
			}
		});
		cbSelection.setEditable(true);
		cbSelection.setModel(new DefaultComboBoxModel(new String[] {"요리", "베이킹", "수공예", "미술"}));
		cbSelection.setBounds(19, 6, 99, 27);
		frame.getContentPane().add(cbSelection);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 444, 397);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	//1. Table Init 설정
	@SuppressWarnings("static-access")    // warning Message 안보이게
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
        //강의명, 강사, 장소, 날짜 이름으로 테이블 열 이름 설정
        Outer_Table.addColumn("강의명");
        Outer_Table.addColumn("강사");
        Outer_Table.addColumn("장소");
        Outer_Table.addColumn("날짜");
        Outer_Table.setColumnCount(4);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }
        //Table 안쪽 Size 바꾸지 못하게 하기
        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 100;
        col.setPreferredWidth(width);
        
        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);
        
        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);
        
        vColIndex = 3;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        
	}//Table Init End

	//조건검색 이
	// ConditionQuery column name
	private void ComboxClick() {
		
		int i = cbSelection.getSelectedIndex();
		
		String ComboxColumn = "";
		switch (i) {
		case 0:
			ComboxColumn = "요리";
			break;
		case 1:
			ComboxColumn = "베이킹";
			break;
		case 2:
			ComboxColumn = "수공예";
			break;
		case 3:
			ComboxColumn = "미술";
			break;
		default:
			break;
		}
		
	TableInit();
	searchAction(ComboxColumn);
	}//comboxClick End

	//SearchAction
	private void searchAction(String ComboxColumn) {
		
		DbAction dbAction = new DbAction(ComboxColumn);  
		ArrayList<Bean>  beanList =  dbAction.selectList();
		
		int listCount = beanList.size();
		
		for(int i=0; i<listCount; i++) {
			
			
			String[] qTxt = { beanList.get(i).getClassName(), beanList.get(i).getTeacherName(), beanList.get(i).getClassLocation(),beanList.get(i).getClassDate()};
			
			Outer_Table.addRow(qTxt);
				
		}
	}//searchAction End
}//end

