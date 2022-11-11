package com.alberto.currency.converter.app.repository;

import com.alberto.currency.converter.app.entity.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<CurrencyEntity, Integer> {

    CurrencyEntity findCurrencyEntityByTypeDestinyAndTypeOrigin(String typeDestiny, String typeOrigin);

    CurrencyEntity findCurrencyEntityByTypeOrigin(String typeOrigin);

}
