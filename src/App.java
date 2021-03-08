import modelo.PruebaConnection;
import modelo.User;
import modelo.UserInsert;
import modelo.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * PruebaConnection connect =new PruebaConnection();
         * 
         * if(connect!=null){ System.out.println("prueba funcionando");
         * 
         * }
         */

        Usuario model = new Usuario();

        User user = new User();

        user.setId(9);
        user.setNombre("Lucia2");
        user.setContrasena("usuario9");

        if (model.addUser(user)) {

            System.out.println("GUARDADO");
        } else {
            System.out.println("NO GUARDADO");
        }
    }
}
