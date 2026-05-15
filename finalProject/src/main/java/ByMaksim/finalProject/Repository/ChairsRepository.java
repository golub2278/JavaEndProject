package ByMaksim.finalProject.Repository;

import ByMaksim.finalProject.Model.Chairs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChairsRepository extends JpaRepository<Chairs, Long>
{
    Chairs findById(long id);
    List<Chairs> findByPriceBetween(double minPrice, double maxPrice);
    List<Chairs> findByModel(String model);
}
