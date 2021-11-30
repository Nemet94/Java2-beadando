package com.example.menhely;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MailRepository extends JpaRepository<Message, Long> {


}
