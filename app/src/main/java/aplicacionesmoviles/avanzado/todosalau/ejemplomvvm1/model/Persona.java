package aplicacionesmoviles.avanzado.todosalau.ejemplomvvm1.model;

// Definición de la clase Persona
public class Persona {
    // Atributos de la clase Persona
    private String name; // Nombre de la persona
    private int age; // Edad de la persona
    private String email; // Correo electrónico de la persona
    private String password; // Contraseña de la persona

    // Constructor de la clase Persona
    public Persona(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    // Métodos para acceder y modificar el nombre
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos para acceder y modificar la edad
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Métodos para acceder y modificar el correo electrónico
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos para acceder y modificar la contraseña
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}