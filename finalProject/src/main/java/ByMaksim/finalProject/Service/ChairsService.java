package ByMaksim.finalProject.Service;

import ByMaksim.finalProject.Model.Chairs;
import ByMaksim.finalProject.Repository.ChairsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairsService
{
    private final ChairsRepository cr;
    public ChairsService(ChairsRepository cr) {
        this.cr = cr;
    }

    public Chairs getChairById(Long id) {
        return cr.findById(id).orElseThrow(() -> new RuntimeException("Стул не найдена"));
    }
    public List<Chairs> getChairsByPrice(double minPrice, double maxPrice) {
        return cr.findByPriceBetween(minPrice, maxPrice);
    }
    public Chairs getChairByModel(String model) {
        return cr.findByModel(model);
    }

}
