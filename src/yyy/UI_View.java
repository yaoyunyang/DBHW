package yyy;


import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class UI_View {
	
	public static void main(String[] args){
		identification_selection is = new identification_selection();
		is.display();
		JButton tep = is.getVisitor();
		tep.addActionListener((ActionEvent e)->{
			is.closeWindow();
			login_ui lu= new login_ui();
			lu.display();
			lu.getConfirm().addActionListener((ActionEvent ae)->{
				if(lu.getT1().getText().equals("111")&& String.valueOf(lu.getT2().getPassword()).equals("222"))
				{
					System.out.println("账号密码正确");
					Control c = new Control();
//					c.excute("insert into members values('yyy','2017','xunliangu')");
//					c.excute_insert("insert into members values('yyyyyy','22','33')");
					System.out.println(c.excute_get("select * from members"));
				}
				else {
					JOptionPane.showMessageDialog(null, "密码错误", "",JOptionPane.ERROR_MESSAGE);  
					System.out.println("账号密码错误");
				}
			});
			lu.getBack().addActionListener((ActionEvent ae)->{
				lu.closeWindow();
				is.openWindow();
			});
		});
		
		
	}
}

class identification_selection{
	private JButton visitor;
	private JButton adimister;
	private JFrame jf;
	public JButton getVisitor() {
		return visitor;
	}
	//关闭窗口
	public void closeWindow() {
		jf.setVisible(false);
	}
	//打开窗口
	public void openWindow() {
		jf.setVisible(true);
	}
	public JButton getAdimister() {
		return adimister;
	}
	public void display() {
		jf = new JFrame("身份选择");
		visitor=new JButton("游客");
		adimister=new JButton("管理员");
		JLabel jl = new JLabel("请问你的身份是？");
		jf.setLayout(null);
		
		jf.setBounds(500, 500, 300,200);
		jl.setBounds(100, 30, 130, 70);
		visitor.setBounds(70,90,70,30);
		adimister.setBounds(155,90,70,30);
		
		jf.add(visitor);
		jf.add(adimister);
		jf.add(jl);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.setVisible(true);
	}

}

class login_ui{
	private JButton confirm;
	private JButton back;
	private JTextField t1;
	private JPasswordField t2;
	private JFrame frm;
	
	//打开窗口
	public void openWindow() {
		frm.setVisible(true);
	}
	
	public void closeWindow() {
		frm.setVisible(false);
	}
	public JTextField getT1() {
		return t1;
	}
	public JPasswordField getT2() {
		return t2;
	}
	String account;
	public String getAccount() {
		return account;
	}
	public JButton getConfirm() {
		return confirm;
	}
	public JButton getBack() {
		return back;
	}
	public void display() {
		frm = new JFrame();
		frm.setBounds(500,500,300, 200);
		frm.setTitle("密码验证");
		frm.setLayout(null);
		// 创建“用户名： ”标签 
		JLabel L1 = new JLabel("用户名: ");
		L1.setBounds(70, 45, 55, 20);
		// 创建文本框
		t1 = new JTextField(50);
		t1.setBounds(130, 45, 100, 20);
		// 创建“密码：”标签		
		JLabel L2 = new JLabel("密码: ");
		L2.setBounds(70, 75, 55, 20);
		//　 创建密码文本框,设置密码文本框的回显字符为"*"
		t2 = new JPasswordField(50);
		
		t2.setEchoChar('*');
		t2.setBounds(130, 75, 100, 20);
		// 创建“确定”按钮
		confirm = new JButton("确定");
		confirm.setBounds(70, 105, 80, 30);
		// 创建“清除”按钮
		back = new JButton("返回");
		back.setBounds(160, 105, 80, 30);
		// 将组件添加到frm中
		frm.add(t1);
		frm.add(L1);
		frm.add(L2);
		frm.add(t2);
		frm.add(confirm);
		frm.add(back);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}

class info_list{
	
}