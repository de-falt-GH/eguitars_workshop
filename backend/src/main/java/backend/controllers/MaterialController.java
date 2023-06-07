package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.models.Material;
import backend.services.MaterialService;

@RestController
public class MaterialController {
    @Autowired
    private MaterialService materials;

    @GetMapping("/materials")
    public List<Material> getAllMaterials() {
        return materials.getAll();
    }

    @PostMapping("/materials")
    public Material createMaterial(@RequestBody Material material) {
        materials.save(material);
        return material;
    }

    @DeleteMapping("/materials/{id}")
    public HttpStatus deleteMaterial(@PathVariable long id) {
        materials.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/materials/{id}")
    public HttpStatus UpdateMaterialNum(@PathVariable long id, @RequestBody int num) {
        materials.updateNumById(id, num);
        return HttpStatus.OK;
    }
}
