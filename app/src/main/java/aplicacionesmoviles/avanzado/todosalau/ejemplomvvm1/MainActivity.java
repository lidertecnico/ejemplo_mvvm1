package aplicacionesmoviles.avanzado.todosalau.ejemplomvvm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


import aplicacionesmoviles.avanzado.todosalau.ejemplomvvm1.model.Persona;
import aplicacionesmoviles.avanzado.todosalau.ejemplomvvm1.viewmodel.PersonaViewModel;

public class MainActivity extends AppCompatActivity {
    private PersonaViewModel viewModel;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización del ViewModel utilizando ViewModelProvider
        viewModel = new ViewModelProvider(this).get(PersonaViewModel.class);

        // Referencias a los elementos de la interfaz de usuario
        ListView listView = findViewById(R.id.listView);
        EditText nombreEditText = findViewById(R.id.nombreEditText);
        EditText edadEditText = findViewById(R.id.edadEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button agregarButton = findViewById(R.id.agregarButton);

        // Configuración del adaptador para la lista
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        // Manejador de clics del botón "Agregar"
        agregarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String nombre = nombreEditText.getText().toString();
                String edadStr = edadEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validar que los campos no estén vacíos
                if (validarCampos(nombre, edadStr, email, password)) {
                    // Convertir la edad de String a entero
                    int edad = Integer.parseInt(edadStr);
                    // Agregar una nueva persona al ViewModel
                    viewModel.agregarPersona(nombre, edad, email, password);
                    // Limpiar los campos de entrada después de agregar una persona
                    limpiarCampos(nombreEditText, edadEditText, emailEditText, passwordEditText);
                    // Actualizar la lista
                    actualizarListView();
                } else {
                    // Mostrar un mensaje de advertencia si algún campo está vacío
                    mostrarMensaje("Por favor, complete todos los campos.");
                }
            }
        });
    }

    // Método para validar que los campos no estén vacíos
    private boolean validarCampos(String nombre, String edadStr, String email, String password) {
        return !nombre.isEmpty() && !edadStr.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }

    // Método para actualizar la lista de personas en la interfaz de usuario
    private void actualizarListView() {
        // Limpiar el adaptador antes de agregar elementos
        adapter.clear();
        // Obtener la lista de personas del ViewModel
        List<Persona> personas = viewModel.getPersonas();
        // Iterar sobre la lista de personas y agregarlas al adaptador
        for (Persona persona : personas) {
            // Formatear la información de la persona para mostrar en la lista
            String infoPersona = " Nombre: " + persona.getName() +
                    " \n Edad: " + persona.getAge() +
                    " \n Email: " + persona.getEmail() +
                    " \n Password: " + maskPassword(persona.getPassword());
            adapter.add(infoPersona);
        }
    }

    // Método para enmascarar la contraseña
    private String maskPassword(String password) {
        StringBuilder maskedPassword = new StringBuilder();
        // Reemplazar cada carácter de la contraseña con un asterisco
        for (int i = 0; i < password.length(); i++) {
            maskedPassword.append("*");
        }
        return maskedPassword.toString();
    }

    // Método para limpiar los campos de entrada después de agregar una persona
    private void limpiarCampos(EditText nombreEditText, EditText edadEditText, EditText emailEditText, EditText passwordEditText) {
        nombreEditText.getText().clear();
        edadEditText.getText().clear();
        emailEditText.getText().clear();
        passwordEditText.getText().clear();
    }

    // Método para mostrar mensajes en forma de Toast
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}