package aplicacionesmoviles.avanzado.todosalau.ejemplomvvm1.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import aplicacionesmoviles.avanzado.todosalau.ejemplomvvm1.model.Persona;

// Definición de la clase PersonaViewModel, que extiende de la clase ViewModel de Android
public class PersonaViewModel extends ViewModel {
    // Lista de personas
    private List<Persona> personas = new ArrayList<>();

    // Método para agregar una nueva persona a la lista
    public void agregarPersona(String name, int age, String email, String password) {
        personas.add(new Persona(name, age, email, password)); // Creación de una nueva instancia de Persona y agregación a la lista
    }

    // Método para obtener la lista de personas
    public List<Persona> getPersonas() {
        return personas; // Devuelve la lista de personas
    }
}