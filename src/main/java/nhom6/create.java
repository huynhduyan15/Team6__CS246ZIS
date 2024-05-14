package nhom6;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Label;

public class create extends JFrame {
    private JTextField txtGhgf;

    public create() {
        JFrame frame = new JFrame("--WELCOME--");
        frame.getContentPane().setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon("D:/nhom6/cuoiky/nhom6");
        JButton jbtgv = new JButton("Nhập thông tin khách hàng");
        jbtgv.setIcon(logoIcon);

        jbtgv.setBackground(Color.ORANGE);
        jbtgv.setForeground(Color.RED);
        jbtgv.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jbtgv.setBounds(320, 394, 363, 61);
        jbtgv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new khachhang();
            }
        });

        ImageIcon imgReturn = new ImageIcon("D:/Textgithub/hinhom6/anh/huyl.jpg");
        JButton jbtreturn = new JButton("LOG OUT");
        jbtreturn.setIcon(imgReturn);
        jbtreturn.setBackground(Color.PINK);
        jbtreturn.setForeground(Color.BLACK);
        jbtreturn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jbtreturn.setBounds(838, 0, 178, 41);
        jbtreturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                frame.dispose();
            }
        });

       

		ImageIcon icon = new ImageIcon("D:/nhom6/hinh1.png");

		JLabel label = new JLabel();
		label.setText("");
		label.setIcon(icon);

		JPanel pink = new JPanel();
		pink.setBackground(Color.PINK);
		pink.setBounds(10, 38, 1016, 139);

		/*
		 * ImageIcon imgcreate = new
		 * JLabel(); jlbtao.setIcon(imgcreate); jlbtao.setText("NEW TABLE");
		 * jlbtao.setBounds(250,50, 250, 50);; jlbtao.setForeground(Color.RED);
		 * jlbtao.setFont(new Font("Times New Roman",Font.PLAIN, 18));
		 * 
		 * JPanel jptao = new JPanel(); jptao.setBackground(Color.ORANGE);
		 * jptao.setBounds(50, 250, 200, 40);
		 */

		ImageIcon welcome = new ImageIcon("D:/nhom6/hinh1.png");

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1040, 550);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		pink.add(label);
		frame.getContentPane().add(pink);
		
		frame.getContentPane().add(jbtgv);
			
		frame.getContentPane().add(jbtreturn);
		
		Label label_1 = new Label("Quản Lý Khách Hàng");
		label_1.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		label_1.setBackground(Color.CYAN);
		label_1.setBounds(259, 247, 529, 77);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("");
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(10, 183, 194, 330);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("");
		label_3.setBackground(Color.LIGHT_GRAY);
		label_3.setBounds(862, 183, 164, 330);
		frame.getContentPane().add(label_3);
		frame.setLocationRelativeTo(null);

	}

    public static void main(String[] args) {
        new create();
    }
}