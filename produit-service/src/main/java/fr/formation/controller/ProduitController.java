package fr.formation.controller;

import fr.formation.model.Produit;
import fr.formation.dto.ProduitDTO;
import fr.formation.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produit> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProduitDTO one(@PathVariable Long id) {
        return service.getProduitComplet(id);
    }

    @PostMapping
    public Produit create(@RequestBody Produit p) {
        return service.save(p);
    }

    @PutMapping("/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
