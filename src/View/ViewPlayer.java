/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.DaoPlayer;
import VO.Player;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class ViewPlayer {
    private DaoPlayer dao;
    private ArrayList<Player> player = new ArrayList<>();
    
    public ViewPlayer() throws IOException{
        try{
            this.dao = new DaoPlayer();
        }catch (IOException ex){
                    JOptionPane.showMessageDialog(null,"no se pudo abrir el archivo");          
        }
    }
    public void menu(){
        String opcion=
                JOptionPane.showInputDialog(null, "1. crear\n2. Guardar\n3.leer ");
        if (opcion.equals("1")){
            String name = JOptionPane.showInputDialog(null, "Name:");
            String email= JOptionPane.showInputDialog(null, "Email:");
            Player player = new Player(name, email);
            this.player.add(player);
        }else if(opcion.equals("2")){
            try {
                this.dao.write(player);
            }catch (FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "error lectura");
            }
           
        }else if(opcion.equals("3")){
            try{
                ArrayList<Player> players = this.dao.read();
                for(Player p : players){
                    System.out.println(p);
                }
            }catch (FileNotFoundException ex){
                
            }
        }else {
            
        }
    }
}
