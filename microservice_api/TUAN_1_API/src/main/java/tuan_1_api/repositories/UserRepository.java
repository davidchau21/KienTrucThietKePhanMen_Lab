package tuan_1_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuan_1_api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
