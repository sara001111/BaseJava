import javax.swing.JOptionPane;

import modelo.User;
import modelo.UserInsert;

public class Menu {

    public static void main(String[] args) {
        
        UserInsert model= new UserInsert();

        int menu=Integer.parseInt(JOptionPane.showInputDialog("CRUD EJEMPLO\n"+
        "1.-Insertar\n"+
        "2.-Seleccionar\n"+
        "3.-Modificar\n"+
        "4.-Eliminar"));

        switch(menu){

            case 1:

                User user=new User();

                user.setId(6);
                user.setNombre("Carlos");
                user.setContrasena("usuario6");

                if(model.addUser(user)){

                    System.out.println("GUARDADO");
                }else{
                    System.out.println("NO GUARDADO");
                }
            
            break;

            case 2:


            break;

            case 3:
            break;

            case 4:
            break;
        }

    }
    
}
