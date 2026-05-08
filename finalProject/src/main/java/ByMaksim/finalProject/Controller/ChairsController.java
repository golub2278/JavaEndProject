package ByMaksim.finalProject.Controller;

import ByMaksim.finalProject.Service.ChairsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChairsController
{
    private final ChairsService cs;

    public ChairsController(ChairsService cs) {
        this.cs = cs;
    }

    @GetMapping("/{id}")
    public String getChair(@PathVariable Long id)
    {
        return cs.getChairById(id).toString();
    }

    @PostMapping("/byprice")
    @ResponseBody
    public String getChairPriceBetween(@RequestParam double min, @RequestParam double max)
    {
        return cs.getChairsByPrice(min, max).toString();
    }

    @PostMapping("/bymodel")
    @ResponseBody
    public String getChairByModel(@RequestParam String model)
    {
        return cs.getChairByModel(model).toString();
    }
}
