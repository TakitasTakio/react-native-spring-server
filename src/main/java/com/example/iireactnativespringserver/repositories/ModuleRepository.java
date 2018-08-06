package com.example.iireactnativespringserver.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.iireactnativespringserver.models.Module;

public interface ModuleRepository extends CrudRepository <Module, Integer>
{

}
