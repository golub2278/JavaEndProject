package ByMaksim.finalProject.Repository;

import ByMaksim.finalProject.Model.Chairs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChairsRepository extends JpaRepository<Chairs, Long>
{
    Chairs findById(long id);
}
