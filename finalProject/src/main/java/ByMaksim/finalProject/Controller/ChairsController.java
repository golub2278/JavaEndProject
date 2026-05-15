package ByMaksim.finalProject.Controller;

import ByMaksim.finalProject.Model.Chairs;
import ByMaksim.finalProject.Service.ChairsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/MaChaise")
public class ChairsController
{
    private final ChairsService cs;

    public ChairsController(ChairsService cs) {
        this.cs = cs;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chairs>> getChairs()
    {
        final List<Chairs> chairs = cs.getChairs();
        return !chairs.isEmpty() ? ResponseEntity.ok(chairs) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Chairs>> ThreeChairsPlease()
    {
        final List<Chairs> Tempchairs = cs.getChairs();
        if (Tempchairs.size() < 2) return ResponseEntity.noContent().build();

        int i = (int)(((double) Tempchairs.size() /2 + 1) * Math.random());

        final List<Chairs> chairs = new ArrayList<>();
        chairs.add(Tempchairs.get(i));
        chairs.add(Tempchairs.get(i+1));
        chairs.add(Tempchairs.get(i+2));
        return ResponseEntity.ok(chairs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chairs> getChair(@PathVariable Long id)
    {
        final Chairs chairs = cs.getChairById(id);
        return chairs != null ? ResponseEntity.ok(chairs) : ResponseEntity.notFound().build();
    }

    @PostMapping("/choose")
    @ResponseBody
    public ResponseEntity<List<Chairs>> getChairPriceBetween(@RequestParam double min, @RequestParam double max,@RequestParam List<String> model)
    {
        final List<Chairs> chairsByPrice = cs.getChairsByPrice(min, max);
        if (chairsByPrice.isEmpty()) return ResponseEntity.notFound().build();

        final List<Chairs> chairs = new ArrayList<>();
        for (Chairs chair : chairsByPrice)
        {
            if (model.contains(chair.getModel()))
                chairs.add(chair);
        }
        return !chairs.isEmpty() ? ResponseEntity.ok(chairs) : ResponseEntity.notFound().build();
    }
}
