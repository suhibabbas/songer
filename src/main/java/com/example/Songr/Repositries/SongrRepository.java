package com.example.Songr.Repositries;

import com.example.Songr.Models.Albums;
import org.springframework.data.repository.CrudRepository;

public interface SongrRepository extends CrudRepository<Albums,Integer> {
}
