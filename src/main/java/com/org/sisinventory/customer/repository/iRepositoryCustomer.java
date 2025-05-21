package com.org.sisinventory.client.repository;


import com.org.sisinventory.client.model.Client;
import com.org.sisinventory.repository.Repository;

import java.util.List;

public class iRepositoryClient implements Repository<Client> {
    @Override
    public List<Client> list() {
        return null;
    }

    @Override
    public Client listId(Integer id) {
        return null;
    }

    @Override
    public void save(Client client) {

    }

    @Override
    public void delete(Integer id) {

    }
}
