package org.lsi.service;


import java.math.BigInteger;
import java.util.List;

import org.lsi.entities.Contract;
import org.lsi.entities.Proprety;
import org.lsi.entities.User;
import org.lsi.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.tuples.generated.Tuple7;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    ContractRepository contRep;

    // Other methods...

    @Override
    public List<Contract> getAll() {
        return contRep.findAll();
    }

   /* @Override
    public List<Contract> getAllOfOwner(Long id) {
        // Your logic to get contracts based on owner id
        // ...

        // Return an appropriate value based on your logic
        return contRep.findByBuyerIdOrSellerId(id.toString(), id.toString());
    }*/

    @Override
    public Contract addLand(User buyer, User seller, BigInteger cost, String desc, Proprety prop, String date) {
        // Remove unnecessary blockchain-related logic
        Contract c = new Contract(buyer, seller, cost, date, prop, desc);
        contRep.save(c);

        // Non-blockchain related logic goes here
        // ...

        return c;
    }

    // Other methods...

}
