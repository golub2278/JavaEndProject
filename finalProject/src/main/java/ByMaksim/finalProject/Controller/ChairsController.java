package ByMaksim.finalProject.Controller;

import ByMaksim.finalProject.Service.ChairsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChairsController
{
    private final ChairsService cs;

    public ChairsController(ChairsService cs) {
        this.cs = cs;
    }

    //@GetMapping("/{id}")
    //public String getChair(@PathVariable Long id)
    //{
       // return cs.getChairById(id).toString();
    //}

    @GetMapping("/{min}/{max}")
    public String getChairPriceBetween(@PathVariable double min, @PathVariable double max)
    {
        return cs.getChairsByPrice(min, max).toString();
    }
}
