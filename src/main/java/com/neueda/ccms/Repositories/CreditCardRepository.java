package com.neueda.ccms.Repositories;

import com.neueda.ccms.Entities.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, Long> {
    @Query(value = "{card_number:'?0'}", delete = true)
    CreditCard deleteByCardNumber(String card_number);

    @Query("{card_number:'?0'}")
    CreditCard findByCardNumber(String card_number);

    @Query("{_id:'?0'}")
    Optional<CreditCard> findById(Long _id);

    public long count();

}
