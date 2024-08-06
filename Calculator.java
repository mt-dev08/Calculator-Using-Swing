package cal.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener {
    JFrame frame;
    JTextField screen;
    JButton [] nbtn = new JButton[10];
    JButton plusBtn, minBtn, mulBtn, divBtn, remBtn, zeroBtn, dzeroBtn, eqBtn, decBtn, acBtn, delBtn, perBtn, powBtn, sqrtBtn, cubeBtn;
    Font font = new Font("Ink.Free",Font.BOLD,35);
    Font font2 = new Font("Ink.Free",Font.BOLD,25);
    Font font3 = new Font("Ink.Free",Font.BOLD,20);
    JPanel panel;

    char opr;
    double num1,num2,result;

    public Calculator(){
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(400,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Screen

        screen = new JTextField("");
        screen.setBounds(25,25,335,50);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setFont(font);
        screen.setEditable(false);
        frame.add(screen);

        // Panel

        panel = new JPanel();
        panel.setBounds(25,100,335,375);
        panel.setLayout(new GridLayout(6,4));
        frame.add(panel);

        for (int i = 1; i < 10; i++) {
            nbtn[i] = new JButton(String.valueOf(i));
            panel.add(nbtn[i]);
            nbtn[i].setFont(font2);
            nbtn[i].setForeground(Color.WHITE);
            nbtn[i].setBackground(new Color(40,40,40));
            nbtn[i].addActionListener(this);

        }

        plusBtn = new JButton(" + ");
        plusBtn.setFont(font2);
        plusBtn.setForeground(Color.BLACK);
        plusBtn.setBackground(new Color(211, 211, 211));

        minBtn = new JButton(" - ");
        minBtn.setFont(font2);
        minBtn.setForeground(Color.BLACK);
        minBtn.setBackground(new Color(211, 211, 211));

        mulBtn = new JButton(" * ");
        mulBtn.setFont(font2);
        mulBtn.setForeground(Color.BLACK);
        mulBtn.setBackground(new Color(211, 211, 211));

        divBtn = new JButton(" / ");
        divBtn.setFont(font2);
        divBtn.setForeground(Color.BLACK);
        divBtn.setBackground(new Color(211, 211, 211));

        remBtn = new JButton(" % ");
        remBtn.setFont(font2);
        remBtn.setForeground(Color.BLACK);
        remBtn.setBackground(new Color(211, 211, 211));

        zeroBtn = new JButton(" 0 ");
        zeroBtn.setFont(font2);
        zeroBtn.setForeground(Color.WHITE);
        zeroBtn.setBackground(new Color(40,40,40));

        dzeroBtn = new JButton(" 00 ");
        dzeroBtn.setFont(font2);
        dzeroBtn.setForeground(Color.WHITE);
        dzeroBtn.setBackground(new Color(40,40,40));

        eqBtn = new JButton(" = ");
        eqBtn.setFont(font2);
        eqBtn.setForeground(Color.WHITE);
        eqBtn.setBackground(new Color(0,104,0));

        decBtn = new JButton(" . ");
        decBtn.setFont(font2);
        decBtn.setForeground(Color.WHITE);
        decBtn.setBackground(new Color(155,16,0));

        acBtn = new JButton(" AC ");
        acBtn.setFont(font2);
        acBtn.setForeground(Color.BLACK);
        acBtn.setBackground(new Color(211, 211, 211));

        delBtn = new JButton(" DL ");
        delBtn.setFont(font2);
        delBtn.setForeground(Color.BLACK);
        delBtn.setBackground(new Color(211, 211, 211));

        perBtn = new JButton(" 1/x ");
        perBtn.setFont(font2);
        perBtn.setForeground(Color.BLACK);
        perBtn.setBackground(new Color(211, 211, 211));

        powBtn = new JButton(" x² ");
        powBtn.setFont(font2);
        powBtn.setForeground(Color.BLACK);
        powBtn.setBackground(new Color(211, 211, 211));

        sqrtBtn = new JButton(" ²√x ");
        sqrtBtn.setFont(font3);
        sqrtBtn.setForeground(Color.BLACK);
        sqrtBtn.setBackground(new Color(211, 211, 211));

        cubeBtn = new JButton(" ³√x ");
        cubeBtn.setFont(font3);
        cubeBtn.setForeground(Color.BLACK);
        cubeBtn.setBackground(new Color(211, 211, 211));



        panel.add(acBtn);
        panel.add(delBtn);
        panel.add(remBtn);
        panel.add(divBtn);

        panel.add(perBtn);
        panel.add(powBtn);
        panel.add(sqrtBtn);
        panel.add(cubeBtn);

        panel.add(nbtn[7]);
        panel.add(nbtn[8]);
        panel.add(nbtn[9]);
        panel.add(mulBtn);

        panel.add(nbtn[4]);
        panel.add(nbtn[5]);
        panel.add(nbtn[6]);
        panel.add(minBtn);

        panel.add(nbtn[1]);
        panel.add(nbtn[2]);
        panel.add(nbtn[3]);
        panel.add(plusBtn);

        panel.add(dzeroBtn);
        panel.add(zeroBtn);
        panel.add(decBtn);
        panel.add(eqBtn);

        zeroBtn.addActionListener(this);
        dzeroBtn.addActionListener(this);
        decBtn.addActionListener(this);
        acBtn.addActionListener(this);
        delBtn.addActionListener(this);
        plusBtn.addActionListener(this);
        minBtn.addActionListener(this);
        divBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        remBtn.addActionListener(this);
        eqBtn.addActionListener(this);
        perBtn.addActionListener(this);
        sqrtBtn.addActionListener(this);
        cubeBtn.addActionListener(this);
        powBtn.addActionListener(this);


        frame.setLayout(null);
        frame.setVisible(true);

    }

//    public void actionPerformed(ActiveEvent e){
//
//    }
        public void actionPerformed(ActionEvent e){

            for (int i = 1; i < 10; i++) {
//                if(screen.getText()=="0")
                if(e.getSource()==nbtn[i]){
                    screen.setText((screen.getText().concat(String.valueOf(i))));
                }
            }

            if(e.getSource()==dzeroBtn){
                screen.setText((screen.getText().concat("00")));
            }

            if(e.getSource()==zeroBtn){
                screen.setText((screen.getText().concat("0")));
            }

            if(e.getSource()==decBtn){
                screen.setText((screen.getText().concat(".")));
            }

            if(e.getSource()==acBtn){
                screen.setText("");
            }

            if(e.getSource()==delBtn){
               String backspace;
               if(screen.getText().length()>0){
                   StringBuilder str = new StringBuilder(screen.getText());
                   str.deleteCharAt(screen.getText().length()-1);
                   backspace=str.toString();
                   screen.setText(backspace);
               }
            }

            if(e.getSource()==plusBtn){
                num1=Double.parseDouble(screen.getText());
                opr='+';
                screen.setText("");
            }

            if(e.getSource()==minBtn){
                num1=Double.parseDouble(screen.getText());
                opr='-';
                screen.setText("");
            }

            if(e.getSource()==mulBtn){
                num1=Double.parseDouble(screen.getText());
                opr='*';
                screen.setText("");
            }

            if(e.getSource()==divBtn){
                num1=Double.parseDouble(screen.getText());
                opr='/';
                screen.setText("");
            }

            if(e.getSource()==remBtn){
                num1=Double.parseDouble(screen.getText());
                opr='%';
                screen.setText("");
            }

            if(e.getSource()==perBtn){
                num1=Double.parseDouble(screen.getText());
                double c = 1/num1;
                screen.setText(String.valueOf(c));
            }

            if(e.getSource()==powBtn){
                num1=Double.parseDouble(screen.getText());
                double c = Math.pow(num1,2);
                screen.setText(String.valueOf(c));
            }

            if(e.getSource()==sqrtBtn){
                num1=Double.parseDouble(screen.getText());
                double c = Math.sqrt(num1);
                screen.setText(String.valueOf(c));
            }

            if(e.getSource()==cubeBtn){
                num1=Double.parseDouble(screen.getText());
                double c = Math.cbrt(num1);
                screen.setText(String.valueOf(c));
            }

            if(e.getSource()==eqBtn){
                try{
                    num2 = Double.parseDouble(screen.getText());
                    switch (opr){
                        case '+':
                        result=num1 + num2;
                        screen.setText(String.valueOf(result));
                        break;

                        case '-':
                             result=num1 - num2;
                            screen.setText(String.valueOf(result));
                            break;

                        case '*':
                             result=num1 * num2;
                            screen.setText(String.valueOf(result));
                            break;

                        case '/':
                             result=num1 / num2;
                            screen.setText(String.valueOf(result));
                            break;

                        case '%':
                             result=num1 % num2;
                            screen.setText(String.valueOf(result));
                            break;

                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"SYNTAX ERROR >>> ");
                    screen.setText("");

                }
            }





        }


    public static void main(String[] args) {
        new Calculator();


    }

}
