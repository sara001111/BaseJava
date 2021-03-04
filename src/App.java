import modelo.PruebaConnection;
import modelo.User;
import modelo.UserInsert;

public class App {
    public static void main(String[] args) throws Exception {
       
        PruebaConnection connect =new PruebaConnection();

        if(connect!=null){
            System.out.println("prueba funcionando");

        }
        

       /* UserInsert model=new UserInsert();

        User user=new User();

        user.setId(123);
        user.setNombre("Francisco");
        user.setContrasena("usuario4");

        if(model.addUser(user)){

            System.out.println("GUARDADO");
        }else{
            System.out.println("NO GUARDADO");
        }*/
    }
}
