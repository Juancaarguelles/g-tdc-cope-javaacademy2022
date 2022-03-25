package com.thesis.persistence.repository;

import com.thesis.persistence.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Integer>
{
}
