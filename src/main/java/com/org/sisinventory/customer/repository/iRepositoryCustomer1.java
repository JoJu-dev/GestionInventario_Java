package com.org.sisinventory.customer.repository;


import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.repository.Repository;
import com.org.sisinventory.service.ValidateNumbers;

import java.util.List;

public class iRepositoryCustomer1 implements Repository<Customer> {
    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Customer searchCustomer(List<Customer> customers) {
        int IDNumbers;
        String identification = "";
        int telephoneNumbers = 0;
        do {
            IDNumbers = ValidateNumbers.capturarEntero("Dígite un número entero");

            if (IDNumbers <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                IDNumbers = 0;
                continue;
            }
        } while (IDNumbers <= 0);

        identification = String.valueOf(IDNumbers);


        return ValidateClient(customers, identification);

    }

    public Customer ValidateClient(List<Customer> customers, String ID) {
        Customer client = null;
        for (Customer customer : customers) {
            if (customer.getID().equals(ID)) {
                return customer;
            }
        }
        return client;
    }

    @Override
    public Customer save(List<Customer> customers) {
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
            customer = ValidateClient(customers, identification);

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
            return customer = new Customer(identification, name, lastName, String.valueOf(telephoneNumbers), address, mail);

        } while (telephoneNumbers <= 0);

    }

    @Override
    public void delete(Integer id) {

    }
}
