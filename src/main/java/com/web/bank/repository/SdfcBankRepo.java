package com.web.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.bank.model.SdfcBank;
@Repository
public interface SdfcBankRepo extends CrudRepository<SdfcBank, Long> {

}
