package ByMaksim.finalProject.Service;

import ByMaksim.finalProject.Model.Chairs;
import ByMaksim.finalProject.Repository.ChairsRepository;
import org.springframework.stereotype.Service;

@Service
public class ChairsService
{
    private final ChairsRepository cr;
    public ChairsService(ChairsRepository cr) {
        this.cr = cr;
    }

    public Chairs getBookById(Long id) {
        return cr.findById(id).orElseThrow(() -> new RuntimeException("Стул не найдена"));
    }
}
