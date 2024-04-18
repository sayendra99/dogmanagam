package com.Sayendra.DMS.repository;
import org.springframework.data.repository.CrudRepository;

import com.Sayendra.DMS.Models.Trainer;

import jakarta.persistence.Id;
public interface TrainerRepository extends CrudRepository<Trainer,Integer>
{

}
