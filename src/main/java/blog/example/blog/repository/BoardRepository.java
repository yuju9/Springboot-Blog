package blog.example.blog.repository;

import blog.example.blog.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    //JpaRepository가 데이터를 들고있음
}
