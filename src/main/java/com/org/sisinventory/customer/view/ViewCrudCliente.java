package com.org.sisinventory.customer.view;

import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.customer.repository.iRepositoryCustomerCopy;
import com.org.sisinventory.service.ValidateNumbers;

public class ViewCrudCliente {

    iRepositoryCustomerCopy repo = new iRepositoryCustomerCopy();

    private CustomerController controller;

    public ViewCrudCliente(CustomerController controller){
        this.controller = controller;
    }

    public void listCustomerView(){

        this.controller.listController().forEach(System.out::println);
    }

    public void searchIDCustomerView(){
        Integer ID = ValidateNumbers.capturarEntero("Agregue id de cliente para buscarlo");

        Customer customer  = controller.SearchCustomerIDController(String.valueOf(ID));

        if (customer != null){
            System.out.println(controller.SearchCustomerIDController(String.valueOf(ID)));
        }
        else {
            System.out.println("Cliente no encontrado");
        }


    }

    public void savedCustomerView() {
        Customer customer;
        int telephoneNumbers = 0;
        String identification = "";
        int IDNumbers;
        do {
            IDNumbers = ValidateNumbers.capturarEntero("Dígite un número entero");

            if (IDNumbers <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                IDNumbers = 0;
                continue;
            }
            identification = String.valueOf(IDNumbers);
            customer = controller.SearchCustomerIDController(identification);  // irepoCopy.searchCustomer(identification);

            if (customer != null) {
                System.out.println("Ya existe otro cliente con el número de cédula: %s. \n" + identification);
                IDNumbers = 0;
            }

        } while (IDNumbers <= 0);

        String name = ValidateNumbers.capturarCadenaCaracteres("Dígite nombres del cliente nuevo");
        String lastName = ValidateNumbers.capturarCadenaCaracteres("Dígite apellidos del cliente nuevo");

        do {
            telephoneNumbers = ValidateNumbers.capturarEntero("Dígite número de telefono");
            if (telephoneNumbers <= 0) {
                System.out.println("Número de teléfono debe de ser un valor positivo");
            }

            String address = ValidateNumbers.capturarCadenaCaracteres("Dígite dirección del cliente nuevo");
            String mail;
            while (true) {
                mail = ValidateNumbers.capturarCadenaCaracteres("Dígite el correo eléctronico del cliente");

                if (!ValidateNumbers.correoElectronicoValido(mail)) {
                    System.out.println("El correo eléctronico no es valido.");
                    continue;
                }
                break;
            }
            controller.SaveCustomerController(identification, name, lastName, String.valueOf(telephoneNumbers), address, mail);


        } while (telephoneNumbers <= 0);

    }

    public void UpdateCustomerView(){
        Customer customer;
        int telephoneNumbers = 0;
        String identification = "";
        int IDNumbers;
        do {
            IDNumbers = ValidateNumbers.capturarEntero("Dígite un número entero");

            if (IDNumbers <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                IDNumbers = 0;
                continue;
            }
            identification = String.valueOf(IDNumbers);
            customer = controller.SearchCustomerIDController(identification);

            if (customer != null) {
                System.out.println("Datos de cliente: \n Digite 'x' si quiere dejar los datos igual");
                System.out.println(customer + "\n\n");

                String name = ValidateNumbers.capturarCadenaCaracteres("Dígite nombres del cliente nuevo");
                String lastName = ValidateNumbers.capturarCadenaCaracteres("Dígite apellidos del cliente nuevo");

                do {
                    telephoneNumbers = ValidateNumbers.capturarEntero("Dígite número de telefono");
                    if (telephoneNumbers <= 0) {
                        System.out.println("Número de teléfono debe de ser un valor positivo");
                    }

                    String address = ValidateNumbers.capturarCadenaCaracteres("Dígite dirección del cliente nuevo");
                    String mail;
                    while (true) {
                        mail = ValidateNumbers.capturarCadenaCaracteres("Dígite el correo eléctronico del cliente");

                        if (!ValidateNumbers.correoElectronicoValido(mail)) {
                            System.out.println("El correo eléctronico no es valido.");
                            continue;
                        }
                        break;
                    }

                    controller.updateCustomerController(identification,name, lastName, String.valueOf(telephoneNumbers), address, mail);


                } while (telephoneNumbers <= 0);

            }

        } while (IDNumbers <= 0);


    }

    public void removeCustomerView(){
        Integer ID = ValidateNumbers.capturarEntero("Agregue id de cliente para buscarlo");
        controller.removeCustomerController(String.valueOf(ID));
    }


}
