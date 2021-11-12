package com.example.menhely;

import org.springframework.data.repository.CrudRepository;
import com.example.menhely.Messages;
public interface MailRepository extends CrudRepository<Messages, Integer> {


}
