package com.example.blogboard.repository;


import com.example.blogboard.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	
	@Modifying
	@Query(value="INSERT INTO reply(userId,boardId,content,createDate) VALUES(?,?,?,now())",nativeQuery = true)
	int mSave(int userId,int boardId,String content);

}
