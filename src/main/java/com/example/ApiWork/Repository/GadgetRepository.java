package com.example.ApiWork.Repository;

import com.example.ApiWork.Models.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GadgetRepository
        extends JpaRepository<Gadget,Integer> {
}
