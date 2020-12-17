package com.kishorekumarkorada.IIOTDataVisualizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;

@Repository
public interface UserRepository extends JpaRepository<IIOTUserModel, String> {

	
}
