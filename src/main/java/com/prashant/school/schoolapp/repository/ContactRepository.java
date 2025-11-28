package com.prashant.school.schoolapp.repository;

import com.prashant.school.schoolapp.model.Contact;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);

    @Query(value = "select * from contact_msg c where c.status = :status", nativeQuery = true)
    Page<Contact> findByStatus(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Contact c set c.status = ?1 where c.contactId=?2")
    int updateStatusById(String status, int id);

    Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    int updateMsgStatus(String status, int id);

    @Query(nativeQuery = true)
    Page<Contact> findOpenMsgsNative(@Param("status") String Status, Pageable pageable);
    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    int updateMsgStatusNative(String status, int id);



    //----JDBC code removed to implement JPA
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public ContactRepository(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public int saveContactMsg(Contact contact){
//        String sql = "INSERT INTO contact_msg(name,mobile_num,email,subject,message,status,"+
//                "created_at, created_by) VALUES(?,?,?,?,?,?,?,?)";
//        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),
//                contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreatedAt(),
//                contact.getCreatedBy());
//    }
//
//    public List<Contact> findMsgsWithStatus(String status){
//        String sql = "SELECT * FROM contact_msg WHERE status = ?";
//        return jdbcTemplate.query(sql,new PreparedStatementSetter(){
//            public void setValues(PreparedStatement preparedStatement) throws SQLException{
//                preparedStatement.setString(1, status);
//            }
//        },new ContactRowMapper());
//    }
//    public int updateMsgStatus(int contactId, String status, String updatedBy){
//        String sql = "UPDATE contact_msg SET status = ?, updated_by = ?, updated_at = ? WHERE contact_id = ?";
//        return jdbcTemplate.update(sql, new PreparedStatementSetter(){
//            public void setValues(PreparedStatement preparedStatement) throws SQLException{
//                preparedStatement.setString(1,status);
//                preparedStatement.setString(2,updatedBy);
//                preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//                preparedStatement.setInt(4,contactId);
//
//            }
//        });
//    }
}
