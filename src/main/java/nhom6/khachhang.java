package nhom6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class khachhang extends JFrame {
	private Statement stmt;
	private PreparedStatement ps;
	private ConnectionDB conn;

	private static DefaultTableModel dtm;

	JButton btnBACK = new JButton("RETURN");
	JButton btnRE = new JButton("REFRESH");
	JButton btnADD = new JButton("ADD");
	JButton btnSUA = new JButton("EDIT");
	JButton btnDEL = new JButton("DELETE");
	JButton btnFIND = new JButton("FIND");

	JLabel Jlbid = new JLabel("ID KH: ");
	JLabel Jlbht = new JLabel("Tên KH: ");
	JLabel Jlblv = new JLabel("Ngày mua ");
	JLabel Jlbpo = new JLabel("Giới tính ");
	JLabel Jlbsdt = new JLabel("Số tiền ");
	JLabel Jlbpro = new JLabel("SP đã mua ");

	JTextField tfid = new JTextField(30);
	JTextField tfht = new JTextField(30);
	JTextField tflv = new JTextField(30);
	JTextField tfpo = new JTextField(30);
	JTextField tfsdt = new JTextField(30);
	JTextField tfpro = new JTextField(30);

	
	public khachhang() {

		dtm = new DefaultTableModel();
		JTable jtableKQ = new JTable(dtm);
		dtm.addColumn("ID KH");
		dtm.addColumn("Name KH");
		dtm.addColumn("Date");
		dtm.addColumn("Sex");
		dtm.addColumn("money");
		dtm.addColumn("SP pay");
		loadata();
		JScrollPane sc = new JScrollPane(jtableKQ);
		loadata();
		
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder title = BorderFactory.createTitledBorder(border, "CUSTOMER  INFORMATION");
			
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder title1 = BorderFactory.createTitledBorder(border1, "CUSTOMER INSERT");

		Border border2 = BorderFactory.createLineBorder(Color.green);
		TitledBorder title2 = BorderFactory.createTitledBorder(border2, "");

		JFrame JFrKQ = new JFrame();

		JPanel north = new JPanel();
		JPanel n_north = new JPanel();
		JPanel nn_west = new JPanel();
		JPanel south = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();
		JPanel id = new JPanel();
		JPanel ht = new JPanel();
		JPanel lv = new JPanel();
		JPanel po = new JPanel();
		JPanel sdt = new JPanel();
		JPanel pro = new JPanel();

		JFrKQ.getContentPane().setLayout(new BorderLayout());
		center.setLayout(new GridLayout(6, 2));
		east.setLayout(new GridLayout(4, 1));
		north.setLayout(new BorderLayout());
		n_north.setLayout(new BorderLayout());
		nn_west.setLayout(new GridLayout(1, 2));

		JFrKQ.getContentPane().add(north, "North");
		JFrKQ.getContentPane().add(south, "East");
		JFrKQ.getContentPane().add(center, "Center");
		JFrKQ.getContentPane().add(east, "West");
		north.add(n_north, "West");
		n_north.add(nn_west, "West");

		south.add(sc);
		south.setBorder(title);
		center.setBorder(title1);
		east.setBorder(title2);

		id.add(Jlbid);
		ht.add(Jlbht);
		ht.add(tfht);
		lv.add(Jlblv);
		lv.add(tflv);
		po.add(Jlbpo);
		po.add(tfpo);

		sdt.add(Jlbsdt);
		sdt.add(tfsdt);
		pro.add(Jlbpro);
		pro.add(tfpro);
		center.add(id);
		center.add(tfid);
		center.add(ht);
		center.add(lv);
		center.add(po);
		center.add(sdt);
		center.add(pro);
		center.add(btnADD);
		
				btnADD.addActionListener(new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						conn = new ConnectionDB();
						try {
							ps = ConnectionDB.getConn().prepareCall("insert into khachhang values (?, ?, ?, ?, ?, ?)");
							ps.setString(1, tfid.getText());
							ps.setString(2, tfht.getText());
							ps.setString(3, tflv.getText());
							ps.setString(4, tfpo.getText());
							ps.setString(5, tfsdt.getText());
							ps.setString(6, tfpro.getText());
		
							ps.execute();
							dtm.addRow(new String[] { tfid.getText(), tfht.getText(), tflv.getText(), tfpo.getText(),
									tfsdt.getText(), tfpro.getText() });
							dtm.setRowCount(0);
		
							tfid.setText("");
							tfht.setText("");
							tflv.setText("");
							tfpo.setText("");
							tfsdt.setText("");
							tfpro.setText("");
		
							loadata();
		
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				});
		center.add(btnSUA);
		btnSUA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				conn = new ConnectionDB();
				try {
					ps = conn.getConn().prepareStatement(
							"update khachhang set  NameKH = ? , Date = ?, Sex = ?, money = ?, SPpay = ? where IDKH ="
									+ "'" + jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 0) + "'");
					ps.setString(1, tfht.getText());
					ps.setString(2, tflv.getText());
					ps.setString(3, tfpo.getText());
					ps.setString(4, tfsdt.getText());
					ps.setString(5, tfpro.getText());
					ps.executeUpdate();
					dtm.setRowCount(0);

					tfid.setText("");
					tfht.setText("");
					tflv.setText("");
					tfpo.setText("");
					tfsdt.setText("");
					tfpro.setText("");

					loadata();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		center.add(btnDEL);
		center.add(btnFIND);
		center.add(btnRE);

		nn_west.add(btnBACK);
		center.setLayout(new GridLayout(3, 2));
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		center.setBackground(Color.white);
		south.setBackground(Color.white);

//		JFrKQ.pack();
		JFrKQ.setTitle("Quản lí thông tin khách hàng");
		JFrKQ.setSize(900, 500);
		JFrKQ.setLocationRelativeTo(null);
		JFrKQ.setVisible(true);
		btnBACK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrKQ.dispose();
				new create();
			}
		});
		jtableKQ.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				tfid.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 0));
				tfht.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 1));
				tflv.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 2));
				tfpo.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 3));
				tfsdt.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 4));
				tfpro.setText((String) jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 5));

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnRE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfid.setText("");
				tfht.setText("");
				tflv.setText("");
				tfpo.setText("");
				tfsdt.setText("");
				tfpro.setText("");

				loadata();
			}
		});
		
		btnDEL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ps = conn.getConn().prepareStatement("DELETE FROM khachhang WHERE IDKH = ?");
					ps.setString(1, jtableKQ.getValueAt(jtableKQ.getSelectedRow(), 0).toString());
					ps.executeUpdate();
					dtm.setRowCount(0);
					tfid.setText("");
					tfht.setText("");
					tflv.setText("");
					tfpo.setText("");
					tfsdt.setText("");
					tfpro.setText("");

					loadata();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		btnFIND.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ResultSet rs;
				conn = new ConnectionDB();
				try {
					

					rs = conn.getStm().executeQuery("select * from khachhang where IDKH = N" + "'" + tfid.getText()
							+ "'" + " or NameKH = N" + "'" + tfht.getText() + "'" + " or Date = N" + "'"
							+ tflv.getText() + "'" + " or Sex = N" + "'" + tfpo.getText() + "'" + " or money = N"
							+ "'" + tfsdt.getText() + "'" + " or SPpay = N" + "'" + tfpro.getText() + "'");
					dtm.setRowCount(0);

					while (rs.next()) {
						dtm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6) });

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

	}

	public static void main(String args[]) {
		new khachhang();
	}

	public void loadata() {
		conn = new ConnectionDB();
		ResultSet rs;
		try {
			dtm.setRowCount(0);
			rs = conn.getStm().executeQuery("select * from khachhang order by IDKH");
			while (rs.next()) {
				dtm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
			}
		} catch (SQLException e) { // TODOAuto-generated catch block e.printStackTrace();
		}
	}
}
