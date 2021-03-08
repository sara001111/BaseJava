import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.User;
import modelo.UserInsert;

public class Menu {

    public static void main(String[] args) {

        UserInsert model = new UserInsert();

        int menu = Integer.parseInt(JOptionPane.showInputDialog(
                "CRUD EJEMPLO\n" + "1.-Insertar\n" + "2.-Seleccionar\n" + "3.-Modificar\n" + "4.-Eliminar"));

        switch (menu) {

        case 1:

            User user = new User();

            user.setId(8);
            user.setNombre("Dario");
            user.setContrasena("usuario8");

            if (model.addUser(user)) {

                System.out.println("GUARDADO");
            } else {
                System.out.println("NO GUARDADO");
            }

            break;

        case 2:
            ArrayList<String> data = new ArrayList<>();
            data.add("5");
            data.add("Antonio");
            ArrayList<User> list = model.selectUser("ID", data);

            for (int i = 0; i < list.size(); i++) {
                System.out.println(
                        list.get(i).getId() + " " + list.get(i).getNombre() + " " + list.get(i).getContrasena());
            }

            break;

        // for (User user2 : list)

        case 3:

            user = new User();

            user.setId(5);
            user.setNombre("Agustin");
            user.setContrasena("usuario8");

            if (model.modificarUser(user)) {

                System.out.println("MODIFICADO Y GUARDADO");
            } else {
                System.out.println("NO HAY CAMBIOS");
            }

            break;

        case 4:

            if (model.eliminarUser(123)) {

                System.out.println("ELIMINADO");
            } else {
                System.out.println("NO HAY CAMBIOS");
            }

            break;
        }

    }

}
